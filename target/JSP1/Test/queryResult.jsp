<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="io.github.potatob6.Models.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        OurDatabase db = OurDatabase.getDataBase();
        UserBean param = new UserBean();
        param.setUserID(request.getParameter("userID"));
        UserBean ub = db.querySpecificUserByUserID(param);
    %>
    <p>用户ID：<%=ub.getUserID() %></p>
    <p>用户密码：<%=ub.getPwd() %></p>
    <p>用户昵称：<%=ub.getNickname() %></p>
</body>
</html>