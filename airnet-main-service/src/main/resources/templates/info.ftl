<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" href="/static/images/icon.png"/>
    <title>AirNet</title>
    <!-- Bootstrap Core CSS -->
    <link href="/static/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- chartist CSS -->
    <link href="/static/plugins/chartist-js/dist/chartist.min.css" rel="stylesheet">
    <link href="/static/plugins/chartist-js/dist/chartist-init.css" rel="stylesheet">
    <link href="/static/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
    <link href="/static/plugins/c3-master/c3.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/static/css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="/static/css/colors/purple.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="fix-header fix-sidebar card-no-border logo-center">
<!-- ============================================================== -->
<!-- Preloader - style you can find in spinners.css -->
<!-- ============================================================== -->
<div class="preloader">
    <svg class="circular" viewBox="25 25 50 50">
        <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
    </svg>
</div>
<!-- ============================================================== -->
<!-- Main wrapper - style you can find in pages.scss -->
<!-- ============================================================== -->
<div id="main-wrapper">
    <!-- ============================================================== -->
    <!-- Topbar header - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <header class="topbar">
        <nav class="navbar top-navbar navbar-expand-md navbar-light">
            <!-- ============================================================== -->
            <!-- Logo -->
            <!-- ============================================================== -->
            <div class="navbar-header">

                <a class="navbar-brand" href="/">
                    <!-- Logo icon --><b>
                    <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                    <!-- Dark Logo icon -->
                    <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
                         width="52" height="52"
                         viewBox="0 0 224 224"
                         style=" fill:#38D176;">
                        <g fill="none" fill-rule="nonzero" stroke="none" stroke-width="1" stroke-linecap="butt"
                           stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0"
                           font-family="none" font-weight="none" font-size="none" text-anchor="none"
                           style="mix-blend-mode: normal">
                            <path d="M0,224v-224h224v224z" fill="#ffffff" fill-opacity=0></path>
                            <g>
                                <g id="surface1">
                                    <path d="M84,100.33333c0,16.75261 -13.58073,30.33333 -30.33333,30.33333c-16.75261,0 -30.33333,-13.58073 -30.33333,-30.33333c0,-16.75261 13.58073,-30.33333 30.33333,-30.33333c16.75261,0 30.33333,13.58073 30.33333,30.33333z"
                                          fill="#ffffff"></path>
                                    <path d="M196,100.33333c0,16.75261 -13.58073,30.33333 -30.33333,30.33333c-16.75261,0 -30.33333,-13.58073 -30.33333,-30.33333c0,-16.75261 13.58073,-30.33333 30.33333,-30.33333c16.75261,0 30.33333,13.58073 30.33333,30.33333z"
                                          fill="#ffffff"></path>
                                    <path d="M51.33333,130.66667h116.66667c0,0 0,-23.22396 0,-32.66667h-116.66667z"
                                          fill="#ffffff"></path>
                                    <path d="M168,65.33333c0,20.61719 -16.71614,37.33333 -37.33333,37.33333c-20.61719,0 -37.33333,-16.71614 -37.33333,-37.33333c0,-20.61719 16.71614,-37.33333 37.33333,-37.33333c20.61719,0 37.33333,16.71614 37.33333,37.33333z"
                                          fill="#ffffff"></path>
                                    <path d="M107.33333,70c0,15.45833 -12.54167,28 -28,28c-15.45833,0 -28,-12.54167 -28,-28c0,-15.47656 12.54167,-28 28,-28c15.45833,0 28,12.52344 28,28z"
                                          fill="#ffffff"></path>
                                    <path d="M143.11719,91.71094c0,16.53386 -13.41667,29.93229 -29.95052,29.93229c-16.53386,0 -29.95052,-13.39843 -29.95052,-29.93229c0,-16.55208 13.41667,-29.95052 29.95052,-29.95052c16.53386,0 29.95052,13.39844 29.95052,29.95052z"
                                          fill="#ffffff"></path>
                                    <path d="M112,182c5.54167,5.54167 9.33333,9.33333 14,9.33333c4.66667,0 14,-1.54948 14,-11.57552c0,-7.47396 -5.59636,-10.9375 -8.09375,-11.72135c-0.54687,-0.4375 -26.41406,-3.40886 -61.90625,-14.03646l54.57813,0.05469c0,0 6.01562,-0.21875 9.29687,0.18229c6.41667,0.83854 12.37761,4.53907 16.07813,9.86198c3.68229,5.35937 4.92187,12.25 3.42708,18.53906c-1.44011,6.30729 -5.63282,11.86719 -11.2474,15.02083c-5.57812,3.20833 -12.46875,3.86458 -18.55729,1.89583c-10.97396,-3.39063 -11.57552,-17.55469 -11.57552,-17.55469z"
                                          fill="#9cd4ff"></path>
                                    <path d="M102.66667,60.66667c-0.52864,-10.62761 7.36458,-25.06511 19.17708,-30.04167c2.98958,-1.25781 6.01563,-1.98698 9.47917,-2.36979c0.85677,-0.21875 3.40886,-0.27344 4.84896,-0.25521c1.65885,0.03646 3.35417,0.14583 5.03125,0.41927c6.79948,0.875 13.21614,4.21094 18.64843,8.69531c11.08333,9.00521 16.67969,25.08333 13.32552,39.84896c-3.04427,14.94792 -14.51042,35.03646 -42.51042,35.03646c-65.33333,0 -107.33333,-14 -107.33333,-14l28.80208,-1.82292l57.71354,-2.84375l14.41927,-0.69271l7.23698,-0.34636c2.26042,-0.05469 4.48437,-0.47396 6.63542,-1.07552c8.69531,-2.46094 15.80468,-9.78906 18.02864,-18.57552c2.35156,-8.76823 -0.27344,-18.66667 -6.74479,-25.13802c-6.32552,-6.58073 -16.27864,-9.38802 -25.17448,-7.18229c-15.3125,5.32292 -21.58333,20.34375 -21.58333,20.34375z"
                                          fill="#d2edff"></path>
                                    <path d="M196.21875,77.65625c-3.29948,-6.70833 -8.18489,-12.45052 -13.98177,-16.69792c-3.11718,-2.35156 -6.54427,-4.15625 -10.13542,-5.48698c1.75,5.41406 2.38802,11.22917 1.76823,16.97136c6.98177,6.48958 10.73698,16.20573 9.73437,25.66667c-0.875,9.82552 -6.81771,18.99479 -15.36719,23.82552c-4.24739,2.46094 -9.09635,3.8099 -13.96354,4.08333l-15.47656,0.12761l-101.46354,-0.14583c0,0 32.8125,18.66667 112.29167,18.66667c13.85417,0 21.14583,-2.78906 27.87239,-6.78125c13.54427,-7.98437 22.47657,-22.78646 23.13282,-38.29948c0.32812,-7.4375 -1.1849,-15.20313 -4.41146,-21.92969z"
                                          fill="#d2edff"></path>
                                </g>
                            </g>
                        </g>
                    </svg>

                </b>
                    <span style="font-family: 'Microsoft JhengHei Light';font-weight:bold;color: white">AirNet</span>
                    <!--End Logo icon -->
                </a>
            </div>
            <!-- ============================================================== -->
            <!-- End Logo -->
            <!-- ============================================================== -->
            <div class="navbar-collapse">
                <ul class="navbar-nav mr-auto mt-md-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href=""
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                            <span>USST | 环境污染物数据平台</span>
                        </a>
                    </li>

                </ul>

                <!-- ============================================================== -->
                <!-- User profile and search -->
                <!-- ============================================================== -->
                <ul class="navbar-nav my-lg-0">

                    <#if isLogin=="false">
                     <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" id="2"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="icon-login"></i><a href="/login" style="color: white"">登录</a>
                     </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" id="2"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="icon-user-follow"></i><a href="/register" style="color: white"">注册</a>
                    </li>

                    </#if>
                    <#if isLogin=="true">
                    <!-- ============================================================== -->
                    <!-- Messages -->
                    <!-- ============================================================== -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" id="2"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="mdi mdi-email"></i>
                            <div class="notify" id="notify">
                                <!-- 新消息通知 -->
                            </div>
                        </a>
                        <div class="dropdown-menu mailbox dropdown-menu-right scale-up" aria-labelledby="2">
                            <ul>
                                <li>
                                    <div class="drop-title"><span id="notification_title">你有 ? 条新通知</span></div>
                                </li>
                                <li>
                                    <div class="message-center" id="notification">

                                    </div>
                                </li>
                                <li>
                                    <a class="nav-link text-center" href="javascript:void(0);">
                                        <strong>查看所有历史通知</strong> <i class="fa fa-angle-right"></i> </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <!-- ============================================================== -->
                    <!-- End Messages -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Profile -->
                    <!-- ============================================================== -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href=""
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="mdi mdi-account-circle"></i>
                            <span>${user.name}</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right scale-up">
                            <ul class="dropdown-user">
                                <li>
                                    <div class="dw-user-box">
                                        <div class="u-text">
                                            <h4>${user.name}</h4>
                                            <p class="text-muted">${user.email!}</p>
                                        </div>
                                </li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#"><i class="ti-user"></i> 修改信息</a></li>
                                <li><a href="#"><i class="ti-email"></i> 所有通知</a></li>
                                <li><a href="#"><i class="ti-settings"></i> 用户设置</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/logout"><i class="fa fa-power-off"></i> 注销</a></li>
                            </ul>
                        </div>
                    </li>

                </ul>

