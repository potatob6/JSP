<%@ page pageEncoding="utf-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="io.github.potatob6.Models.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        #whiteBoard{
            position: fixed;
            top: 0;left: 0vw;width: 100vw;height: 100vh;
            z-index: 7000;
            background-color: white;
            transition: all 1s;
            opacity: 1;
            box-shadow: 0 0 10px gray;
        }
        #nav,
        #classfied{
            display: flex;
            width: 100vw;
            height: 55px;
            flex-direction: row;
            justify-content: center;
            align-items: center;
        }
        #classfied{
            padding: 10px 0;
            width: 80%;
            justify-content: flex-start;
        }
        #nav_item1{
            height: 40px;
            line-height: 40px;
            flex-shrink: 0;
            color: #426799;
            font-size: large;
            font-family: "等线";
            font-weight: bold;
        }
        #nav_placeholder{
            width: 0;
            height: 40px;
            background-color: white;
            transition: all 0.5s;
        }
        #search{
            height: 30px;
            display: flex;
            justify-content: flex-end;
            flex-direction: row;
            align-items: center;
            padding: 0 5px;
            width: 100%;
            border: none;
            margin: 0 10px;
        }
        #search img{
            width: 15px;
            height: 15px;
            margin-right: 5px;
        }
        #search input{
            height: 33px;
            border: none;
            border-radius: 3px;
            width: 0%;
            outline: none;
            transition: all 0.5s;
            background-color: transparent;
        }
        .clickable{
            flex-shrink: 0;
            margin: 0 10px;
            font-size: small;
            color: gray;
        }
        .clickable:hover{
            cursor: pointer;
            color: #426799;
        }
        #notification{
            width: 100vw;
            background-color: #E8ECF3;
            position: relative;
            height: auto;
            overflow: hidden;
            transition: all 1s;
        }
        .btnself, Button{
            padding: 10px 20px;
            height: 40px;
            border: none;
            border-radius: 5px;
            color: white;
            background-color: #4D698E;
            font-weight: 600;
            letter-spacing: 1px;
        }
        .btnself:hover, Button:hover {
            cursor: pointer;
            background-color: #445D7D;
        }
        .classfied_item{
            padding: 10px;
            margin-left: 10px;
            font-size: small;
            color: #4D698E;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-shrink: 0;
        }
        .classfied_item:hover{
            cursor: pointer;
            color: #445D7D;
        }
        .classfied_item img,
        .classfied_item div{
            width: 15px;
            height: 15px;
            margin: 0 3px;
        }
        #mainCont{
            position: relative;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            width: 80vw;
        }
        .mainCont_item_title,
        .mainCont_item_body{
            width: 100%;
            display: flex;
            justify-content: flex-start;
            align-items: flex-start;
            position: relative;
        }
        .mainCont_item{
            padding: 20px 10px;
            width: 100%;
            border-radius: 10px;
            margin-bottom: 20px;
            transition: all 0.3s;
            background-color: #F8FCFF;
        }
        .mainCont_item:hover{
            /* background-color: #F3F6F9; */
            box-shadow: 0 0 20px lightgray;
        }
        .avatar{
            width: 50px;
            height: 50px;
            flex-shrink: 0;
            padding: 0 10px;
            border-radius: 50%;
        }
        .title_mid{
            width: 100%;
            position: relative;
        }
        .title_mid span{
            width: 100%;
            display: inline-block;
        }
        .title_tail{
            position: relative;
            display: flex;
            flex-direction: row;
            justify-content: flex-end;
            align-items: center;
        }
        .title_tail div{
            width: 15px;
            height: 15px;
            border-radius: 5px;
        }
        .title_tail img{
            width: 30px;
            height: 30px;
        }
        .bodyText{
            color: gray;
        }
        .bodyText img{
            width: 200px;
            border-radius: 5px;
        }
        .mainCont_item{
            transition: all 0.5s;
        }
        .mainCont{
            transition: all 1s;
        }
    </style>
