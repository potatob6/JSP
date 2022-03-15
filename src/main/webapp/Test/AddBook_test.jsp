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
    <form action="/JSP/addBook" method="POST">
        书号:<input type="text" name="bookID"/><br>
        分类ID:<input type="text" name="classID"/><br>
        书名:<input type="text" name="bookName" /><br>
        出版社:<input type="text" name="publisher" /><br>
        价格:<input type="text" name="originPrice" /><br>
        数量:<input type="number" name="storageCount" /><br>
        <button>提交</button>
    </form>
</body>
</html>