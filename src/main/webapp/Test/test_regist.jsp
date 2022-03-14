<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
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