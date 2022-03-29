<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/3/21
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>逆流行险，学无止境</title>
    <meta name="keywords" content="图书管理系统" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="/guestbook/css/index.css"/>
    <link rel="stylesheet" href="/guestbook/css/style.css"/>
    <script type="text/javascript" src="/guestbook/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="/guestbook/js/jquery.SuperSlide.2.1.1.js"></script>
    <script src="/guestbook/js/jquery-1.7.2.min.js"></script>
    <!-- bxSlider Javascript file -->
    <script src="/guestbook/js/jquery.bxslider.min.js"></script>
    <!-- bxSlider CSS file -->
    <link href="/guestbook/css/jquery.bxslider.css" rel="stylesheet" />

    <!--[if lt IE 9]>
    <script src="/guestbook/js/html5.js"></script>
    <![endif]-->
</head>
<body>
<!--header start-->
<div id="header">
    <h1>图书管理系统</h1>
    <p>逆流行险，不惧患难</p>
</div>
<!--header end-->
<!--nav-->
<div id="nav">
    <ul>
        <ul>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="MessageView">留言列表</a></li>
            <li><a href="guestbook.jsp">发表留言</a></li>
            <li><a href="lianjie.jsp">友情链接</a></li>
            <li><a href="login.jsp">管理员登录</a></li>
            <div class="clear"></div>
        </ul>
</div>
<!--nav end-->
<!--content start-->
<div id="content">
    <ul class="bxslider">
        <li>
            <ul>
                <li>
                    <div class="case_w">
                        <img src="/images/background2.png" />
                        <div class="fire"></div>
                        <a href="https://github.com/potatob6/JSP" class="x" target="_blank"></a>

                    </div>
                </li>
                <li>
                    <div class="case_w">
                        <img src="images/background3.png" />
                        <div class="fire"></div>
                        <a href="https://github.com/potatob6/JSP" target="_blank" class="x"></a>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul>
                <li>
                    <div class="case_w">
                        <img src="images/background4.jpg" />
                        <div class="fire"></div>
                        <a href="https://github.com/potatob6/JSP" target="_blank" class="x"></a>
                    </div>
                </li>
                <li>
                    <div class="case_w">
                        <img src="images/background5.jpg" />
                        <div class="fire"></div>
                        <a href="https://github.com/potatob6/JSP" target="_blank" class="x"></a>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul>
                <li>
                    <div class="case_w">
                        <img src="images/background4.jpg" />
                        <div class="fire"></div>
                        <a href="https://github.com/potatob6/JSP" target="_blank" class="x"></a>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul>
            </ul>
        </li>
        <li>
            <ul>
                <li>
                    <div class="case_w">
                        <img src="/guestbook/images/youtube.png" />
                        <div class="fire"></div>
                        <a href="https://www.youtube.com" target="_blank" class="x"></a>
                    </div>
                </li>
                <li>
                    <div class="case_w">
                        <img src="guestbook/images/twitter.com.png" />
                        <div class="fire"></div>
                        <a href="https://www.twitter.com" target="_blank" class="x"></a>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul>
                <li>
                    <div class="case_w">
                        <img src="guestbook/images/aiqiyi.png" />
                        <div class="fire"></div>
                        <a href="https://www.aiqiyi.com" target="_blank" class="x"></a>
                    </div>
                </li>
                <li>
                    <div class="case_w">
                        <img src="guestbook/images/appstore.com.png" />
                        <div class="fire"></div>
                        <a href="https://www.appstore.com" target="_blank" class="x"></a>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul>
                <li>
                    <div class="case_w">
                        <img src="guestbook/images/amazon.com.png" />
                        <div class="fire"></div>
                        <a href="https://www.amazon.com" target="_blank" class="x"></a>
                    </div>
                </li>
                <li>
                    <div class="case_w">
                        <img src="guestbook/images/youtube.com.png" />
                        <div class="fire"></div>
                        <a href="https://www.youtube.com" target="_blank" class="x"></a>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul>
                <li>
                    <div class="case_w">
                        <img src="guestbook/images/bdlogo.gif" />
                        <div class="fire"></div>
                        <a href="https://www.baidu.com" target="_blank" class="x"></a>
                    </div>
                </li>
                <li>
                    <div class="case_w">
                        <img src="/guestbook/images/google.com.png" />
                        <div class="fire"></div>
                        <a href="https://www.google.com" target="_blank" class="x"></a>
                    </div>
                </li>
            </ul>
        </li>
    </ul>
</div>
<div class="clear"></div>

</div>
<!--content end-->

<!--footer end-->
<script type="text/javascript">
    $(function(){
        $(".bxslider li ul li").hover(function(){
            $(".x",this).stop().css({'left':'35px'}).animate({'left':"40px"},400).show();
            $(".y",this).stop().css({'right':'35px'}).animate({'right':"40px"},400).show();
            $('.fire',this).fadeIn(500);
        },function(){
            // $('.x, .y',this).stop().animate({"top":"30px"},400);
            $('.fire, .x, .y',this).fadeOut(500);
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function(){
        $('.bxslider').bxSlider({
            minSlides: 4,
            maxSlides: 4,
            nextSelector: '#slider-next',
            prevSelector: '#slider-prev',
            slideWidth: 240,
            slideMargin:0,
            auto: false
        });
    });
</script>
<script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
<script  type="text/javascript" src="/guestbook/js/nav.js"></script>
</body>
</html>