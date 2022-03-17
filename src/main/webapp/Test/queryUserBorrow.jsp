<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="io.github.potatob6.Models.*" %>
<%@ page import="java.util.*" %>
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
        UserBean ub = new UserBean();
        ub.setUserID("1");
        OurDatabase ourDatabase = OurDatabase.getDataBase();
        ArrayList<BorrowWithBookBean> borrowWithBookBeans = ourDatabase.queryUserAllBorrowed(ub);
        for (int i = 0;i<borrowWithBookBeans.size();i++){
            BorrowWithBookBean bean = borrowWithBookBeans.get(i);
    %>
        <div>
            <span><%=bean.getBorrowID() %></span>
            <span><%=bean.getBorrowDate() %></span>
            <span><%=bean.getBookName() %></span>
        </div>
    <%
        }
    %>
</body>
</html>