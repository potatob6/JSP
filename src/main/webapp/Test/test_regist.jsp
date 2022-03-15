<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/JSP/regist" method="POST">
        用户名:<input type="text" name="username"/>
        密码:<input type="password" name="pwd"/>
        昵称:<input type="text" name="nickname" />
        <button>注册</button>
    </form>
</body>
</html>