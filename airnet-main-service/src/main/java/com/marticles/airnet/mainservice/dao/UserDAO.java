package com.marticles.airnet.mainservice.dao;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Marticles
 * @description UserDAO
 * @date 2019/1/21
 */
@Mapper
public interface UserDAO {

    @Insert({"insert into user (name, email,password,type) values (#{name}, #{email}, #{password}, #{type})"})
    Integer addUser(UserRequest user);

    @Select({"select id, name, email, type from user where name = #{name} and password = #{password}"})
    User checkUser(UserRequest user);

    @Select({"select id, name, email, type from user where id != #{adminId}"})
    List<User> getAllUsers(Integer adminId);

    @Delete({"delete from user where id = #{userId}"})
    Integer deleteUser(Integer userId);

    @Update({"update user set name = #{name}, email = #{email}, type = #{type} where id = #{id}"})
    Integer updatedUser(User user);

    @Select({"select id, name, email, type from user where id = #{userId}"})
    User getUserById(Integer userId);
}
