package com.marticles.airnet.mainservice.dao;

import com.marticles.airnet.mainservice.model.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Marticles
 * @description LogDAO
 * @date 2019/3/26
 */
@Mapper
public interface LogDAO {

    @Insert({"insert into log (request_time,auth_headers, request_url, user_ip, user_id, user_name, class, method, parameters,return_type)" +
            " values (#{requestTime},#{authHeaders},#{requestURL},#{userIP},#{userId},#{userName},#{className},#{methodName},#{parameters},#{returnType})"})
    Integer addLog(Log log);

    @Results({@Result(column = "request_url", property = "requestURL")
            , @Result(column = "user_ip", property = "userIP")
            , @Result(column = "user_name", property = "userName")
            , @Result(column = "user_id", property = "userId")
            , @Result(column = "class", property = "className")
            , @Result(column = "method", property = "methodName")
            , @Result(column = "auth_headers", property = "authHeaders")
            , @Result(column = "return_type", property = "returnType")})
    @Select({"select * from log"})
    List<Log> getLogs();

}
