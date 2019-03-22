package com.marticles.airnet.mainservice.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author Marticles
 * @description NotificationDAO
 * @date 2019/3/22
 */
@Mapper
public interface NotificationDAO {

    @Insert({"insert into notification (user_id, title, sub_title, content, read_status, create_time) values (#{userId}, #{title}, #{subTitle}, #{content}, #{readStatus}, #{createTime})"})
    Integer addNotification(@Param("userId")Integer userId, @Param("title")String title, @Param("subTitle")String subTitle, @Param("content")String content, @Param("readStatus")Integer readStatus, @Param("createTime")Date createTime);

}
