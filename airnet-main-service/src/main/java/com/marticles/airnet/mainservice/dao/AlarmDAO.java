package com.marticles.airnet.mainservice.dao;

import com.marticles.airnet.mainservice.model.Alarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Marticles
 * @description AlarmDAO
 * @date 2019/3/6
 */
@Mapper
public interface AlarmDAO {

    @Results({@Result(column = "user_id", property = "userId"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "last_time", property = "lastTime")})
    @Select({"select id, site, pollutant, threshold, email, user_id, start_time, last_time from alarm where user_id = #{id}"})
    List<Alarm> getAlarmList(Integer id);
}
