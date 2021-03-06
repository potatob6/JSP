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
            String userID = request.getParameter("userID");
            if(userID==null) {
                out.println("Error");
                return;
            }
            OurDatabase ourDatabase = OurDatabase.getDataBase();
            UserBean user = new UserBean();
            user.setUserID(userID);
            UserBean userBean = (UserBean)ourDatabase.queryBean(user, UserBean.class);
            if(userBean==null) {
                out.println("Error");
                return;
            }
            System.out.println(userBean);
        %>
        <form action="./changeUser_service">
            <div id="main">
                <input name="userID" value="<%=userBean.userID %>" hidden />
                <div>??????ID: <%=userBean.userID %></div>
                <div>????????????: <input type="number" name="pwd" value="<%=userBean.pwd %>"/></div>
                <div>??????: <input type="text" name="nickname" value="<%=userBean.nickname %>"/></div>
                <div>??????VIP: <input type="text" name="isVIP" value="<%=userBean.isVIP %>"/></div>
                <div>
                ?????????ID:
                <% if (userBean.cardID==null) { %>
                    <input type="text" value="????????????" readonly="readonly"/>
                <% } else { %>
                    <input type="text" name="cardID" value="<%=userBean.cardID %>"/>
                <% } %>
                </div>
                <div>??????: <input type="text" name="balance" value="<%=userBean.balance %>"/></div>
                <div>
                    <button type="submit" style="color: white">??????</button>
                    <button type="reset" style="background-color: #eee;" onclick="window.location.href='./AllUsers.jsp'">??????</button>
                </div>
            </div>
        </form>
    </body>
</html>