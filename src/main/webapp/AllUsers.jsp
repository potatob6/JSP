<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.*" %>
<%@ page import="io.github.potatob6.Models.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <script src="/JSP/Javascript/jquery-3.6.0.min.js"></script>
        <link href="/JSP/Javascript/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="/JSP/Javascript/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
        <title>所有用户信息</title>
        <style type="text/css">
            body {
                width: 80%;
                margin: 0 auto;
                height: auto;
            }

        </style>
    </head>
    <body>
        <div>
            <%--导航栏--%>
            <div id="nav">
                <nav class="navbar navbar-default" role="navigation" style="background-color:#fff">
                    <div class="container-fluid">
                        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
                            <a class="navbar-brand " href="#"><p class="text-primary">图书管理系统</p></a>
                        </div>
                        <div class="collapse navbar-collapse" id="example-navbar-collapse">
                            <ul class="nav navbar-nav navbar-left">
                                <li class="active">
                                    <a href="AdminMainPage.jsp" >
                                        图书信息
                                    </a>
                                </li>
                                <li>
                                    <a href="#" >
                                        用户信息
                                    </a>
                                </li>
                                <li >
                                    <a href="#" >
                                        借阅信息
                                    </a>
                                </li>

                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <% if(session.getAttribute("login")!=null) { %>
                                <% UserBean userBean = (UserBean)session.getAttribute("login"); %>
                                <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;<%=userBean.getNickname() %>，已登录</a></li>
                                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
                                <% } else {%>
                                <li><a href="/JSP/login.jsp"><span class="glyphicon glyphicon-user">未登录</span></a></li>
                                <% } %>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <h2>用户列表</h2>

            <div>
                <table class="table table-hover">
                    <tr>
                        <th>用户ID</th>
                        <th>用户密码</th>
                        <th>昵称</th>
                        <th>是否VIP</th>
                        <th>借书卡ID</th>
                        <th>余额</th>
                        <th>操作</th>
                    </tr>
                    <%
                        OurDatabase ourDatabase = OurDatabase.getDataBase();
                        ArrayList<Object> ary = ourDatabase.queryAllUsers();
                        for(int i = 0;i<ary.size();i++)
                        {
                            UserBean userBean = (UserBean) ary.get(i);
                            String userID = userBean.userID;
                            String pwd = userBean.pwd;
                            String nickname = userBean.nickname;
                            int isVIP = userBean.isVIP;
                            String cardID = userBean.cardID;
                            BigDecimal balance = userBean.balance;
                            out.println("<tr><td>" + userID + "</td><td>"  + pwd + "</td><td>" + nickname + "</td><td>"
                                    + isVIP + "</td><td>" + cardID + "</td><td>" + balance + "</td><tr>");
                        }
                    %>
                </table>
            </div>
            <%--            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">--%>
            <%--                <div class="modal-dialog" role="document">--%>
            <%--                    <div class="modal-content">--%>
            <%--                        <div class="modal-header">--%>
            <%--                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
            <%--                            <h4 class="modal-title" id="myModalLabel">修改图书</h4>--%>
            <%--                        </div>--%>
            <%--                        &lt;%&ndash;                        <div class="modal-body">&ndash;%&gt;--%>
            <%--                        &lt;%&ndash;                            <input type="text" name="count" value="">&ndash;%&gt;--%>
            <%--                        &lt;%&ndash;                        </div>&ndash;%&gt;--%>
            <%--                        <div class="modal-footer">--%>
            <%--                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>--%>
            <%--                            <a type="button" class="btn btn-primary" href="/JSP/borrowBook?bookID=post">确认</a>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>
    </body>
</html>
