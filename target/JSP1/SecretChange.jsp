<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/3/16
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="io.github.potatob6.Models.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/matrix-style2.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link href="css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    <style>
        #content{
            background: url("images/background5.jpg") center center no-repeat;
        }
        #form-wizard-1 {
            display: flex;
            justify-content: center;
            align-content: center;
            flex-direction: column;
        }
    </style>
</head>
<body>
<div id="content">
    <% UserBean userBean = (UserBean)session.getAttribute("login"); %>
    <div id="content-header">
        <h1>密码修改</h1>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title"> <span class="icon"> <i class="icon-pencil"></i> </span>
                        <h5>密码修改</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form id="form-wizard" class="form-horizontal" method="post" action="/JSP/SecretChangeServlet">
                            <div id="form-wizard-1" class="step">
                                <div class="control-group">
                                    <label class="control-label">原密码</label>
                                    <div class="controls">
                                        <input id="username" type="password" name="originPassword" placeholder="请输入用户名"/>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">新密码</label>
                                    <div class="controls">
                                        <input id="password" type="password" name="password" placeholder="请输入密码"/>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">再次输入密码</label>
                                    <div class="controls">
                                        <input id="password2" type="password" name="password2" placeholder="请再次输入密码"/>
                                    </div>
                                </div>
                            </div>
                            <br>
                            </br>
                            <div class="form-actions">
                                &nbsp;
                                <input id="back" class="btn btn-primary" type="submit" value="提交" />
                                &nbsp; &nbsp; &nbsp;
                                <input id="next" class="btn btn-primary" type="reset" value="重置" />
                                <div id="status"></div>
                            </div>
                            <div id="submitted"></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

