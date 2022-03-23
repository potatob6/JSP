<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="#">首页</a></li>
                <li role="presentation"><a href="#">个人空间</a></li>
                <li role="presentation"><a href="#">星星云</a></li>
            </ul>
        </div>
    </nav>
    <br>
    <br>
    <br>
    </br>
    <h1>星星云</h1><hr>
    <ol class="breadcrumb">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人空间</a></li>
        <li class="active">星星云</li>
    </ol>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Launch demo modal
    </button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    <a href="${pageContext.request.contextPath }/upload.jsp">上传</a>
                    <a href="${pageContext.request.contextPath }/DownListServlet">下载列表</a>
                    <button type="button" class="btn btn-default">点击上传文件</button>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <p class="lead">星星图书管理系统的星星云是一家为企业的营销和服务提供整体解决方案的服务商。目前主要是面向中小企业提供广告、呼叫中心、售前咨询、营销CRM、商城、直播、售后服务管理等多种SAAS产品，产品已经为金融、教育、电子商务、广告媒体、企业服务等十几大行业的13万多家企业客户提供不同的解决方案。想了解更多相关信息，可以咨询星星图书管理系统开发团队github反馈意见，谢谢！</p>
    <img src="./images/background2.png" class="img-responsive" alt="Responsive image">
</div>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="./js/jquery-3.5.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</body>
</html>