</#if>
            </div>
        </nav>
    </header>
    <!-- ============================================================== -->
    <!-- End Topbar header -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <aside class="left-sidebar">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
            <!-- Sidebar navigation-->
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li class="nav-small-cap">PERSONAL</li>
                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false"><i class="mdi mdi-gauge"></i><span
                                class="hide-menu">数据可视化</span></a>
                        <ul aria-expanded="false" class="collapse">
                   <#if isLogin=="true">
                            <li><a href="/viz/airflowmap">上海市高空气流图</a></li>
                            <li><a href="/viz/aqimap">全国空气质量指数(AQI)地图</a></li>
                            <li><a href="/viz/globalmap">全球污染物分布图</a></li>
                            <li><a href="/viz/line">标准折线图</a></li>
                            <li><a href="/viz/bar">标准柱状图</a></li>
                            <li><a href="/viz/scatter">标准散点图</a></li>
                            <li><a href="/viz/pie">标准饼图</a></li>
                            <li><a href="/viz/radar">标准雷达图</a></li>
                            <li><a href="/viz/funnel">标准漏斗图</a></li>
                            <li><a href="/viz/rose">南丁格尔玫瑰图</a></li>
                   </#if>
                            <#if isLogin=="false">
                            <li><a href="/viz/airflowmap">上海市高空气流图</a></li>
                            <li><a href="/viz/aqimap">全国空气质量指数(AQI)地图</a></li>
                            <li><a href="/viz/globalmap">全球污染物分布图</a></li>
                            </#if>

                        </ul>
                    </li>

                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false"><i class="mdi mdi-bullseye"></i><span
                                class="hide-menu">空气质量排行</span></a>
                        <ul aria-expanded="false" class="collapse">
                              <#if isLogin=="true">
                            <li><a href="/rank/sh">上海市空气质量实时/历史排行</a></li>
                            <li><a href="/rank/cn">全国空气质量实时排行</a></li>
                              </#if>
                            <#if isLogin=="false">
                            <li><a href="/rank/cn">全国空气质量实时排行</a></li>
                            </#if>
                        </ul>
                    </li>

                    <#if isLogin=="true">

                      <li>
                          <a class="has-arrow" href="#" aria-expanded="false"><i class="mdi mdi-chemical-weapon"></i><span
                                  class="hide-menu">污染物预测</span></a>
                          <ul aria-expanded="false" class="collapse">
                              <li><a href="/forecast/sh">上海市PM2.5浓度预测</a></li>
                              <li><a href="/forecast/cn">全国空气质量预报地图</a></li>
                              <li><a href="/forecast/csj">长三角空气质量预报地图</a></li>
                          </ul>
                      </li>

                    <li>
                        <a class="has-arrow " href="/alarm" aria-expanded="false"><i class="mdi mdi-alert"></i>
                            <span class="hide-menu">污染物预警</span></a>
                    </li>

                    <li>
                        <a class="has-arrow " href="/export" aria-expanded="false"><i class="mdi mdi-folder-download"></i>
                            <span class="hide-menu">历史数据导出</span></a>
                    </li>

                    <li>
                        <a class="has-arrow " href="/about-api" aria-expanded="false"><i class="mdi mdi-cube"></i>
                            <span class="hide-menu">API说明</span></a>
                    </li>
                    </#if>
                    <li>
                        <a class="has-arrow " href="/info" aria-expanded="false"><i class="mdi mdi-book-open-variant"></i>
                            <span class="hide-menu">相关知识</span></a>
                    </li>

                    <li>
                        <a class="has-arrow " href="/about-airnet" aria-expanded="false"><i class="mdi mdi-cloud-outline"></i>
                            <span class="hide-menu">关于AirNet</span></a>
                    </li>

                     <#if isLogin=="false">
                    <li>
                        <a class="has-arrow"  href="/login" aria-expanded="false"><i
                                class="mdi mdi-arrow-right-bold-circle-outline"></i>
                            <span class="hide-menu">登录后可体验更多功能(测试用户：test/test)</span></a>
                    </li>
                     </#if>

                </ul>
            </nav>
            <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
    </aside>
    <!-- ============================================================== -->
    <!-- End Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Page wrapper  -->
    <!-- ============================================================== -->
    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="row page-titles">
                <div class="col-md-5 col-8 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">主页</a></li>
                        <li class="breadcrumb-item">相关知识</li>
                    </ol>
                </div>

                <div class="">
                    <button class="right-side-toggle waves-effect waves-light btn-success btn btn-circle btn-sm pull-right m-l-10">
                        <i class="ti-settings text-white"></i></button>
                </div>

            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- 内容 -->
            <!-- ============================================================== -->
            <!-- Row -->
            <div class="row">
                <!-- Column -->
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body ">
                            <h4 class="card-title" align="center">环境污染物相关知识</h4>

                            <!-- Nav tabs -->
                            <div class="vtabs customvtab">
                                <ul class="nav nav-tabs tabs-vertical" role="tablist">
                                    <li class="nav-item"> <a class="nav-link active" data-toggle="tab" href="#aqi" role="tab"><span class="hidden-sm-up"><i class="ti-home"></i></span> <span class="hidden-xs-down">关于AQI</span> </a> </li>
                                    <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#aqi-table" role="tab"><span class="hidden-sm-up"><i class="ti-user"></i></span> <span class="hidden-xs-down">空气质量标准表</span></a> </li>
                                    <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#pm25" role="tab"><span class="hidden-sm-up"><i class="ti-email"></i></span> <span class="hidden-xs-down">PM2.5介绍</span></a> </li>
                                    <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#pm25-1" role="tab"><span class="hidden-sm-up"><i class="ti-email"></i></span> <span class="hidden-xs-down">PM2.5来源</span></a> </li>
                                    <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#pm25-2" role="tab"><span class="hidden-sm-up"><i class="ti-email"></i></span> <span class="hidden-xs-down">PM2.5危害</span></a> </li>

                                </ul>
                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div class="tab-pane active" id="aqi" role="tabpanel">
                                        <div class="p-20">
                                            <h4>
                                                <p style="text-indent:2em">
                                                    空气质量（air
                                                    quality）的好坏反映了空气污染程度，它是依据空气中污染物浓度的高低来判断的。空气污染是一个复杂的现象，在特定时间和地点空气污染物浓度受到许多因素影响。来自固定和流动污染源的人为污染物排放大小是影响空气质量的最主要因素之一，其中包括车辆、船舶、飞机的尾气、工业企业生产排放、居民生活和取暖、垃圾焚烧等。城市的发展密度、地形地貌和气象等也是影响空气质量的重要因素。
                                                </p>
                                            </h4>
                                            <h4>
                                                <p style="text-indent:2em">
                                                    空气质量指数（Air Quality
                                                    Index，简称AQI）是定量描述空气质量状况的无量纲指数，针对单项污染物的还规定了空气质量分指数，参与空气质量评价的主要污染物为细颗粒物、可吸入颗粒物、二氧化硫、二氧化氮、臭氧、一氧化碳等六项。
                                                </p>
                                            </h4>
                                        </div>
                                    </div>
                                    <div class="tab-pane  p-20" id="aqi-table" role="tabpanel">
                                        <table class="table table-bordered table-hover">
                                            <thead style="text-align:center;vertical-align:middle">
                                            <tr>
                                                <th>空气质量指数</th>
                                                <th>空气质量级别</th>
                                                <th>空气质量类别</th>
                                                <th style="text-align:center;">对健康影响情况</th>
                                                <th style="text-align:center;">建议采取措施</th>
                                            </tr>
                                            </thead>
                                            <tbody style="text-align:center;">
                                            <tr>
                                                <td>0~50</td>
                                                <td>一级</td>
                                                <td bgcolor="#7CCD7C">优</td>
                                                <td>空气质量令人满意，基本无空气污染</td>
                                                <td>各类人群可正常活动</td>
                                            </tr>
                                            <tr>
                                                <td>51~100</td>
                                                <td>二级</td>
                                                <td bgcolor="#B0E2FF">良</td>
                                                <td>空气质量可接受，但某些污染物可能对极少数异常敏感人群健康有较弱影响</td>
                                                <td>极少数异常敏感人群应减少户外活动</td>
                                            </tr>
                                            <tr>
                                                <td>101~150</td>
                                                <td>三级</td>
                                                <td bgcolor="#FFF68F">轻度污染</td>
                                                <td>易感人群症状有轻度加剧，健康人群出现刺激症状</td>
                                                <td>儿童、老年人及心脏病、呼吸系统疾病患者应减少长时间、高强度的户外锻炼</td>
                                            </tr>
                                            <tr>
                                                <td>151~200</td>
                                                <td>四级</td>
                                                <td bgcolor="#F4A460">中度污染</td>
                                                <td>进一步加剧易感人群症状，可能对健康人群心脏、呼吸系统有影响</td>
                                                <td>儿童、老年人及心脏病、呼吸系统疾病患者避免长时间、高强度的户外锻炼，一般人群适量减少户外运动</td>
                                            </tr>
                                            <tr>
                                                <td>201~300</td>
                                                <td>五级</td>
                                                <td bgcolor="#FF6A6A">重度污染</td>
                                                <td>心脏病和肺病患者症状显著加剧，运动耐受力降低，健康人群普遍出现症状</td>
                                                <td>儿童、老年人和心脏病、肺病患者应停留在室内，停止户外运动，一般人群减少户外运动</td>
                                            </tr>
                                            <tr>
                                                <td>>300</td>
                                                <td>六级</td>
                                                <td bgcolor="#EE3B3B">严重污染</td>
                                                <td>健康人群运动耐受力降低，有明显强烈症状，提前出现某些疾病</td>
                                                <td>儿童、老年人和病人应当留在室内，避免体力消耗，一般人群应避免户外活动</td>
                                            </tr>

                                            </tbody>
                                        </table>

                                    </div>
                                    <div class="tab-pane p-20" id="pm25" role="tabpanel">
                                        <h4>
                                            <p style="text-indent:2em ">
                                                PM2.5即细颗粒物，指环境空气中空气动力学当量直径小于等于 2.5
                                                微米的颗粒物。它能较长时间悬浮于空气中，其在空气中含量浓度越高，就代表空气污染越严重。虽然PM2.5只是地球大气成分中含量很少的组分，但它对空气质量和能见度等有重要的影响。与较粗的大气颗粒物相比，PM2.5粒径小，面积大，活性强，易附带有毒、有害物质（例如，重金属、微生物等），且在大气中的停留时间长、输送距离远，因而对人体健康和大气环境质量的影响更大。

                                            </p>
                                        </h4>

                                        <h4>
                                            <p style="text-indent:2em">
                                                2013年2月，全国科学技术名词审定委员会将PM2.5的中文名称命名为细颗粒物。细颗粒物的化学成分主要包括有机碳（OC）、元素碳（EC）、硝酸盐、硫酸盐、铵盐、钠盐（Na+）等。
                                            </p>
                                        </h4></div>
                                    <div class="tab-pane p-20" id="pm25-1" role="tabpanel">
                                        <h4>
                                            <p style="text-indent:2em ">
                                                虽然自然过程也会产生PM2.5，但其主要来源还是人为排放。人类既直接排放PM2.5，也排放某些气体污染物，在空气中转变成PM2.5。直接排放主要来自燃烧过程，比如化石燃料（煤、汽油、柴油）的燃烧、生物质（秸秆、木柴）的燃烧、垃圾焚烧。在空气中转化成PM2.5的气体污染物主要有二氧化硫、氮氧化物、氨气、挥发性有机物。其它的人为来源包括：道路扬尘、建筑施工扬尘、工业粉尘、厨房烟气。自然来源则包括：风扬尘土、火山灰、森林火灾、漂浮的海盐、花粉、真菌孢子、细菌。

                                            </p>
                                        </h4>

                                        <h4>
                                            <p style="text-indent:2em">
                                                PM2.5的来源复杂，成分自然也很复杂。主要成分是元素碳、有机碳化合物、硫酸盐、硝酸盐、铵盐。其它的常见的成分包括各种金属元素，既有钠、镁、钙、铝、铁等地壳中含量丰富的元素，也有铅、锌、砷、镉、铜等主要源自人类污染的重金属元素。
                                            </p>
                                        </h4>

                                        <h4>
                                            <p style="text-indent:2em">
                                                2000年有研究人员测定了北京的PM2.5来源：尘土占20%；由气态污染物转化而来的硫酸盐、硝酸盐、氨盐各占17%、10%、6%；烧煤产生7%；使用柴油、汽油而排放的废气贡献7%；农作物等生物质贡献6%；植物碎屑贡献1%。有趣的是，吸烟也贡献了1%，不过这只是个粗略的科学估算，并不一定准确。该研究中也测定了北京PM2.5的成分：含碳的颗粒物，硫酸根，硝酸根，铵根加在一起占了重量了69%
                                                。类似地，1999年测定的上海PM2.5中有41.6%是硫酸铵、硝酸铵，41.4%是含碳的物质。

                                            </p></div>
                                    <div class="tab-pane p-20" id="pm25-2" role="tabpanel">
                                        <h4>
                                            <p style="text-indent:2em ">
                                                虽然细颗粒物只是地球大气成分中含量很少的组分，但它对空气质量和能见度等有重要的影响。与较粗的大气颗粒物相比，细颗粒物粒径小，富含大量的有毒、有害物质且在大气中的停留时间长、输送距离远，因而对人体健康和大气环境质量的影响更大。研究表明，颗粒越小对人体健康的危害越大。细颗粒物能飘到较远的地方，因此影响范围较大。

                                            </p>
                                        </h4>

                                        <h4>
                                            <p style="text-indent:2em">
                                                细颗粒物对人体健康的危害要更大，因为直径越小，进入呼吸道的部位越深。10μm直径的颗粒物通常沉积在上呼吸道，2μm以下的可深入到细支气管和肺泡。细颗粒物进入人体到肺泡后，直接影响肺的通气功能，使机体容易处在缺氧状态。

                                            </p>
                                        </h4></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>




            </div>


            <!-- ============================================================== -->
            <!-- End PAge Content -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Right sidebar -->
            <!-- ============================================================== -->
            <!-- .right-sidebar -->
            <div class="right-sidebar">
                <div class="slimscrollright">
                    <div class="rpanel-title"> 配色 <span><i class="ti-close right-side-toggle"></i></span></div>
                    <div class="r-panel-body">
                        <ul id="themecolors" class="m-t-20">
                            <li><b>亮色</b></li>
                            <li><a href="javascript:void(0)" data-theme="default" class="default-theme">1</a></li>
                            <li><a href="javascript:void(0)" data-theme="green" class="green-theme">2</a></li>
                            <li><a href="javascript:void(0)" data-theme="red" class="red-theme">3</a></li>
                            <li><a href="javascript:void(0)" data-theme="blue" class="blue-theme working">4</a></li>
                            <li><a href="javascript:void(0)" data-theme="purple" class="purple-theme">5</a></li>
                            <li><a href="javascript:void(0)" data-theme="megna" class="megna-theme">6</a></li>
                            <li class="d-block m-t-30"><b>暗色</b></li>
                            <li><a href="javascript:void(0)" data-theme="default-dark" class="default-dark-theme">7</a>
                            </li>
                            <li><a href="javascript:void(0)" data-theme="green-dark" class="green-dark-theme">8</a></li>
                            <li><a href="javascript:void(0)" data-theme="red-dark" class="red-dark-theme">9</a></li>
                            <li><a href="javascript:void(0)" data-theme="blue-dark" class="blue-dark-theme">10</a></li>
                            <li><a href="javascript:void(0)" data-theme="purple-dark" class="purple-dark-theme">11</a>
                            </li>
                            <li><a href="javascript:void(0)" data-theme="megna-dark" class="megna-dark-theme ">12</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Right sidebar -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Container fluid  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <footer class="footer">
            © 2019 LJH's Graduation Project
        </footer>
        <!-- ============================================================== -->
        <!-- End footer -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Page wrapper  -->
    <!-- ============================================================== -->
