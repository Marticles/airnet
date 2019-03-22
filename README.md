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

### 1.首页

首页展示采用百度地图，监测站详细数据来自本地污染物数据库，实时温度、风向与空气污染扩散条件数据来自和风天气 API，PM2.5 浓度一周趋势采用本地数据的 24 小时均值。

由于首页数据都是热点数据（首页内未做个性化），因此全部采用 Redis 作为缓存，默认半小时失效。

### 2.可视化

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

### 3.空气质量排行

基于 Redis Zset 实现，默认一小时失效，其中全国空气质量实时排行数据来自腾讯天气 API。

- 上海市空气质量实时 / 历史排行
- 全国空气质量实时排行

### 4.污染物预测

上海市 PM2.5 浓度预测基于 Flask 与 Keras，后两项数据来自南京大学国际地球系统科学研究所区域空气质量预报系统（JAirFS）。

- 上海市PM2.5浓度预测
- 全国空气质量预报地图
- 长三角空气质量预报地图

#### 基于 Seq2seq 的 PM2.5 预测模型

TODO

### 5.污染物预警

通过 Spring 的 @Scheduled 注解实现定时任务，具体操作是通过查询数据库中对应监测站的最新一条数据与用户设置的预警阈值进行比较，超过预警阈值则发送站内信与邮件通知用户。

- 站内信通知
- 邮件通知

![](/img/mail.png)


### 6.历史数据导出

TODO

### 7.API

只有注册用户在 “API 说明” 页面中主动申请 API Key 后才可调用 API，提供以下三种数据，对于不同的用户可实现自定义的限流策略（包括每秒最大请求次数与每月最大请求次数）。

- 历史 / 实时污染物数据
- 历史 / 实时空气质量排行
- 上海市 PM2.5 预测数据

#### 污染物历史数据 API
URL：
```
api/v1/history?site={site}&pollutant={pollutant}&start={start_time}&end={end_time}&key={api_key}
```
参数含义如下：

|URL/参数|含义|
|:--|:--|
|site|监测点，为英文代码，如`jingan`、`hongkou`|
|pollutant|污染物，如`so2`、`pm25`，当为`all`时将返回全部污染物数据|
|start|开始时间，如`2018-01-01 01:00:00`|
|end|结束时间，如`2018-01-01 01:00:00`|
|key|API Key|

返回 JSON 字段含义如下：

| 字段             | 内容                                                         |
| ---------------- | ------------------------------------------------------------ |
| site             | 监测点，如`jingan`、`yangpusipiao`,`pudongxinqu`等           |
| time             | 污染物监测时间                                               |
| city             | 监测点所属城市                                               |
| aqi              | 空气质量指数(AQI)，即Air Quality Index，是定量描述空气质量状况的无纲量指数 |
| level            | 空气质量指数类别，有“优、良、轻度污染、中度污染、重度污染、严重污染”6类 |
| primaryPollutant | 首要污染物                                                   |
| pm25             | 颗粒物（粒径小于等于2.5μm）1小时平均                         |
| pm10             | 颗粒物（粒径小于等于10μm）1小时平均                          |
| co               | 一氧化碳1小时平均                                            |
| no2              | 二氧化氮1小时平均                                            |
| oZone            | 臭氧1小时平均                                                |
| so2              | 二氧化硫1小时平均                                            |


```
# 示例
api/v1/history?site=jingan&pollutant=all&start=2019-03-15 20:00:00&end=2019-03-16 00:00:00&key=52hD10R9vT2BX7or3

# 返回JSON
{
    "code": 0,
    "msg": "success",
    "data": {
        "name": "all pollutant",
        "result": [
            {
                "no2": "86",
                "site": "静安监测站",
                "pm25": "37",
                "city": "上海",
                "level": "良",
                "so2": "9",
                "aqi": 73,
                "pm10": "96",
                "primaryPollutant": "PM10",
                "time": "2019-03-15 20:00:00",
                "co": "0.9",
                "oZone": "68"
            },
                 ...
            {
                "no2": "42",
                "site": "静安监测站",
                "pm25": "23",
                "city": "上海",
                "level": "良",
                "so2": "7",
                "aqi": 59,
                "pm10": "67",
                "primaryPollutant": "PM10",
                "time": "2019-03-16 00:00:00",
                "co": "0.8",
                "oZone": "82"
            }
        ]
    }
}
```

#### 空气质量排行 API

URL：

```
api/v1/rank?area={area}&time={time}&order={order}}&key={api_key}
```

参数含义如下：

|URL/参数|含义|
|:--|:--|
|area|地区，目前仅支持`sh`(上海地区)、`cn`(全国)|
|pollutant|污染物，如`so2`、`pm25`，当为`all`时将返回全部污染物数据|
|time|时间，如`2019-01-01 01:00:00`|
|order|排行顺序，如`default`顺序、`reverse`逆序|
|key|API Key|

```
# 示例
/api/v1/rank?area=cn&time=2019-03-16 12:00:00&order=reverse&key=52hD10R9vT2BX7or3

# 返回JSON
{
    "code": 0,
    "msg": "success",
    "data": {
        "name": "air quality rank",
        "result": [
            {
                "aqi": 245,
                "level": "重度污染",
                "pm25": "194",
                "time": "2019-03-16 12:00:00",
                "city": "五家渠"
            },
            ...
            {
                "aqi": 18,
                "level": "优",
                "pm25": "4",
                "time": "2019-03-16 12:00:00",
                "city": "林芝地区"
            }
        ]
    }
}         
```

#### PM2.5 预测数据 API

URL：

```
api/v1/forecast?site={site}&start={start_time}&end={end_time}&key={api_key}
```

参数含义如下：

|URL/参数|含义|
|:--|:--|
|site|监测点，如`jingan`、`yangpusipiao`,`pudongxinqu`等|
|start|预测开始时间，如`2018-01-01 01:00:00`|
|end|预测结束时间，如`2018-01-01 01:00:00`|
|key|API Key|

```
# 示例
api/v1/forecast?site=yangpusipiao&start=2019-12-01 12:00:00&end=2019-12-20 12:00:00&key=api_key=52hD10R9vT2BX7or3

# 返回JSON
TODO
```

#### API Key 的生成策略

考虑到分布式环境下采用 UUID 直接生成 Key 可能会导致 Key 重复的问题，最终的生成策略采用 Snowflake 算法生成唯一 ID， 再对 ID 进行 HmacMD5 加密生成 API Key。

#### API 接口限流

基于 Zuul 与  Guava RateLimiter 实现，若用户的每秒请求次数超过 QPS 限制，或当月累计请求次数达到每月最大请求次数，则会触发限流。

![](/img/ratelimit.png)

----------------------

![](/img/ratelimit2.png)



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

![](/img/bar.png)

----------------------

![](/img/rose.png)

----------------------
![](/img/city_rank.png)

----------------------
![](/img/alarm.png)

----------------------
![](/img/apikey.png)

----------------------
![](/img/info.png)

----------------------
![](/img/login.png)


### 未登陆用户

----------------------
![](/img/visiter.png)

----------------------
![](/img/403.png)

### 后台管理

----------------------
![](/img/admin_user.png)

----------------------
![](/img/admin_api.png)