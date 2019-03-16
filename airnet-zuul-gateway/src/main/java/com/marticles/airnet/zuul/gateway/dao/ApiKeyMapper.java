package com.marticles.airnet.zuul.gateway.dao;

import com.marticles.airnet.zuul.gateway.model.ApiKey;
import org.apache.ibatis.annotations.*;

/**
 * @author Marticles
 * @description ApiKeyMapper
 * @date 2019/3/12
 */
@Mapper
public interface ApiKeyMapper {

    @Results({@Result(column = "user_id", property = "userId"), @Result(column = "user_key", property = "userKey"),
            @Result(column = "pre_second_request_limit", property = "preSecondRequestLimit"), @Result(column = "monthly_request_limit", property = "monthlyRequestLimit"),
            @Result(column = "all_request_count", property = "allRequestCount")})
    @Select({"select * from api_key where user_key = #{key}"})
    ApiKey getApiKey(@Param("key") String key);

    @Select({"select count(0) from api_key where user_key = #{key}"})
    Integer checkApiKey(@Param("key") String key);


}
