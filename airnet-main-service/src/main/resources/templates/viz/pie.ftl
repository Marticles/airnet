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
    <!-- Page plugins css -->
    <link href="/static/plugins/clockpicker/dist/jquery-clockpicker.min.css" rel="stylesheet">
    <!-- Date picker plugins css -->
    <link href="/static/plugins/bootstrap-datepicker/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css"/>
    <!-- Daterange picker plugins css -->
    <link href="/static/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
    <link href="/static/plugins/daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- chartist CSS -->
    <link href="/static/plugins/chartist-js/dist/chartist.min.css" rel="stylesheet">
    <link href="/static/plugins/chartist-js/dist/chartist-init.css" rel="stylesheet">
    <link href="/static/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
    <link href="/static/plugins/c3-master/c3.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/static/css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="/static/css/colors/purple.css" id="theme" rel="stylesheet">
    <link href="/static/css/bootstrap-select.min.css" id="theme" rel="stylesheet">
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
                            <div class="notify">
                                <!-- 新消息通知 -->
                                <span class="heartbit"></span>
                                <span class="point"></span></div>
                        </a>
                        <div class="dropdown-menu mailbox dropdown-menu-right scale-up" aria-labelledby="2">
                            <ul>
                                <li>
                                    <div class="drop-title">你有3条新通知</div>
                                </li>
                                <li>
                                    <div class="message-center">

                                        <a href="#">
                                            <div class="mail-contnet">
                                                <h5>严重污染警告</h5>
                                                <h5>静安SO2已超标23.2%</h5> <span class="mail-desc">当前监测值：25.2；设定阈值：20</span>
                                                <span class="time">2019-01-22 22:14</span></div>
                                        </a>

                                        <a href="#">
                                            <div class="mail-contnet">
                                                <h5>污染物预警通知</h5>
                                                <h6>浦东新区PM2.5已超标23.2%</h6> <span
                                                    class="mail-desc">当前监测值：25.2；设定阈值：20</span> <span class="time">2019-01-21 12:14</span>
                                            </div>
                                        </a>

                                        <a href="#">
                                            <div class="mail-contnet">
                                                <h5>污染物预警通知</h5>
                                                <h6>杨浦区PM2.5已超标23.2%</h6> <span
                                                    class="mail-desc">当前监测值：25.2；设定阈值：20</span> <span class="time">2019-01-21 12:14</span>
                                            </div>
                                        </a>


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
                        </ul>
                    </li>

                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false"><i class="mdi mdi-bullseye"></i><span
                                class="hide-menu">空气质量排行</span></a>
                        <ul aria-expanded="false" class="collapse">
                            <li><a href="/rank/sh">上海市空气质量实时/历史排行</a></li>
                            <li><a href="/rank/cn">全国空气质量实时排行</a></li>
                        </ul>
                    </li>

                    <#if isLogin=="true">

                    <li>
                        <a class="has-arrow " href="/forecast" aria-expanded="false"><i
                                class="mdi mdi-chemical-weapon"></i>
                            <span class="hide-menu">PM2.5预测</span></a>
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
                        <li class="breadcrumb-item"><a href="/">数据可视化</a></li>
                        <li class="breadcrumb-item active">标准饼图</li>
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
                            <div class="row">
                                <div class="col-md-5">
                                    <div class='input-group mb-3'>
                                        <input type='text' id='time-range' class="form-control timeseconds"/>
                                        <div class="input-group-append">
                                        <span class="input-group-text">
                                            <span class="ti-calendar"></span>
                                        </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3" style=" margin-left:20px;">
                                    <select class="selectpicker " id="site_picker"
                                            data-style="btn btn-block btn-outline-secondary" title="选择监测站(默认上海杨浦)">
                                        <optgroup label="静安">
                                            <option value="jingan">静安监测站</option>
                                        </optgroup>
                                        <optgroup label="虹口">
                                            <option value="hongkou">虹口监测站</option>
                                        </optgroup>
                                        <optgroup label="浦东">
                                            <option value="pudongchuansha">浦东川沙监测站</option>
                                            <option value="pudongxinqu">浦东新区监测站</option>
                                            <option value="pudongzhangjiang">浦东张江监测站</option>
                                        </optgroup>
                                        <optgroup label="普陀">
                                            <option value="putuo">普陀监测站</option>
                                        </optgroup>
                                        <optgroup label="黄埔">
                                            <option value="shiwuchang">十五厂(卢湾师专附小)监测站</option>
                                        </optgroup>
                                        <optgroup label="杨浦">
                                            <option value="yangpusipiao">杨浦四漂监测站</option>
                                        </optgroup>
                                        <optgroup label="徐汇">
                                            <option value="xuhuishangshida">徐汇上师大监测站</option>
                                        </optgroup>
                                        <optgroup label="青浦">
                                            <option value="qingpudianshanhu">青浦淀山湖监测站</option>
                                        </optgroup>
                                    </select>
                                </div>
                                <div class="col-md-3" style=" margin-left:-38px;">
                                    <select class="selectpicker " id="pollution_picker"
                                            data-style="btn btn-block btn-outline-secondary" title="选择统计量(默认空气质量等级)"
                                    >
                                        <optgroup label="(优、良、轻度污染、中度污染、重度污染、严重污染)">
                                            <option value="level">空气质量等级</option>
                                        </optgroup>
                                        <optgroup label="(细颗粒物PM2.5、颗粒物PM10、二氧化硫、一氧化碳、二氧化氮等)">
                                            <option value="primarypollutant">首要污染物</option>
                                        </optgroup>

                                    </select>
                                </div>
                                <div class="col-md-1" style=" margin-left:-38px;">
                                    <button type="button" id="request_button"
                                            class="btn waves-effect waves-light btn-primary "><i
                                            class="fa fa-check"></i>&nbsp确认
                                    </button>
                                </div>
                            </div>
                            <hr style=" margin-top:0px;">
                            <div class="col-md-12" id="main_charts"
                                 style="width: 1150px;height:480px;margin: 0 auto;"></div>
                        </div>
                    </div>
                </div>

            </div>

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
<!-- Echarts -->
<script src="/static/js/echarts.js"></script>
<script src="/static/js/macarons.js"></script>
<!-- DateTime -->
<script src="/static/plugins/moment/moment.js"></script>
<script src="/static/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>
<!-- Clock Plugin JavaScript -->
<script src="/static/plugins/clockpicker/dist/jquery-clockpicker.min.js"></script>
<!-- Date Picker Plugin JavaScript -->
<script src="/static/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<!-- Date range Plugin JavaScript -->
<script src="/static/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<script src="/static/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/static/plugins/moment/moment.js"></script>
<!-- 自定义时间 -->
<script src="/static/js/datetime.js"></script>
<script src="/static/js/bootstrap-select.min.js"></script>
</body>

