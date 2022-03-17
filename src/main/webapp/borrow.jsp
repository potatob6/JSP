<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.sql.Date" %>
<%@ page import="io.github.potatob6.Models.OurDatabase" %>
<%@ page import="io.github.potatob6.Models.UserBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="io.github.potatob6.Models.BorrowWithBookBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <script src="/JSP/Javascript/jquery-3.6.0.min.js"></script>
    <link href="/JSP/Javascript/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="/JSP/Javascript/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
    <title>借阅信息</title>
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
              <a class="navbar-brand " href="#"><p class="text-primary">我的图书馆</p></a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
              <ul class="nav navbar-nav navbar-left">
                <li class="active">
                  <a href="#" >
                    图书查询
                  </a>
                </li>
                <li>
                  <a href="#" >
                    个人信息
                  </a>
                </li>
                <li >
                  <a href="#" >
                    我的借还
                  </a>
                </li>
                <li >
                  <a href="#" >
                    密码修改
                  </a>
                </li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;<%=session.getAttribute("login")%>，已登录</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
      <h2>借阅列表</h2>
      <%-- 图书列表 --%>
      <div>
        <form>
          <table class="table table-hover">
            <tr>
              <th>借阅ID</th>
              <th>图书ID</th>
              <th>用户ID</th>
              <th>借阅日期</th>
              <th>期限</th>
              <th>归还日期</th>
              <th>超时收费</th>
              <th>操作</th>
            </tr>
            <tr>
              <%
                UserBean userBean = new UserBean();
                userBean.userID =  session.getAttribute("login").toString();
                OurDatabase ourDatabase = OurDatabase.getDataBase();
                ArrayList<BorrowWithBookBean> ls = ourDatabase.queryUserAllBorrowed(userBean);
                for(int i = 0; i < ls.size(); i++) {
                  int borrowID = ls.get(0).borrowID;
                  int bookID = ls.get(1).bookID;
                  String userID =  ls.get(2).userID;
                  Date borrowDate = ls.get(3).borrowDate;
                  int timeLimit = ls.get(4).timeLimit ;
                  Date returnedDate = ls.get(5).returnedDate ;
                  BigDecimal overtimeCharge = ls.get(6).overtimeCharge;

                  //while(rs.next()){
                  //  int bookID = rs.getInt(1);
                  //  String classID = rs.getString(2);
                  //  String bookName = rs.getString(3);
                  //  String publisher = rs.getString(4);
                  //  BigDecimal originPrice = rs.getBigDecimal(5);
                  //  Date storageDate = rs.getDate(6);
                  //  int storageCount = rs.getInt(7);
                  out.println("<tr><td>" + borrowID + "</td><td>"  + bookID + "</td><td>" + userID + "</td><td>"
                          + borrowDate + "</td><td>" + timeLimit + "</td><td>" + returnedDate + "</td><td>"
                          + overtimeCharge + "</td><td><a class=\"btn btn-primary\" href=\"#\">归还</a></td><tr>");

                }
              %>
            </tr>
          </table>
        </form>
      </div>
      <%--            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">--%>
      <%--                <div class="modal-dialog" role="document">--%>
      <%--                    <div class="modal-content">--%>
      <%--                        <div class="modal-header">--%>
      <%--                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
      <%--                            <h4 class="modal-title" id="myModalLabel">借阅数量</h4>--%>
      <%--                        </div>--%>
      <%--                        <div class="modal-body">--%>
      <%--                            <input type="text" name="count" value="">--%>
      <%--                        </div>--%>
      <%--                        <div class="modal-footer">--%>
      <%--                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
      <%--                            <a type="button" class="btn btn-primary" href="/borrowBook">确认借阅</a>--%>
      <%--                        </div>--%>
      <%--                    </div>--%>
      <%--                </div>--%>
      <%--            </div>--%>
    </div>
  </body>
</html>
