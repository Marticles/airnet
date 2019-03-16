package com.marticles.airnet.dataservice.dao;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Marticles
 * @description PollutionDAO
 * @date 2019/1/25
 */
@Mapper
public interface PollutionDAO {

    @Results({@Result(column = "ozone1hour", property = "oZone"), @Result(column = "primarypollutant", property = "primaryPollutant")})
    @Select({"select time,city,site,aqi,level,primarypollutant,pm25,pm10,co,no2,ozone1hour,so2 from ${site} where time between #{start} and #{end}"})
    List<HashMap<String, Object>> getAllPollution(@Param("site") String site, @Param("start") Date start, @Param("end") Date end);

    @Results({@Result(column = "ozone1hour", property = "oZone"), @Result(column = "primarypollutant", property = "primaryPollutant")})
    @Select({"select ${pollution}, site,city,time from ${site} where time between #{start} and #{end}"})
    List<HashMap<String, Object>> getPollutionForApi(@Param("site") String site, @Param("pollution") String pollution, @Param("start") Date start, @Param("end") Date end);

    @Select({"select ${pollution} from ${site} where time between #{start} and #{end}"})
    List<Float> getPollution(@Param("site") String site, @Param("pollution") String pollution, @Param("start") Date start, @Param("end") Date end);

    @Results({@Result(column = "time", property = "updatedTime")})
    @Select({"select time, city, site from ${site} order by time desc limit 1"})
    HashMap<String, Object> getSiteUpdatedTime(@Param("site") String site);

    @Select({"select time from ${site} where time between #{start} and #{end}"})
    List<Date> getTimeRange(@Param("site") String site, @Param("start") Date start, @Param("end") Date end);


}