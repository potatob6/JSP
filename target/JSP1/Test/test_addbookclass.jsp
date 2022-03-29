<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/JSP/addbookclass" method="POST">
        分类ID:<input type="text" name="classID"/><br>
        分类名:<input type="text" name="className"/><br>
        <button>提交</button>
    </form>
</body>
</html>