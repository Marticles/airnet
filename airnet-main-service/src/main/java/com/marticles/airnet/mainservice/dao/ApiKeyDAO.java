package com.marticles.airnet.mainservice.dao;

import com.marticles.airnet.mainservice.model.ApiApplication;
import com.marticles.airnet.mainservice.model.ApiKey;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description ApiKeyDAO
 * @date 2019/3/16
 */
@Mapper
public interface ApiKeyDAO {

    @Insert({"insert into api_application (reason, send_email, user_id, user_name, create_time, status) values (#{reason}, #{sendEmail}, #{userId}, #{userName}, #{createTime}, #{status})"})
    Integer addApiApplication(@Param("reason") String reason, @Param("sendEmail") String sendEmail, @Param("userId") Integer userId, @Param("userName") String userName, @Param("createTime") Date createTime, @Param("status") Integer status);

    @Results({@Result(column = "send_email", property = "sendEmail"), @Result(column = "user_id", property = "userId"), @Result(column = "user_name", property = "userName"), @Result(column = "create_time", property = "createTime")})
    @Select({"select * from api_application where user_id = #{userId} order by create_time desc"})
    List<ApiApplication> getApiKeyStatus(@Param("userId") Integer userId);

    @Results({@Result(column = "send_email", property = "sendEmail"), @Result(column = "user_id", property = "userId"), @Result(column = "user_name", property = "userName"), @Result(column = "create_time", property = "createTime")})
    @Select({"select * from api_application  where status = 0 order by create_time desc "})
    List<ApiApplication> getApiKeyApplication();


    @Results({@Result(column = "user_id", property = "userId"), @Result(column = "user_key", property = "userKey"),
            @Result(column = "pre_second_request_limit", property = "preSecondRequestLimit"), @Result(column = "monthly_request_limit", property = "monthlyRequestLimit"),
            @Result(column = "all_request_count", property = "allRequestCount")})
    @Select({"select * from api_key where user_id = #{userId}"})
    ApiKey getApiKey(@Param("userId") Integer userId);

    @Results({@Result(column = "user_id", property = "userId"), @Result(column = "user_key", property = "userKey"),
            @Result(column = "pre_second_request_limit", property = "preSecondRequestLimit"), @Result(column = "monthly_request_limit", property = "monthlyRequestLimit"),
            @Result(column = "all_request_count", property = "allRequestCount")})
    @Select({"select * from api_key order by id "})
    List<ApiKey> getAllApiKey();

    @Update({"update api_application set status = #{status} where id = #{id}"})
    Integer updateApplicationStatus(@Param("id") Integer id, @Param("status") Integer status);


    @Select({"select count(0) from api_key where user_id = #{userId}"})
    Integer countApiKey(@Param("userId") Integer userId);


    @Insert({"insert into api_key (user_id,user_key,pre_second_request_limit,monthly_request_limit) values (#{userId},#{key},#{preSecondRequestLimit},#{monthlyRequestLimit})"})
    Integer addApiKey(@Param("userId") Integer userId, @Param("key") String key, @Param("preSecondRequestLimit") Integer preSecondRequestLimit, @Param("monthlyRequestLimit") Integer monthlyRequestLimit);

    @Update({"update api_key set user_key = #{key} ,pre_second_request_limit=#{preSecondRequestLimit}, monthly_request_limit= #{monthlyRequestLimit} where id = #{id}"})
    Integer updateApiKey(@Param("id") Integer userId, @Param("key") String key, @Param("preSecondRequestLimit") Integer preSecondRequestLimit, @Param("monthlyRequestLimit") Integer monthlyRequestLimit);


    @Update({"update api_key set pre_second_request_limit=#{preSecondRequestLimit}, monthly_request_limit= #{monthlyRequestLimit} where id = #{id}"})
    Integer updateApiKeyWithOutKey(@Param("id") Integer userId, @Param("preSecondRequestLimit") Integer preSecondRequestLimit, @Param("monthlyRequestLimit") Integer monthlyRequestLimit);


    @Delete({"delete from api_key where id = #{id}"})
    Integer deleteApiKey(Integer id);
}
