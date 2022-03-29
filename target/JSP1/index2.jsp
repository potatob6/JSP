<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./favicon.ico">

    <title>Navbar Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="./static/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./static/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="./static/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./static/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        body {
            padding-top: 20px;
            padding-bottom: 20px;
            background: url("./images/background6.jpg") center center no-repeat;
        }

        .navbar {
            margin-bottom: 20px;
        }

    </style>
</head>

<body>

<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">星星云</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="CloudManagerIndex.jsp">进入主页</a></li>
                    <li><a href="https://github.com/yywl5/JSP">关于</a></li>
                    <li><a href="https://github.com/potatob6/JSP">联系我们</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">文件操作<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath }/upload.jsp">上传</a></li>
                            <li><a href="${pageContext.request.contextPath }/DownListServlet">查看文件目录</a></li>
                            <li><a href="#">已下载文件</a></li>
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header">管理员信息</li>
                            <li><a href="#">管理员登录</a></li>
                            <li><a href="#">控制面板</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="./">首页 <span class="sr-only">(current)</span></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <h1>星星云</h1>
        <p>星星图书管理系统的星星云是一家为企业的营销和服务提供整体解决方案的服务商。目前主要是面向中小企业提供广告、呼叫中心、售前咨询、营销CRM、商城、直播、售后服务管理等多种SAAS产品，产品已经为金融、教育、电子商务、广告媒体、企业服务等十几大行业的13万多家企业客户提供不同的解决方案。想了解更多相关信息，可以前往星星云开发团队github反馈意见，谢谢！</p>
        <p>
            <a class="btn btn-lg btn-primary" role="button" href="Index2Introduction.jsp">查看更多介绍信息 &raquo;</a>
        </p>
    </div>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="./static/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="./static/dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./static/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
