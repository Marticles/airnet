package com.marticles.airnet.dataservice.dao;

import com.marticles.airnet.dataservice.model.Rank;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description RankDAO
 * @date 2019/2/7
 */
@Mapper
public interface RankDAO {

    String FIELDS = "site,aqi,level,primaryPollutant,pm25,pm10,co,no2,ozone1hour,so2";

    @Results({@Result(column = "ozone1hour", property = "oZone"), @Result(column = "primarypollutant", property = "primaryPollutant")})
    @Select({"(select " + FIELDS + " from hongkou where time = #{time})" +
            "union all(select " + FIELDS + " from jingan where time = #{time})" +
            "union all(select " + FIELDS + " from pudongchuansha where time = #{time})" +
            "union all(select " + FIELDS + " from pudongxinqu where time = #{time})" +
            "union all(select " + FIELDS + " from pudongzhangjiang where time = #{time})" +
            "union all(select " + FIELDS + " from putuo where time = #{time})" +
            "union all(select " + FIELDS + " from qingpudianshanhu where time = #{time})" +
            "union all(select " + FIELDS + " from shiwuchang where time = #{time})" +
            "union all(select " + FIELDS + " from xuhuishangshida where time = #{time})" +
            "union all(select " + FIELDS + " from yangpusipiao where time = #{time})"})
    List<Rank> getSiteRanks(@Param("time") Date time);
}
