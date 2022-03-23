<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>下载列表</h1><hr>
<c:forEach items="${requestScope.list }" var="r">
    <h2>文件名：${r.realname }</h2><br>
    上传时间：${r.uploadtime }<br>
    上传者IP：${r.ip }<br>
    存储路径: ${r.savepath}<br>
    描述信息：${r.description }<br>
    <a href="${pageContext.request.contextPath }/DownServlet?id=${r.id}">下载</a>
    <hr>
</c:forEach>
</body>
</html>