package com.marticles.airnet.apiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marticles
 * @description ApiController
 * @date 2019/3/12
 */
@RestController
@RequestMapping("/v1")
public class ApiController {


    @GetMapping("/rank")
    public String getRanks(@RequestParam("key") String key,
                               @RequestParam("area") String area,
                               @RequestParam("time") String time) {
        System.out.println(key+ area+ time);
        return (key + area+ time);
    }

}
