<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.*" %>
<%@ page import="io.github.potatob6.Models.*" %>
<%@ page import="io.github.yywl5.Models.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <script src="/JSP/Javascript/jquery-3.6.0.min.js"></script>
        <link href="/JSP/Javascript/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="/JSP/Javascript/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
        <title>总借阅页面</title>
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
                                    <a href="AllUsers.jsp" >
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
                                <% if(session.getAttribute("managerlogin")!=null) { %>
                                <% ManagerBean userBean = (ManagerBean)session.getAttribute("managerlogin"); %>
                                <li><a href="#"><span class="glyphicon glyphicon-user"></span>管理员:&nbsp;<%=userBean.getNickname() %>，已登录</a></li>
                                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
                                <% } else {%>
                                <li><a href="/JSP/login.jsp"><span class="glyphicon glyphicon-user">未登录</span></a></li>
                                <% } %>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <h2>借阅信息</h2>

            <div>
                <table class="table table-hover">
                    <tr>
                        <th>借阅ID</th>
                        <th>图书ID</th>
                        <th>用户ID</th>
                        <th>借阅日期</th>
                        <th>期限(日)</th>
                        <th>归还日期</th>
                        <th>超时收费</th>
                        <!-- <th>操作</th> -->
                    </tr>
                    <%
                        OurDatabase ourDatabase = OurDatabase.getDataBase();
                        ArrayList<Object> ary = ourDatabase.queryAllBorrows();
                        for(int i = 0;i<ary.size();i++)
                        {
                            BorrowBean borrowBean = (BorrowBean) ary.get(i);
                            int borrowID = borrowBean.borrowID;
                            int bookID = borrowBean.bookID;
                            String userID = borrowBean.userID;
                            Date borrowDate = borrowBean.borrowDate;
                            int timeLimit = borrowBean.timeLimit;
                            Date returnedDate = borrowBean.returnedDate;
                            BigDecimal overtimeCharge = borrowBean.overtimeCharge;
                            out.println("<tr><td>" + borrowID + "</td><td>"  + bookID + "</td><td>" + userID + "</td><td>"
                                    + borrowDate + "</td><td>" + timeLimit + "</td><td>" + returnedDate + "</td><td>"+ overtimeCharge +"</td><tr>");
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
