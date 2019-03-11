package com.marticles.airnet.mailservice.dao;

import com.marticles.airnet.mailservice.model.Alarm;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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
    @Select({"select id, site, pollutant, threshold, email, user_id, start_time, last_time from alarm order by start_time desc"})
    List<Alarm> getAllAlarmList();

    @Update({"update alarm set last_time = #{time} where id = #{id}"})
    Integer updatedLastTime(@Param("id")Integer id, @Param("time")Date time);

}


