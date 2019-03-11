package com.marticles.airnet.mailservice.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author Marticles
 * @description MailDAO
 * @date 2019/3/10
 */
@Mapper
public interface MailDAO {

    @Insert({"insert into send_mail (title, to_email, content, send_time, status) values (#{title}, #{to}, #{content}, #{send_time}, #{status})"})
    Integer addSendMail(@Param("title")String title, @Param("to")String to, @Param("content")String content, @Param("send_time")Date date, @Param("status")String status);

}
