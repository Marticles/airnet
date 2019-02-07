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
                                                <h5>❗ 污染物预警通知</h5>
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
                        <li class="breadcrumb-item"><a href="/">主页</a></li>
                        <li class="breadcrumb-item">上海市高空气流图</li>
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
                        <div class="card-header">
                            <span>上海市高空气流图</span>
                            <div class="card-actions">
                                <a class="" data-action="collapse"><i class="ti-minus"></i></a>
                                <a class="btn-minimize" data-action="expand"><i class="mdi mdi-arrow-expand"></i></a>
                                <a class="btn-close" data-action="close"><i class="ti-close"></i></a>
                            </div>
                        </div>
                        <div class="card-body ">
                            <div class="col-md-12">
                                <iframe width="100%" height="480"
                                        src="https://embed.windy.com/embed2.html?lat=31.217&lon=121.396&zoom=10&level=surface&overlay=wind&menu=&message=true&marker=&calendar=12&pressure=true&type=map&location=coordinates&detail=&detailLat=31.168&detailLon=121.409&metricWind=km%2Fh&metricTemp=%C2%B0C&radarRange=-1"
                                        frameborder="0"></iframe>
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