</head>
<body>
    <%
        UserBean userBean = (UserBean) request.getSession().getAttribute("login");
    %>
    <div id="whiteBoard"></div>
    <div id="nav">
        <div style="width: 80%;position: relative;display: flex;
            justify-content: row;justify-content: flex-start;align-items: center;
        ">
            <div id="nav_item1" onclick="window.location.href='./index.jsp'">Hello, 星星图书</div>
            <div id="nav_placeholder"></div>
            <div id="search" style="position: relative;">
                <img src="images/搜索.png" alt="" style="margin-left: 5px;" onclick="search()">
                <input id="search_input" onfocus="search(1)" type="text" onblur="search()" placeholder="搜索一下吧">
            </div>
            <div class="clickable">简体中文</div>
            <% if (userBean==null) { %>
                <div class="clickable" id="regist" onclick="pageLeave('./login.jsp')">注册</div>
                <div class="clickable" id="login" onclick="pageLeave('./login.jsp')">登录</div>
            <% } else { %>
                <div class="clickable" id="login_name" onclick="pageLeave('./UserMainPage.jsp')"><%=userBean.getNickname() %></div>
            <% } %>
        </div>
    </div>
    <div id="notification">
        <h2 style="color: #72889F;text-align: center;padding-top: 40px;">欢迎来到星星图书馆，讨论区</h2>
        <span style="color: #72889F;width: 100%;text-align: center;display: inline-block; padding-top: 20px;padding-bottom: 40px;">你可以在此与他人分享，或者向我们提出问题</span>
        <div style="position: absolute;right: 0;top: 0;bottom: 0;width: 50px;">
            <img onclick="closeNotification()" src="images/关闭.png" style="margin-top: 20px;" width="10" height="10" alt="">
        </div>
    </div>
    <div style="display: flex;justify-content: center;margin: 20px 0;">
        <form action="/JSP/sendForum" style="width: 80%;background-color: #E8ECF3;padding: 20px;border-radius: 10px;">
            <input name="title" id="title_u" type="text" placeholder="标题" style="margin-bottom: 20px;height: 30px;line-height: 30px;text-indent: 10px;border: none;width: 100%;outline: none;border-radius: 5px;">
            <textarea name="content" id="body_u" type="text" style="margin-bottom: 20px;height: 160px;resize: vertical;text-indent: 10px;border: none;width: 100%;outline: none;border-radius: 5px;" placeholder="说点什么..."></textarea>
            <input class="btnself" value="发送" type="submit"></input>
            <input class="btnself" value="重置" type="reset"></input>
        </form>
    </div>
    <div style="position: relative;width: 100%;display: flex;justify-content: center;align-items: center;" >
        <div id="classfied">
            <button>新的话题</button>
            <div class="classfied_item">
                <img src="images/所有招标项目.png" alt="">
                <span>所有话题</span>
            </div>
            <div class="classfied_item">
                <img src="images/分类.png" alt="">
                <span>分类</span>
            </div>
            <div class="classfied_item">
                <div style="width: 15px;height: 15px;border-radius: 5px;background-color: #03A9F4;"></div>
                <span>分享</span>
            </div>
            <div class="classfied_item">
                <div style="width: 15px;height: 15px;border-radius: 5px;background-color: #8BC34A;"></div>
                <span>问题</span>
            </div>
        </div>
    </div>
    <div style="position: relative;width: 100%;display: flex;justify-content: center;align-items: center;">
        <div id="mainCont">
            <%
                OurDatabase ourDatabase = OurDatabase.getDataBase();
                Connection connection = ourDatabase.getConnection();
                Statement statement = connection.createStatement();
                String sql = "select * from Forum order by forumID desc;";
                ResultSet resultSet = statement.executeQuery(sql);
                ArrayList<Object> arrayList = ourDatabase.fullSetupMultiByQuery(resultSet, ForumBean.class);
                for (int i = 0;i<arrayList.size();i++) {
                    ForumBean forum = (ForumBean) arrayList.get(i);
                    System.out.println(forum);
            %>
                <div class="mainCont_item">
                    <div class="mainCont_item_title">
                        <img class="avatar" src="images/头像.png" alt="">
                        <div class="title_mid">
                            <span style="font-weight: bold;"><%=forum.title %></span>
                            <span style="font-size: 10px;color: gray;">发布于<%=forum.getPushDate() %></span>
                        </div>
                        <div class="title_tail" style="flex-shrink: 0;">
                            <div style="background-color: #03A9F4;margin: 0 10px;"></div>
                            <img src="images/消息_o.png" alt="">
                            <span>0</span>
                        </div>
                    </div>
                    <div class="mainCont_item_body">
                        <div class="avatar" style="height: auto;"></div>
                        <div class="bodyText">
                            <%=forum.getContent() %>
                        </div>
                    </div>
                </div>
            <%
                }
            %>
            <div class="mainCont_item">
                <div class="mainCont_item_title">
                    <img class="avatar" src="images/ava0.jpg" alt="">
                    <div class="title_mid">
                        <span style="font-weight: bold;">大家今天读书了吗</span>
                        <span style="font-size: 10px;color: gray;">发布于08:45</span>
                    </div>
                    <div class="title_tail" style="flex-shrink: 0;">
                        <div style="background-color: #03A9F4;margin: 0 10px;"></div>
                        <img src="images/消息_o.png" alt="">
                        <span>104   </span>
                    </div>
                </div>
                <div class="mainCont_item_body">
                    <div class="avatar" style="height: auto;"></div>
                    <div class="bodyText">
                        听说图书馆位置占不到了
                    </div>
                </div>
            </div>
            <div class="mainCont_item">
                <div class="mainCont_item_title">
                    <img class="avatar" src="images/ava1.jpg" alt="">
                    <div class="title_mid">
                        <span style="font-weight: bold;">有人一起图书馆吗</span>
                        <span style="font-size: 10px;color: gray;">发布于1天前</span>
                    </div>
                    <div class="title_tail" style="flex-shrink: 0;">
                        <div style="background-color: #03A9F4;margin: 0 10px;"></div>
                        <img src="images/消息_o.png" alt="">
                        <span>25</span>
                    </div>
                </div>
                <div class="mainCont_item_body">
                    <div class="avatar" style="height: auto;"></div>
                    <div class="bodyText">
                        有人吗！！
                    </div>
                </div>
            </div>
            <div class="mainCont_item">
                <div class="mainCont_item_title">
                    <img class="avatar" src="images/ava2.jpg" alt="">
                    <div class="title_mid">
                        <span style="font-weight: bold;">这个我也很好奇，有可以给我普及一下的吗</span>
                        <span style="font-size: 10px;color: gray;">发布于1天前</span>
                    </div>
                    <div class="title_tail" style="flex-shrink: 0;">
                        <div style="background-color: #03A9F4;margin: 0 10px;"></div>
                        <img src="images/消息_o.png" alt="">
                        <span>50</span>
                    </div>
                </div>
                <div class="mainCont_item_body">
                    <div class="avatar" style="height: auto;"></div>
                    <div class="bodyText">
                        这个我也很好奇，有可以给我普及一下的吗
                    </div>
                </div>
            </div>
            <div class="mainCont_item">
                <div class="mainCont_item_title">
                    <img class="avatar" src="images/ava3.jpg" alt="">
                    <div class="title_mid">
                        <span style="font-weight: bold;">有什么书推荐一下吗</span>
                        <span style="font-size: 10px;color: gray;">发布于3天前</span>
                    </div>
                    <div class="title_tail" style="flex-shrink: 0;">
                        <div style="background-color: #03A9F4;margin: 0 10px;"></div>
                        <img src="images/消息_o.png" alt="">
                        <span>50</span>
                    </div>
                </div>
                <div class="mainCont_item_body">
                    <div class="avatar" style="height: auto;"></div>
                    <div class="bodyText">
                        刷
                        <br>
                        <br>
                        屏
                    </div>
                </div>
            </div>
            <div class="mainCont_item">
                <div class="mainCont_item_title">
                    <img class="avatar" src="images/ava4.jpg" alt="">
                    <div class="title_mid">
                        <span style="font-weight: bold;">图书馆什么时候开放啊</span>
                        <span style="font-size: 10px;color: gray;">发布于3天前</span>
                    </div>
                    <div class="title_tail" style="flex-shrink: 0;">
                        <div style="background-color: #03A9F4;margin: 0 10px;"></div>
                        <img src="images/消息_o.png" alt="">
                        <span>20</span>
                    </div>
                </div>
                <div class="mainCont_item_body">
                    <div class="avatar" style="height: auto;"></div>
                    <div class="bodyText">
                         求问
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function $(e){ return document.getElementById(e) }
        function $c(e){ return document.getElementsByClassName(e) }
        var mc = $("mainCont").children
        // for(var i = 0;i<mc.length;i++){
        //     mc[i].style.transform = "translateY("+Math.floor(Math.random()*1000+1000)+"px)"
        // }
        window.onload = (e)=>{
            $("whiteBoard").style.left = "100vw"
            var mc = $("mainCont").children
            // for(var i = 0;i<mc.length;i++){
            //     mc[i].style.transform = "translateY(0px)"
            // }
        }
        function pageLeave(e){
            $("whiteBoard").style.left = "0vw"
            setTimeout(() => {
                window.location.href = e
            }, 1000);
        }
        var searchOpen = false
        function search(n){
            if(n==undefined){
                if(!searchOpen){
                    $("search_input").style.width = "100%"
                    $("search").style.border = "2px solid #426799"
                    $("search").style.borderRadius = "5px"
                    $("search_input").focus()
                    searchOpen = true
                    return
                }
                $("search_input").style.width = "0"
                $("search").style.border = "0px solid #426799"

                searchOpen = false
            }else if(n==1){
                $("search_input").style.width = "100%"
                $("search").style.border = "2px solid #426799"
                $("search").style.borderRadius = "5px"
                $("search_input").focus()
                searchOpen = true
            }else{
                $("search_input").style.width = "0"
                $("search").style.border = "0px solid #426799"
                searchOpen = false
            }
        }
        function closeNotification(){
            $("notification").style.display = "none"
        }
    </script>
    <script>
        function create1(e) { return document.createElement(e) }
        function PrefixInteger(num, length) {
            return ( "000000000" + num ).substr( -length );
        }
        function reset(){
            $("title_u").value = ""
            $("body_u").value = ""
        }
    </script>
</body>
</html>