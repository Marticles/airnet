package com.marticles.airnet.mailservice.kafka;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mailservice.dao.AlarmDAO;
import com.marticles.airnet.mailservice.dao.MailDAO;
import com.marticles.airnet.mailservice.model.Mail;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Optional;

/**
 * @author Marticles
 * @description AlarmConsumer
 * @date 2019/3/9
 */
@Component
public class AlarmConsumer {

    @Value("${spring.mail.username}")
    String from;

    @Autowired
    private MailDAO mailDAO;

    @Autowired
    private AlarmDAO alarmDAO;

    @Autowired
    private JavaMailSender javaMailSender;

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "Alarm", partitions = {"0"})})
    public void alarmConsumer0(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            Mail mail = JSONObject.parseObject(kafkaMessage.get().toString(), Mail.class);
            sendMail(mail);
        }
    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "Alarm", partitions = {"1"})})
    public void alarmConsumer1(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            Mail mail = JSONObject.parseObject(kafkaMessage.get().toString(), Mail.class);
            sendMail(mail);
        }
    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "Alarm", partitions = {"2"})})
    public void alarmConsumer2(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            Mail mail = JSONObject.parseObject(kafkaMessage.get().toString(), Mail.class);
            sendMail(mail);
        }
    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "Alarm", partitions = {"3"})})
    public void alarmConsumer3(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            Mail mail = JSONObject.parseObject(kafkaMessage.get().toString(), Mail.class);
            sendMail(mail);
        }

    }

    private void sendMail(Mail mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(from, "AirNet", "UTF-8"));
            helper.setTo(mail.getEmail());
            helper.setSubject(mail.getTitle());
            helper.setText(mail.getContent(), true);
            javaMailSender.send(message);
            Date now = new Date();
            // 发送邮件记录
            mailDAO.addSendMail(mail.getTitle(), mail.getEmail(), mail.getContent(), now, "success");
            // 更新最后预警时间
            alarmDAO.updatedLastTime(mail.getAlarmId(),now);
        } catch (Exception e) {
            e.printStackTrace();
            mailDAO.addSendMail(mail.getTitle(), mail.getEmail(), mail.getContent(), new Date(), "fail");
        }
    }
}
