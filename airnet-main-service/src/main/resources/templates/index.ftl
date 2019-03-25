<#--noinspection ALL-->
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
    <link href="/static/css/index.css" rel="stylesheet">
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
                         <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" id="nav-link-1"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             <i class="icon-login"></i><a href="/login" style="color: white"">登录</a>
                     </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" id="nav-link-2"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="icon-user-follow"></i><a href="/register" style="color: white"">注册</a>
                    </li>
                    </#if>
                    <#if isLogin=="true">
                    <!-- ============================================================== -->
                    <!-- Messages -->
                    <!-- ============================================================== -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" id="nav-link-3"
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
                        <a class="has-arrow " href="/export" aria-expanded="false"><i
                                class="mdi mdi-folder-download"></i>
                            <span class="hide-menu">历史数据导出</span></a>
                    </li>

                    <li>
                        <a class="has-arrow " href="/about-api" aria-expanded="false"><i class="mdi mdi-cube"></i>
                            <span class="hide-menu">API说明</span></a>
                    </li>
                    </#if>
                    <li>
                        <a class="has-arrow " href="/info" aria-expanded="false"><i
                                class="mdi mdi-book-open-variant"></i>
                            <span class="hide-menu">相关知识</span></a>
                    </li>

                    <li>
                        <a class="has-arrow " href="/about-airnet" aria-expanded="false"><i
                                class="mdi mdi-cloud-outline"></i>
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
                        <li class="breadcrumb-item"></li>
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
                <div class="col-lg-8">
                    <div class="card">
                        <div class="card-header">
                            <span>上海市监测站地图 (Updated on ${updatedTime!})</span>
                            <div class="card-actions">
                                <a class="" data-action="collapse"><i class="ti-minus"></i></a>
                                <a class="btn-minimize" data-action="expand"><i class="mdi mdi-arrow-expand"></i></a>
                                <a class="btn-close" data-action="close"><i class="ti-close"></i></a>
                            </div>
                        </div>
                        <div class="card-body ">

                            <div id="allmap" style="width:780px; height:400px;margin:0 auto;"></div>
                        </div>

                    </div>
                </div>
                <!-- 地图结束 -->

                <div class="col-lg-4">
                    <div class="card">
                        <img class="" src="/static/images/background/weatherbg.jpg" alt="Card image cap">
                        <div class="card-img-overlay" style="height:110px;">
                            <h3 class="card-title text-white m-b-0 dl">${weatherInfo.city!'上海'}</h3>
                            <small class="card-text text-white font-light">${weatherInfo.time!}</small>
                            <br>
                            <small class="card-text text-white">${weatherInfo.airInfo!'和风天气API暂不可用...'}</small>
                        </div>
                        <div class="card-body weather-small">
                            <div class="row">
                                <div class="col-6 b-r align-self-center">
                                    <div class="d-flex">
                                        <#if weatherInfo.weather=="晴">
                                            <div class="display-6 text-info"><i class="wi wi-day-sunny"></i></div>
                                            <div class="m-l-20">
                                                <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}<sup>°C</sup>
                                                </h3>
                                                <small>>${weatherInfo.weather!}</small>
                                            </div>
                                        <#elseif weatherInfo.weather=="多云"||weatherInfo.weather=="少云"||weatherInfo.weather=="晴间多云"||weatherInfo.weather=="阴">
                                        <div class="display-6 text-info"><i class="wi wi-day-cloudy"></i></div>
                                        <div class="m-l-20">
                                            <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}
                                                <sup>°C</sup></h3>
                                            <small>${weatherInfo.weather!}</small>
                                        </div>
                                        <#elseif weatherInfo.weather=="有风"||weatherInfo.weather=="微风"||weatherInfo.weather=="和风"||weatherInfo.weather=="清风">
                                        <div class="display-6 text-info"><i class="wi wi-day-cloudy-windy"></i></div>
                                        <div class="m-l-20">
                                            <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}
                                                <sup>°C</sup></h3>
                                            <small>${weatherInfo.weather!}</small>
                                        </div>
                                        <#elseif weatherInfo.weather=="阵雨"||weatherInfo.weather=="强阵雨"||weatherInfo.weather=="雷阵雨"||weatherInfo.weather=="强雷阵雨"
                                        ||weatherInfo.weather=="小雨"||weatherInfo.weather=="中雨"||weatherInfo.weather=="大雨"||weatherInfo.weather=="毛毛雨/细雨"
                                        ||weatherInfo.weather=="暴雨"||weatherInfo.weather=="大暴雨"||weatherInfo.weather=="冻雨"||weatherInfo.weather=="冻雨"||weatherInfo.weather=="冻雨"
                                        ||weatherInfo.weather=="小到中雨"||weatherInfo.weather=="中到大雨"||weatherInfo.weather=="大到暴雨"||weatherInfo.weather=="雨">
                                        <div class="display-6 text-info"><i class="wi wi-day-rain"></i></div>
                                        <div class="m-l-20">
                                            <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}
                                                <sup>°C</sup></h3>
                                            <small>${weatherInfo.weather!}</small>
                                        </div>
                                        <#elseif weatherInfo.weather=="薄雾"||weatherInfo.weather=="雾"||weatherInfo.weather=="霾"||weatherInfo.weather=="浓雾"||weatherInfo.weather=="中度霾"
                                        ||weatherInfo.weather=="重度霾"||weatherInfo.weather=="大雾">
                                        <div class="display-6 text-info"><i class="wi wi-day-haze"></i></div>
                                        <div class="m-l-20">
                                            <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}
                                                <sup>°C</sup></h3>
                                            <small>${weatherInfo.weather!}</small>
                                        </div>
                                        <#elseif weatherInfo.weather=="热">
                                        <div class="display-6 text-info"><i class="wi wi-hot"></i></div>
                                        <div class="m-l-20">
                                            <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}
                                                <sup>°C</sup></h3>
                                            <small>${weatherInfo.weather!}</small>
                                        </div>
                                        <#elseif weatherInfo.weather=="冷">
                                        <div class="display-6 text-info"><i class="wi wi-thermometer-exterior"></i>
                                        </div>
                                        <div class="m-l-20">
                                            <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}
                                                <sup>°C</sup></h3>
                                            <small>${weatherInfo.weather!}</small>
                                        </div>
                                        <#else>
                                        <div class="display-6 text-info"><i class="wi wi-thermometer"></i></div>
                                        <div class="m-l-20">
                                            <h3 class="font-light text-info m-b-0">${weatherInfo.temperature!}
                                                <sup>°C</sup></h3>
                                            <small>${weatherInfo.weather!}</small>
                                        </div>
                                        </#if>
                                    </div>
                                </div>
                                <div class="col-6 text-center">
                                    <h3 class="font-light m-b-0">${weatherInfo.airStatus!}</sup></h3>
                                    <small>空气污染扩散条件指数</small>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-wrap">
                                <div>
                                    <h3 class="card-title">上海市PM2.5浓度</h3>
                                    <h6 class="card-subtitle">一周历史趋势</h6>
                                </div>
                                <div class="ml-auto align-self-center">
                                    <ul class="list-inline m-b-0">
                                        <li>
                                            <h6 class="text-muted text-info"><i class="fa fa-circle font-10 m-r-10"></i>PM2.5（μg/m3）
                                            </h6></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="pm25 ct-charts"></div>

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
<!-- BaiduMap-->
<script src="http://api.map.baidu.com/api?v=2.0&ak=uDNbzypTGIdYSsNqHVhvSr7Q5tPEuWmB"></script>

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

    var map = new BMap.Map("allmap");    // 创建Map实例
    map.centerAndZoom(new BMap.Point(121.544779, 31.232901), 12);  // 初始化地图,设置中心点坐标和地图级别
    //添加地图类型控件
    map.addControl(new BMap.MapTypeControl({
        mapTypes: [
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]
    }));
    map.setCurrentCity("上海");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl());
    map.addControl(new BMap.MapTypeControl());
    // 添加定位控件
    var geolocationControl = new BMap.GeolocationControl();
    geolocationControl.addEventListener("locationSuccess", function (e) {
        // 定位成功事件
        var address = '';
        address += e.addressComponent.province;
        address += e.addressComponent.city;
        address += e.addressComponent.district;
        address += e.addressComponent.street;
        address += e.addressComponent.streetNumber;
        alert("当前定位地址为：" + address);
    });
    geolocationControl.addEventListener("locationError", function (e) {
        // 定位失败事件
        alert(e.message);
    });
    map.addControl(geolocationControl);

    var jingan_point = new BMap.Point(121.436183, 31.230475);
    var hongkou_point = new BMap.Point(121.484901, 31.280611);
    var pdchuansha_point = new BMap.Point(121.713507, 31.194598);
    var pdxinqu_point = new BMap.Point(121.544779, 31.232901);
    var pdzhangjiang_point = new BMap.Point(121.588475, 31.207949);
    var putuo_point = new BMap.Point(121.417679, 31.241087);
    var qingpu_point = new BMap.Point(121.099302, 31.140646);
    var shiwuchang_point = new BMap.Point(121.488848, 31.208004);
    var xuhui_point = new BMap.Point(121.42531, 31.167918);
    var yangpu_point = new BMap.Point(121.544531, 31.270083);

    function gen_color(aqi) {
        if (aqi < 50) {
            var color = "#1DF01D"
        }
        else if (aqi >= 50 && aqi < 100) {
            var color = "#00BFFF"
        }
        else if (aqi >= 100 && aqi < 150) {
            var color = "#FFFF00"
        }
        else if (aqi >= 150 && aqi < 200) {
            var color = "#FFD700"
        }
        else if (aqi >= 200 && aqi < 300) {
            var color = "#FF8C00"
        }
        else if (aqi >= 300) {
            var color = "#FF4500"
        }
        else {
            var color = "#FFFFFF"
        }
        return color;
    }

    function gen_marker(point, aqi) {
        var color = gen_color(aqi);
        var marker = new BMap.Marker(point, {
            icon: new BMap.Symbol(BMap_Symbol_SHAPE_POINT, {
                scale: 1,//图标缩放大小
                fillColor: color,//填充颜色
                fillOpacity: 1,//填充透明度
                strokeWeight: 0.5,
                strokeColor: "#696969",
            })
        });
        return marker;
    }

    var jingan_marker = gen_marker(jingan_point,${jingan.aqi!'0'});
    var hongkou_marker = gen_marker(hongkou_point,${hongkou.aqi!'0'});
    var pdchuansha_marker = gen_marker(pdchuansha_point,${pdchuansha.aqi!'0'});
    var pdxinqu_marker = gen_marker(pdxinqu_point,${pdxinqu.aqi!'0'});
    var pdzhangjiang_marker = gen_marker(pdzhangjiang_point,${pdzhangjiang.aqi!'0'});
    var putuo_marker = gen_marker(putuo_point,${putuo.aqi!'0'});
    var qingpu_marker = gen_marker(qingpu_point,${qingpu.aqi!'0'});
    var shiwuchang_marker = gen_marker(shiwuchang_point,${shiwuchang.aqi!'0'});
    var xuhui_marker = gen_marker(xuhui_point,${xuhui.aqi!'0'});
    var yangpu_marker = gen_marker(yangpu_point,${yangpu.aqi!'0'});

    map.addOverlay(jingan_marker);
    map.addOverlay(hongkou_marker);
    map.addOverlay(pdchuansha_marker);
    map.addOverlay(pdxinqu_marker);
    map.addOverlay(pdzhangjiang_marker);
    map.addOverlay(putuo_marker);
    map.addOverlay(qingpu_marker);
    map.addOverlay(shiwuchang_marker);
    map.addOverlay(xuhui_marker);
    map.addOverlay(yangpu_marker);

    function gen_label(aqi, site, level) {
        var color = gen_color(aqi);
        var label = new BMap.Label(site + "(" + level + ")", {offset: new BMap.Size(25, -10)});
        label.setStyle({
            color: color,
            fontSize: "12px",
            height: "20px",
            lineHeight: "20px",
            fontFamily: "微软雅黑",
            border: "1px solid" + color,
        });
        return label;
    }

    function get_level(aqi) {
        if (aqi < 50) {
            var level = "优"
        }
        else if (aqi >= 50 && aqi < 100) {
            var level = "良"
        }
        else if (aqi >= 100 && aqi < 150) {
            var level = "轻度污染"
        }
        else if (aqi >= 150 && aqi < 200) {
            var level = "中度污染"
        }
        else if (aqi >= 200 && aqi < 300) {
            var level = "重度污染"
        }
        else if (aqi >= 300) {
            var level = "严重污染"
        }
        else {
            var level = "未知"
        }
        return level;
    }

    var jingan_label = gen_label(${jingan.aqi!'0'}, "静安监测站", get_level(${jingan.aqi!'0'}));
    var hongkou_label = gen_label(${hongkou.aqi!'0'}, "虹口监测站", get_level(${hongkou.aqi!'0'}));
    var pdchuansha_label = gen_label(${pdchuansha.aqi!'0'}, "浦东川沙监测站", get_level(${pdchuansha.aqi!'0'}));
    var pdxinqu_label = gen_label(${pdxinqu.aqi!'0'}, "浦东新区监测站", get_level(${pdxinqu.aqi!'0'}));
    var pdzhangjiang_label = gen_label(${pdzhangjiang.aqi!'0'}, "浦东张江监测站", get_level(${pdzhangjiang.aqi!'0'}));
    var putuo_label = gen_label(${putuo.aqi!'0'}, "普陀监测站", get_level(${putuo.aqi!'0'}));
    var qingpu_label = gen_label(${qingpu.aqi!'0'}, "青浦淀山湖监测站", get_level(${qingpu.aqi!'0'}));
    var shiwuchang_label = gen_label(${shiwuchang.aqi!'0'}, "黄埔十五厂监测站", get_level(${shiwuchang.aqi!'0'}));
    var xuhui_label = gen_label(${xuhui.aqi!'0'}, "徐汇上师大监测站", get_level(${xuhui.aqi!'0'}));
    var yangpu_label = gen_label(${yangpu.aqi!'0'}, "杨浦四漂监测站", get_level(${yangpu.aqi!'0'}));

    jingan_marker.setLabel(jingan_label);
    hongkou_marker.setLabel(hongkou_label);
    pdchuansha_marker.setLabel(pdchuansha_label);
    pdxinqu_marker.setLabel(pdxinqu_label);
    pdzhangjiang_marker.setLabel(pdzhangjiang_label);
    putuo_marker.setLabel(putuo_label);
    qingpu_marker.setLabel(qingpu_label);
    shiwuchang_marker.setLabel(shiwuchang_label);
    xuhui_marker.setLabel(xuhui_label);
    yangpu_marker.setLabel(yangpu_label);

    var jingan_infowindow = new BMap.InfoWindow("静安监测站  地址:静安区武定西路1480号<br>更新时间:" + "${updatedTime!}" + "<br>" + "${jingan.info!}");
    var hongkou_infowindow = new BMap.InfoWindow("虹口凉城监测站  地址:虹口区凉城路854号凉城社区卫生中心<br>更新时间:" + "${updatedTime!}" + "<br>" + "${hongkou.info!}");
    var pdchuansha_infowindow = new BMap.InfoWindow("浦东川沙监测站  地址:浦东新区川环南路319号<br>更新时间:" + "${updatedTime!}" + "<br>" + "${pdchuansha.info!}");
    var pdxinqu_infowindow = new BMap.InfoWindow("浦东新区监测站  地址:浦东新区灵山路51号<br>更新时间:" + "${updatedTime!}" + "<br>" + "${pdxinqu.info!}");
    var pdzhangjiang_infowindow = new BMap.InfoWindow("浦东张江监测站  地址:浦东新区祖冲之路295号<br>更新时间:" + "${updatedTime!}" + "<br>" + "${pdzhangjiang.info!}");
    var putuo_infowindow = new BMap.InfoWindow("普陀监测站  地址:普陀区杏山路317号曹杨社区文化中心<br>更新时间:" + "${updatedTime!}" + "<br>" + "${putuo.info!}");
    var qingpu_infowindow = new BMap.InfoWindow("青浦淀山湖监测站  地址:青浦区淀峰渔民村1号<br>更新时间:" + "${updatedTime!}" + "<br>" + "${qingpu.info!}");
    var shiwuchang_infowindow = new BMap.InfoWindow("黄埔十五厂(卢湾师专附小)监测站  地址:黄埔区局门路478号<br>更新时间:" + "${updatedTime!}" + "<br>" + "${shiwuchang.info!}");
    var xuhui_infowindow = new BMap.InfoWindow("徐汇上师大监测站  地址:徐汇区桂林路100号上师大<br>更新时间:" + "${updatedTime!}" + "<br>" + "${xuhui.info!}");
    var yangpu_infowindow = new BMap.InfoWindow("杨浦四漂监测站  地址:杨浦区平凉路1398号<br>更新时间:" + "${updatedTime!}" + "<br>" + "${yangpu.info!}");

    jingan_marker.addEventListener("click", function () {
        map.openInfoWindow(jingan_infowindow, jingan_point);
    });
    hongkou_marker.addEventListener("click", function () {
        map.openInfoWindow(hongkou_infowindow, hongkou_point);
    });
    pdchuansha_marker.addEventListener("click", function () {
        map.openInfoWindow(pdchuansha_infowindow, pdchuansha_point);
    });
    pdxinqu_marker.addEventListener("click", function () {
        map.openInfoWindow(pdxinqu_infowindow, pdxinqu_point);
    });
    pdzhangjiang_marker.addEventListener("click", function () {
        map.openInfoWindow(pdzhangjiang_infowindow, pdzhangjiang_point);
    });
    putuo_marker.addEventListener("click", function () {
        map.openInfoWindow(putuo_infowindow, putuo_point);
    });
    qingpu_marker.addEventListener("click", function () {
        map.openInfoWindow(qingpu_infowindow, qingpu_point);
    });
    shiwuchang_marker.addEventListener("click", function () {
        map.openInfoWindow(shiwuchang_infowindow, shiwuchang_point);
    });
    xuhui_marker.addEventListener("click", function () {
        map.openInfoWindow(xuhui_infowindow, xuhui_point);
    });
    yangpu_marker.addEventListener("click", function () {
        map.openInfoWindow(yangpu_infowindow, yangpu_point);
    });

    // PM2.5首页数据
    var pm25Array = [];
    var pm25TimeArray = []
    <#list pm25List as pm25>
    pm25Array.push(${pm25});
    </#list>

    <#list pm25TimeList as pm25Time>
    pm25TimeArray.push('${pm25Time}');
    </#list>

    var chart = new Chartist.Line('.pm25', {
        labels: pm25TimeArray,
        series: [
            pm25Array,
        ]
    }, {
        low: 0,
        high: Math.max(pm25Array),
        showArea: true,
        fullWidth: true,
        plugins: [
            Chartist.plugins.tooltip()
        ],
        axisY: {
            onlyInteger: true
            , scaleMinSpace: 40
            , offset: 30
            , labelInterpolationFnc: function (value) {
                return value;
            }
        }
    });

</script>


<style type="text/css">
    .anchorBL {
        display: none;
    }

    .BMap_bubble_title {
        color: black;
        font-size: 10px;
        font-weight: bold;
        text-align: left;
    }

    .BMap_pop div:nth-child(1) {
        border-radius: 7px 0 0 0;
    }

    .BMap_pop div:nth-child(3) {
        border-radius: 0 7px 0 0;
        background: #ABABAB;;
        /*background: #ABABAB;*/
        width: 23px;
        width: 0px;
        height;
        0px;
    }

    .BMap_pop div:nth-child(3) div {
        border-radius: 7px;
    }

    .BMap_pop div:nth-child(5) {
        border-radius: 0 0 0 7px;
    }

    .BMap_pop div:nth-child(5) div {
        border-radius: 7px;
    }

    .BMap_pop div:nth-child(7) {
        border-radius: 0 0 7px 0;
    }

    .BMap_pop div:nth-child
    div

    (
    7
    )
    {
        border-radius: 7px
    ;
    }

</style>