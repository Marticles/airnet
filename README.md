# AirNet - 环境污染物数据分析与预测平台
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)
![](https://img.shields.io/badge/language-Java-orange.svg)

![](/img/index.png)

## 关于 AirNet

AirNet 是一个环境污染物数据分析与预测平台，采用微服务架构，基于 Spring Cloud (Finchley.SR2) 与 Flask 开发，监测数据来自[上海市环境监测中心](http://219.233.250.38/aqi/SiteAQI/SiteAQI)。

## 架构

| 服务                  | 端口 | 描述                 |
| --------------------- | ---- | -------------------- |
| spring-cloud-consul | 8500 | 服务注册中心 |
| airnet-config-service | 8888 | 服务配置中心         |
| airnet-zuul-gateway   | 9000 | 服务网关          |
| airnet-main-service   | 8080 | 前端展示服务(未完全前后端分离) |
| airnet-data-service   | 8081 | 数据服务(包括污染物数据与用户数据)     |
| airnet-mail-service | 8082 | 邮件服务 |
| airnet-export-service | 8083 | 数据导出服务 |
| airnet-forecast-service | 8084 | PM2.5 预测服务(Flask&Kears) |
| airnet-api-service | 8085 | API 服务 |


## 功能

主要功能包括数据可视化、空气质量排行、PM2.5 预测、污染物预警、历史数据导出、API(注：未登陆用户仅可使用部分数据可视化与部分空气质量排行功能)。

### 首页

首页展示采用百度地图，监测站详细数据来自本地污染物数据库，实时温度、风向与空气污染扩散条件数据来自和风天气 API，PM2.5 浓度一周趋势采用本地数据的 24 小时均值。

由于首页数据都是热点数据（首页内未做个性化），因此全部采用 Redis 作为缓存，默认半小时失效。

### 可视化

前三项可视化来自第三方，其余基于 Echarts 实现本地污染物数据可视化分析。

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

基于 Redis Zset 实现，默认一小时失效，其中全国空气质量实时排行数据来自腾讯天气 API。

- 上海市空气质量实时 / 历史排行
- 全国空气质量实时排行

### 污染物预测

上海市 PM2.5 浓度预测基于 Flask 与 Keras，后两项数据来自南京大学国际地球系统科学研究所区域空气质量预报系统（JAirFS）。

- 上海市PM2.5浓度预测
- 全国空气质量预报地图
- 长三角空气质量预报地图

#### 基于 Seq2seq 的 PM2.5 预测模型

TODO

### 污染物预警

通过 Spring 的 @Scheduled 注解实现定时任务，具体操作是通过查询数据库中对应监测站的最新一条数据与用户设置的预警阈值进行比较，超过预警阈值则发送站内信与邮件通知用户。

- 站内信通知
- 邮件通知

### 历史数据导出

TODO

### API

只有注册用户在 “API 说明” 页面中主动申请 API Key 后才可调用 API，提供以下三种数据，对于不同的用户可实现自定义的限流策略（包括每秒最大请求次数与每月最大请求次数）。

- 历史 / 实时污染物数据
- 历史 / 实时空气质量排行
- 上海市 PM2.5 预测数据

#### 污染物 API


#### 空气质量排行 API

#### PM2.5 预测数据 API

#### API 限流

由 Google  Guava RateLimiter 实现，若每秒请求次数超过最大每秒请求次数，或当月累计请求次数达到每月最大请求次数，则会触发限流。

![](/img/ratelimit.png)



## 技术

- FrontEnd: BootStrap / Echarts / Freemarker
- BackEnd: Spring Cloud Config / Zuul / Ribbon / Feign / Hystrix / Spring Boot / Mybatis
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
![](/img/alarm.png)

----------------------
![](/img/info.png)

----------------------
![](/img/login.png)


### 未登陆用户

----------------------
![](/img/unlogin.png)

### 管理员

TODO

