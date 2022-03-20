<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/3/19
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网盘主页</title>
</head>
<body>
<form action="/CloudManageAll" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>
</body>
</html>