</div>
<!-- ============================================================== -->
<!-- End Wrapper -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- All Jquery -->
<!-- ============================================================== -->
<script src="/static/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="/static/plugins/popper/popper.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- slimscrollbar scrollbar JavaScript -->
<script src="/static/js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="/static/js/waves.js"></script>
<!--Menu sidebar -->
<script src="/static/js/sidebarmenu.js"></script>
<!--stickey kit -->
<script src="/static/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
<script src="/static/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/static/plugins/sparkline/jquery.sparkline.min.js"></script>
<!--Custom JavaScript -->
<script src="/static/js/custom.min.js"></script>
<!-- ============================================================== -->
<!-- This page plugins -->
<!-- ============================================================== -->
<!--c3 JavaScript -->
<script src="/static/plugins/d3/d3.min.js"></script>
<script src="/static/plugins/c3-master/c3.min.js"></script>
<!-- chartist chart -->
<script src="/static/plugins/chartist-js/dist/chartist.min.js"></script>
<script src="/static/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
<!-- ============================================================== -->
<!-- Style switcher -->
<!-- ============================================================== -->
<script src="/static/plugins/styleswitcher/jQuery.style.switcher.js"></script>

</body>

</html>

<script>
    // 通知记数
    var msg_count = 0;

    function get_notification() {
        if (getCookie("user_id") != null) {
            $.ajax({
                url: '/notification/' + getCookie("user_id") + '?read-status=0',
                type: 'GET',
                dataType: 'json',
                headers: {
                    Authorization: getCookie("jwt_token")
                },
                contentType: 'application/json; charset=UTF-8',
                success: function (data) {
                    if (data.length > 0) {
                        var content = ''
                        $('#notification_title').html("你有 " + data.length + " 条未读通知");
                        msg_count = data.length;
                        $('#notify').html("<span class=\"heartbit\"></span><span class=\"point\"></span>");
                        for (let i of data) {
                            content += "<a id=\"notification-" + i.id + "\"><div class=\"mail-contnet\"> <h5>" + i.title + "</h5><h6>" + i.subTitle
                                    + "</h6><span class=\"mail-desc\">" + i.content + "</span> <span class=\"time\">"+i.createTime+"</span></div>"
                                    + "<span style=\"margin-top:25px;float:right\"> <button type=\"button\" id=\"read-" + i.id + "\" class=\"btn waves-effect waves-light btn-primary btn-sm \" value=" + i.id + ">标为已读</button></span>" + "</a>"
                        }
                        $('#notification').html(content);
                    } else {
                        $('#notification_title').html("暂无未读通知");
                        $('#notify').html("");
                        $('#notification').remove();
                    }

                },
                error: function (msg) {
                    console.log(msg);
                }
            });
        }
    }

    get_notification();

    $("#notification").on('click', "button[id^='read-']", function () {
        var id = this.value;
        $.ajax({
            url: '/notification/' + id,
            type: 'PUT',
            headers: {
                Authorization: getCookie("jwt_token")
            },
            success: function (data) {
                var count = $('#notification_title').val();
                $("#notification-" + id).remove();
                msg_count -= 1;
                $('#notification_title').html("你有 " + msg_count + " 条未读通知");
                $('#notification_title').val(msg_count);

            },
            error: function (msg) {
                console.log(msg);
            }
        });

    });

    function getCookie(name) {
        var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
        if (arr != null)
            return unescape(arr[2]);
        return null;
    }
</script>