package com.marticles.airnet.dataservice.dao;

import com.marticles.airnet.dataservice.model.Notification;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Marticles
 * @description NotificationDAO
 * @date 2019/3/10
 */
@Mapper
public interface NotificationDAO {

    @Results({@Result(column = "read_status", property = "readStatus"), @Result(column = "create_time", property = "createTime")})
    @Select({"select id, user_id, title, sub_title, content, read_status, create_time from notification where user_id = #{userId} and read_status = 0"})
    List<Notification> getUnReadNotification(@Param("userId") Integer userId);

    @Results({@Result(column = "read_status", property = "readStatus"), @Result(column = "create_time", property = "createTime")})
    @Select({"select id ,user_id, title, sub_title, content, read_status, create_time from notification where user_id = #{userId}"})
    List<Notification> getAllNotification(@Param("userId") Integer userId);

    @Update("update notification set read_status = 1 where id = #{id}")
    Integer readNotification(@Param("id") Integer id);


}
