package com.marticles.airnet.mailservice.server;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mailservice.constant.AirNetConstants;
import com.marticles.airnet.mailservice.dao.AlarmDAO;
import com.marticles.airnet.mailservice.model.Alarm;
import com.marticles.airnet.mailservice.model.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author Marticles
 * @description AlarmService
 * @date 2019/3/6
 */
@Service
public class AlarmService {

    @Autowired
    AlarmDAO alarmDAO;

    @Autowired
    DataService dataService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void checkAlarm() {

        List<Alarm> alarmList = alarmDAO.getAllAlarmList();
        for (Alarm alarm : alarmList) {
            String site = alarm.getSite();
            String pollutant = alarm.getPollutant();
            Float threshold = alarm.getThreshold();
            String time = dataService.getSiteUpdatedTime(AirNetConstants.VISITOR_JWT, site).getString("updatedTime");
            JSONObject last_data = dataService.getPollution(AirNetConstants.VISITOR_JWT, site, pollutant, time, time);
            String realValue = last_data.getJSONArray("pollution").getString(0);

            if (Float.valueOf(realValue) > threshold) {
                Mail mail = new Mail();
                mail.setEmail(alarm.getEmail());
                mail.setPollutant(pollutant);
                DecimalFormat df = new DecimalFormat("0.00%");
                String percent = df.format((Float.valueOf(realValue) - threshold) / Float.valueOf(realValue));
                mail.setTitle("AirNet污染物预警：监测到" + site + "监测站的" + pollutant + "已超标" + percent);
                mail.setContent("<p>您好，这里是AirNet。</p><p>我们已监测到您设定的污染物：【" + pollutant + "】已超过预警值：【"
                        + threshold + "】</p><p>此次监测时间：【" + time + "】，监测值为：【" + realValue + "】</p><p>感谢您对AirNet的支持</p>");
                // 随机提交到不同的partition
                Integer partition = Math.abs(mail.hashCode() % AirNetConstants.ALARM_PARTITIONS);
                kafkaTemplate.send("Alarm", partition, String.valueOf(mail.hashCode()), JSON.toJSONString(mail));
            }


        }
    }

    @FeignClient(value = "airnet-zuul-gateway", fallback = DataService.VizFallBackService.class)
    public interface DataService {


        @GetMapping("/data/{site}/{pollution}")
        JSONObject getPollution(@RequestHeader("Authorization") String jwtToken,
                                @PathVariable(value = "site") String site,
                                @PathVariable(value = "pollution") String pollution,
                                @RequestParam(value = "start") String start,
                                @RequestParam(value = "end") String end);

        @GetMapping("/data/{site}/updated-time")
        JSONObject getSiteUpdatedTime(@RequestHeader("Authorization") String jwtToken,
                                      @PathVariable(value = "site") String site);


        @Slf4j
        @Component
        class VizFallBackService implements DataService {

            @Override
            public JSONObject getPollution(String jwtToken, String site, String pollution, String start, String end) {
                log.error("***********************************");
                log.error(String.format("Data service was disable! getPollution(%s, %s, %s, %s)", site, pollution, start, end));
                log.error("***********************************");
                return null;
            }

            @Override
            public JSONObject getSiteUpdatedTime(String jwtToken, String site) {
                log.error("***********************************");
                log.error(String.format("Data service was disable! getSiteUpdatedTime(%s)", site));
                log.error("***********************************");
                return null;
            }

        }
    }

}
