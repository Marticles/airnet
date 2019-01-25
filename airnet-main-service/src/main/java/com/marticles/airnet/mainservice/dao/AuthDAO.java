package com.marticles.airnet.mainservice.dao;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Marticles
 * @description AuthDAO
 * @date 2019/1/21
 */
@Mapper
public interface AuthDAO {

    @Insert({"insert into user (name, email,password,type) values (#{name},#{email},#{password},#{type})"})
    Integer addUser(UserRequest user);

    @Select({"select id, name, email, type from user where name=#{name} and password=#{password}"})
    User checkUser(UserRequest user);
}
