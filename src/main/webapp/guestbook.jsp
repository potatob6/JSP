<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/3/21
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>留言板</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="/guestbook/css/index.css"/>
    <link rel="stylesheet" href="/guestbook/css/style.css"/>
    <script type="text/javascript" src="/guestbook/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="/guestbook/js/jquery.SuperSlide.2.1.1.js"></script>
    <script>
        function text(){
            var a=document.getElementsByTagName("textarea").value;
            if(a.length<10){
                alert("留言内容字数不能小于10"+"   "+a.length)
                return false;
            }else{
                return true;
            }
        }
    </script>
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
</head>

<body>
<!--header start-->
<div id="header">
    <h1>发表留言</h1>
    <p>青春是打开了,就合不上的书。人生是踏上了，就回不了头的路，爱情是扔出了，就收不回的赌注。</p>
</div>
<!--header end-->
<!--nav-->
<div id="nav">
    <ul>
        <li><a  href="index.jsp">首页</a></li>
        <li><a href="MessageView">留言列表</a></li>
        <li><a href="guestbook.jsp">发表留言</a></li>
        <li><a href="LinkedInteruptted.jsp">友情链接</a></li>
        <li><a href="login.jsp">管理员登录</a></li>
        <div class="clear"></div>
    </ul>
</div>
</div>
<!--nav end-->
<!--content start-->
<div id="content">
    <!--left-->
    <div class="left">
        <div class="weizi">
            <div class="wz_text">当前位置：<a href="index.jsp">首页</a>><h1>发表留言</h1></div>
        </div>
        <div class="wz1">
            <form action="DoAddMessage" method="post">
                <table>
                    <tr>
                        <th>留言人</th>
                        <td> <input type="text" name="name"required></td>
                    </tr>
                    <tr>
                        <th>留言主题：</th>
                        <td><input type="text" name="them"></td>
                    </tr>
                    <tr>
                        <th>留言题目：</th>
                        <td><input type="text" name="title"required/></td>
                    </tr>
                    <tr>
                        <th>留言内容：</th>
                        <td><textarea name="content"></textarea></td>
                </table>
                <div class="clear"></div>
                <th colspan="2"align="center"><input type="submit" value="添加留言" onclick="text()" /></th>
            </form>
        </div>
    </div>
    <!--end left -->
    <div class="clear"></div>
</div>
<!--content end-->
<!--footer-->
<div id="footer">
</div>
<!--footer end-->
</body>
</html>

