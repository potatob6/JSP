<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
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
    <% Integer classID = Integer.parseInt(request.getParameter("classID")); %>
    <% String className = request.getParameter("className"); %>

    <%
        OurDatabase our = OurDatabase.getDataBase();
        BookClassBean bcb = new BookClassBean();
        bcb.setClassID(classID);
        bcb.setClassName(className);

        our.updateBean(bcb, BookClassBean.class, false);
    %>
</body>
</html>