</html>

<script>
    var theme = 'macarons';
    var ChartItem = function () {
        return {
            name: '',
            type: 'line',
            markPoint: {
                data: [
                    {type: 'max', name: '最高值'},
                    {type: 'min', name: '最低值'},
                    {type: 'average', name: '平均值'}
                ]
            },
            data: []
        }
    };

    var myChart = echarts.init(document.getElementById('main_charts'), theme);

    var app = {
        days: [],
        exellent: [],
        good: [],
        // 1 2 3 4轻/中/重度/严重污染
        polluted1: [],
        polluted2: [],
        polluted3: [],
        polluted4: [],
        pm25: [],
        pm10: [],
        pm25pm10: [],
        no2: [],
        co: [],
        o31h: [],
        so2: []
    }

    function getJsonLength(json) {
        var jsonLength = 0;
        for (var i in json) {
            jsonLength++;
        }
        return jsonLength;
    }

    $(document).ready(function () {
        getDefaultTime()
        getDefaultData();
    });

    function getDefaultTime() {
        $.ajax({
            url: '/viz/default',
            data: {},
            headers: {
                Authorization: getCookie("jwt_token")
            },
            type: 'GET',
            async: false,
            dataType: 'json',
            success: function (data) {
                var default_time = data.time[0] + ' - ' + data.time[data.time.length - 1];
                $('#time-range').val(default_time);
            },
            error: function (msg) {
                console.log(msg);
            }
        })
    };

    function getDefaultData() {
        var time = $('#time-range').val().split(" - ");
        var request = {};
        request.start = time[0];
        request.end = time[1];
        request.site = 'yangpusipiao';
        $.ajax({
            url: '/viz/custom',
            type: 'POST',
            headers: {
                Authorization: getCookie("jwt_token")
            },
            dataType: 'json',
            data: JSON.stringify(request),
            async: true,
            contentType: 'application/json;charset=UTF-8',
            success: function (data) {
                app.days = getJsonLength(data.time);
                var value = data.pollution.level;
                var counter_excellent = 0;
                var counter_good = 0;
                var counter_polluted1 = 0;
                var counter_polluted2 = 0;
                var counter_polluted3 = 0;
                var counter_polluted4 = 0;
                for (var obj in value) {
                    if (value[obj] == '优') {
                        counter_excellent += 1;
                    }
                    else if (value[obj] == '良') {
                        counter_good += 1;
                    }
                    else if (value[obj] == '轻度污染') {
                        counter_polluted1 += 1;
                    }
                    else if (value[obj] == '中度污染') {
                        counter_polluted2 += 1;
                    }
                    else if (value[obj] == '重度污染') {
                        counter_polluted3 += 1;
                    }
                    else if (value[obj] == '严重污染') {
                        counter_polluted4 += 1;
                    }
                    app.exellent = counter_excellent;
                    app.good = counter_good;
                    app.polluted1 = counter_polluted1;
                    app.polluted2 = counter_polluted2;
                    app.polluted3 = counter_polluted3;
                    app.polluted4 = counter_polluted4;

                }

                myChart.setOption({
                    title: {
                        text: '展示类型 - 饼图',
                        subtext: '鼠标悬停可查看详细信息',
                        x: 'center'
                    },
                    tooltip: {trigger: 'axis'},
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data: ['优', '良', '轻度污染', '中度污染', '重度污染', '严重污染']
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {show: true, type: ['line']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    xAxis: {
                        show: true,
                        data: app.xday,
                        name: '日期',
                    },
                    yAxis: [
                        {
                            show: true,
                            type: 'value',
                        }
                    ],
                    series: [{
                        name: '空气质量等级',

                        type: 'pie',

                        label: {
                            normal: {
                                show: true,
                                formatter: '{b}: {c}({d}%)'
                            }
                        },
                        data: [
                            {value: app.exellent, name: '优'},
                            {value: app.good, name: '良'},
                            {value: app.polluted1, name: '轻度污染'},
                            {value: app.polluted2, name: '中度污染'},
                            {value: app.polluted3, name: '重度污染'},
                            {value: app.polluted4, name: '严重污染'}
                        ]

                    }]
                })
            },
            error: function (type, error) {
                console.log(type);
                console.log(error);
            }
        })
    };


    $("#request_button").click(function () {
        var time = $('#time-range').val().split(" - ");
        var request = {};
        request.start = time[0];
        request.end = time[1];
        request.site = $('#site_picker').val();
        var request_pollution = $('#pollution_picker').val();
        $.ajax({
            url: '/viz/custom',
            type: 'POST',
            headers: {
                Authorization: getCookie("jwt_token")
            },
            dataType: 'json',
            data: JSON.stringify(request),
            contentType: 'application/json;charset=UTF-8',
            success: function (data) {
                console.log(data)
                app.days = getJsonLength(data.time);
                if (request_pollution == 'level') {
                    var value = data.pollution.level;
                    var counter_exellent = 0;
                    var counter_good = 0;
                    var counter_polluted1 = 0;
                    var counter_polluted2 = 0;
                    var counter_polluted3 = 0;
                    var counter_polluted4 = 0;
                    for (var obj in value) {
                        if (value[obj] == '优') {
                            counter_exellent += 1;
                        }
                        else if (value[obj] == '良') {
                            counter_good += 1;
                        }
                        else if (value[obj] == '轻度污染') {
                            counter_polluted1 += 1;
                        }
                        else if (value[obj] == '中度污染') {
                            counter_polluted2 += 1;
                        }
                        else if (value[obj] == '重度污染') {
                            counter_polluted3 += 1;
                        }
                        else if (value[obj] == '严重污染') {
                            counter_polluted4 += 1;
                        }
                        app.exellent = counter_exellent;
                        app.good = counter_good;
                        app.polluted1 = counter_polluted1;
                        app.polluted2 = counter_polluted2;
                        app.polluted3 = counter_polluted3;
                        app.polluted4 = counter_polluted4;
                    }
                    var pie_data = [
                        {value: app.exellent, name: '优'},
                        {value: app.good, name: '良'},
                        {value: app.polluted1, name: '轻度污染'},
                        {value: app.polluted2, name: '中度污染'},
                        {value: app.polluted3, name: '重度污染'},
                        {value: app.polluted4, name: '严重污染'}
                    ];
                    var pie_name = '空气质量等级'
                    var pie_legends = ['优', '良', '轻度污染', '中度污染', '重度污染', '严重污染']


                }
                else if (request_pollution == 'primarypollutant') {
                    var value = data.pollution.primaryPollutant;
                    var counter_pm25 = 0;
                    var counter_pm10 = 0;
                    var counter_pm25pm10 = 0;
                    var counter_no2 = 0;
                    var counter_co = 0;
                    var counter_o31h = 0;
                    var counter_so2 = 0;
                    for (var obj in value) {
                        if (value[obj] == '细颗粒物(PM2.5)' | value[obj] == 'PM2.5') {
                            counter_pm25 += 1;
                        }
                        else if (value[obj] == '颗粒物(PM10)' | value[obj] == 'PM10') {
                            counter_pm10 += 1;
                        }
                        else if (value[obj] == '颗粒物(PM10)细颗粒物(PM2.5)') {
                            counter_pm25pm10 += 1;
                        }
                        else if (value[obj] == '二氧化氮') {
                            counter_no2 += 1;
                        }
                        else if (value[obj] == '一氧化碳') {
                            counter_co += 1;
                        }
                        else if (value[obj] == '臭氧一小时') {
                            counter_o31h += 1;
                        }
                        else if (value[obj] == '二氧化硫') {
                            counter_so2 += 1;
                        }
                        app.pm25 = counter_pm25;
                        app.pm10 = counter_pm10;
                        app.pm25pm10 = counter_pm25pm10;
                        app.no2 = counter_no2;
                        app.co = counter_co;
                        app.o31h = counter_o31h;
                        app.so2 = counter_so2;
                    }
                    var pie_data = [
                        {value: app.pm25, name: '细颗粒物(PM2.5)'},
                        {value: app.pm10, name: '颗粒物(PM10)'},
                        {value: app.pm25pm10, name: '颗粒物(PM10)细颗粒物(PM2.5)'},
                        {value: app.no2, name: '二氧化氮'},
                        {value: app.co, name: '一氧化碳'},
                        {value: app.o31h, name: '臭氧一小时'},
                        {value: app.so2, name: '二氧化硫'}
                    ];
                    var pie_name = '首要污染物'
                    var pie_legends = ['细颗粒物(PM2.5)', '颗粒物(PM10)', '颗粒物(PM10)细颗粒物(PM2.5)', '二氧化氮', '一氧化碳', '臭氧一小时', '二氧化硫']


                }

                myChart.setOption({
                    title: {
                        text: '展示类型 - 饼图',
                        subtext: '鼠标悬停可查看详细信息',
                        x: 'center'
                    },
                    tooltip: {trigger: 'axis',},
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data: pie_legends
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {
                                show: true,
                                type: ['pie', 'funnel'],
                                option: {
                                    funnel: {
                                        x: '25%',
                                        width: '50%',
                                        funnelAlign: 'left',
                                        max: 1548
                                    }
                                }
                            },
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,

                    series: [{
                        name: pie_name,
                        type: 'pie',
                        label: {
                            normal: {
                                show: true,
                                formatter: '{b}: {c}({d}%)'
                            }
                        },
                        data: pie_data

                    }]
                })
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