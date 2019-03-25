package com.marticles.airnet.exportservice.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author Marticles
 * @description Pollution
 * @date 2019/3/25
 */
public class Pollution {
    @Excel(name = "时间", orderNum = "0")
    private String time;
    @Excel(name = "监测站", orderNum = "1")
    private String site;
    @Excel(name = "城市", orderNum = "2")
    private String city;
    @Excel(name = "等级", orderNum = "3")
    private String level;
    @Excel(name = "SO2", orderNum = "4")
    private String so2;
    @Excel(name = "AQI", orderNum = "5")
    private Integer aqi;
    @Excel(name = "PM25", orderNum = "6")
    private String pm25;
    @Excel(name = "PM10", orderNum = "7")
    private String pm10;
    @Excel(name = "NO2", orderNum = "8")
    private String no2;
    @Excel(name = "CO", orderNum = "9")
    private String co;
    @Excel(name = "O3", orderNum = "10")
    private String oZone;

    public Pollution() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getoZone() {
        return oZone;
    }

    public void setoZone(String oZone) {
        this.oZone = oZone;
    }
}
