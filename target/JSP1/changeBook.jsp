<%@ page pageEncoding="utf-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="io.github.potatob6.Models.*" %>

<html>
    <head>
        <meta charset="UTF-8" />
        <style>
            * {
                padding: 0;
                margin: 0;
            }
            body {
                display: flex;
                background-color: #fff;
                justify-content: center;
                align-items: center;
                width: 100vw;
                height: 100vh;
            }
            input {
                border: 1px solid #ccc;
                background-color:transparent;
                border-radius: 5px;
                margin-left: 10px;
                height: 30px;
            }
            #main{
                border: 1px solid #ddd;
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 0 20px #ccc;
            }
            #main div{
                margin: 20px 0;
                display: flex;
                justify-content: space-between;
            }
            button {
                width: 40%;
                height: 30px;
                border: none;
                border-radius: 20px;
                background-color: #17b978;
            }
            button:hover {
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <%
            String bookID = request.getParameter("bookID");
            if(bookID==null) {
                out.println("Error");
                return;
            }
            OurDatabase ourDatabase = OurDatabase.getDataBase();
            BookBean book = new BookBean();
            book.setBookID(Integer.parseInt(bookID));
            BookBean bookBean = (BookBean)ourDatabase.queryBean(book, BookBean.class);
            if(bookBean==null) {
                out.println("Error");
                return;
            }
            System.out.println(bookBean);
        %>
        <form action="./changeBook_service">
            <div id="main">
                <input name="bookID" value="<%=bookBean.bookID %>" hidden />
                <div>图书类别ID: <input type="number" name="classID" value="<%=bookBean.classID %>"/></div>
                <div>书名: <input type="text" name="bookName" value="<%=bookBean.bookName %>"/></div>
                <div>出版社: <input type="text" name="publisher" value="<%=bookBean.publisher %>"/></div>
                <div>价格: <input type="text" name="originPrice" value="<%=bookBean.originPrice %>"/></div>
                <div>入库日期: <input type="text" name="storageDate" value="<%=bookBean.storageDate %>"/></div>
                <div>在库数量: <input type="number" name="storageCount" value="<%=bookBean.storageCount %>"/></div>
                <div>
                    <button type="submit" style="color: white">提交</button>
                    <button type="reset" style="background-color: #eee;" onclick="window.location.href='./AdminMainPage.jsp'">返回</button>
                </div>
            </div>
        </form>
    </body>
</html>