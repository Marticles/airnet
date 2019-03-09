# AirNet - 环境污染物数据分析与预测平台
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)
![](https://img.shields.io/badge/language-Java-orange.svg)

![](/img/index.png)

## 关于 AirNet

AirNet 是一个环境污染物数据分析与预测平台，采用微服务架构，基于 Spring Cloud(Finchley.SR2) 与 Flask 开发，监测数据来自[上海市环境监测中心](http://219.233.250.38/aqi/SiteAQI/SiteAQI)。

## 架构

| 服务                  | 端口 | 描述                 |
| --------------------- | ---- | -------------------- |
| spring-cloud-consul | 8500 | 服务注册中心 |
| airnet-config-service | 8888 | 服务配置中心         |
| airnet-zuul-gateway   | 9000 | 服务网关          |
| airnet-main-service   | 8080 | 前端展示服务(未完全前后端分离) |
| airnet-data-service   | 8081 | 污染物数据服务     |
| airnet-mail-service | 8082 | 邮件服务 |
| airnet-export-service | 8083 | 数据导出服务 |
| airnet-forecast-service | 8084 | PM2.5 预测服务(Flask) |
| airnet-api-service | 8085 | API 服务 |


## 功能

主要功能包括数据可视化、空气质量排行、PM2.5 预测、污染物预警、历史数据导出、API。

### 可视化

- 上海市高空气流图
- 全国空气质量指数(AQI)地图
- 全球污染物分布图
- 标准折线图
- 标准散点图
- 标准饼图
- 标准雷达图
- 标准漏斗图
- 南丁格尔玫瑰图

### 空气质量排行

- 上海市空气质量实时 / 历史排行
- 全国空气质量实时排行

### 污染物预测

- 上海市PM2.5浓度预测
- 全国空气质量预报地图
- 长三角空气质量预报地图

### 污染物预警

TODO

### 历史数据导出

TODO

### API

TODO

## 技术

- FrontEnd: Freemarker / BootStrap / Echarts
- BackEnd: Spring Cloud Config / Zuul / Ribbon / Feign / Hystrix / Quartz / Mybatis
- DB: MySQL / Redis
- MQ: Kafka

## 展示

![](/img/wind_map.png)

----------------------

![](/img/aqi_map.png)

----------------------

![](/img/line.png)

----------------------
![](/img/city_rank.png)

----------------------
![](/img/login.png)





