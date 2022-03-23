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
    <form action="/JSP/Test/queryBorrowResult.jsp" method="get">
        借阅ID:<input type="text" name="borrowID"/><br>
        图书ID:<input type="text" name="bookID"/><br>
        用户ID:<input type="text" name="userID"/><br>
        借阅日期:<input type="text" name="borrowDate"/><br>
        时限:<input type="text" name="timeLimit"/><br>
        <button>提交</button>
    </form>
</body>
</html>