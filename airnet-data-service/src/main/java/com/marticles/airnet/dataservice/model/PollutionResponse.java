package com.marticles.airnet.dataservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description PollutionResponse
 * @date 2019/1/25
 */
@Data
public class PollutionResponse {
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    List<Date> time;
    List<Pollution> pollution;

}
