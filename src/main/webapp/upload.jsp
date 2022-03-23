<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>上传页面</h1><hr>
<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
选择文件：<input type="file" name="file1"/><br>
描述信息：<textarea rows="5" cols="45" name="description"></textarea><br>
<input type="submit" value="上传"/>
</form>
</body>
</html>