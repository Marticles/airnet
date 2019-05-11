package com.marticles.airnet.mainservice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description ForecastDAO
 * @date 2019/5/11
 */
@Mapper
public interface ForecastDAO {

    @Select({"select time from ${site} where time between #{start} and #{end}"})
    List<Date> getForecastDate(@Param("site") String site, @Param("start") String start, @Param("end") String end);

    @Select({"select pm25 from ${site} where time between #{start} and #{end}"})
    List<Float> getForecastPM25(@Param("site") String site,@Param("start") String start, @Param("end") String end);


}
