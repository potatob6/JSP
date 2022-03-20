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
    <%
        int borrowID = Integer.parseInt(request.getParameter("borrowID"));
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        String userID = request.getParameter("userID");
        java.sql.Date borrowDate = java.sql.Date.valueOf(request.getParameter("borrowDate"));
        int timeLimit = Integer.parseInt(request.getParameter("timeLimit"));

        BorrowBean b = new BorrowBean();
        b.setBorrowID(borrowID);
        b.setBookID(bookID);
        b.setUserID(userID);
        b.setBorrowDate(borrowDate);
        b.setTimeLimit(timeLimit);

        OurDatabase our = OurDatabase.getDataBase();
        BorrowBean bResult = (BorrowBean)(our.queryBean(b, BorrowBean.class));
    %>

    <%
    if(bResult==null)
    {
    %>
         <p>无记录</p>
    <% } else { %>
    <p>还书日期：</p>
    <% if (bResult.getReturnedDate()!=null) { %>
    <p>无还书日期</p>
    <% } else { %>
    <p><%=bResult.getReturnedDate() %></p>
    <% }} %>
</body>
</html>