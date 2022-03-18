<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/3/16
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css/base.css" />
    <link rel="stylesheet" href="./css/nav.css" />
    <link rel="stylesheet" href="/css/footer.css" />
    <link
            href="https://cdn.bootcdn.net/ajax/libs/font-awesome/5.15.3/css/all.css"
            rel="stylesheet"
    />
    <link rel="stylesheet" href="./css/public.css" />
</head>
<body>
<!--navigation section-->
<header>
    <nav class="NoChangeNav">
        <div class="NavNoChange_fr">
            <p class="NavNoChange_fl">
                <a href="#">中国大陆</a>
            </p>
            <div class="NavNoChange_search">
                <form action="#" method="get" class="NavNoChange_fl2">
                    <input type="text" placeholder="热门搜索：机械师" />
                    <i class="fa fa-search" aria-hidden="true"></i>
                </form>
                <a href="mygxin.html"
                ><i class="fa fa-user" aria-hidden="true"></i
                ></a>
                <a href="#" class="er1"
                ><i class="fa fa-qrcode" aria-hidden="true"></i
                ></a>
                <div class="topbar-cart pull-right">
                    <a href="#" class="er1"><i></i>联系客服</a>
                </div>
                <p>
                    <a href="#"><img src="" /></a>
                </p>
            </div>
        </div>
        <div class="nav-menu flex-row">
            <div class="nav-brand">
                <a href="#" class="text-gray">星星之光</a>
            </div>
            <div class="toggle-collapse">
                <div class="toggle-icons">
                    <i class="fas fa-bars"> </i>
                </div>
            </div>
            <div>
                <div id="NavNoChange">
                    <ul class="nav-items">
                        <li class="nav-link">
                            <a href="#" id="linkedA">首页</a>
                        </li>
                        <li class="nav-link">
                            <a href="#" id="linkedA">我的空间</a>
                        </li>
                        <li class="nav-link">
                            <a href="#" id="linkedA">个人登录</a>
                        </li>
                        <li class="nav-link">
                            <a href="#" id="linkedA">图书查询</a>
                        </li>
                        <li class="nav-link">
                            <a href="#" id="linkedA">星星云</a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="socal text-gray">
                <a href="#"><i class="fab fa-weixin" aria-hidden="true"></i></a>
                <a href="#"><i class="fab fa-weibo" aria-hidden="true"></i></a>
                <a href="#"><i class="fab fa-qq" aria-hidden="true"></i></a>
            </div>
        </div>
    </nav>
</header>
<!--navigation section-->
<!--PersonalSpace-->
<!--位置提示-->
<div class="address" id="add">
    <div class="wrapper clearfix">
        <a href="index.html" class="fl">首页</a>
        <span>/</span>
        <a href="mygxin.html" class="on">个人中心</a>
    </div>
</div>
<!--位置提示-->
<!--main-->
<div class="PersonalSpaceMain">
    <div class="wrapper clearfix">
        <div class="PersonalSpaceLeft fl">
            <h4>
                <a href="#"><img src="images/HeadImage.png" /></a>
                <p class="clearfix">
                <span class="fl">[星包客]</span
                ><span class="fr">[退出登录]</span>
                </p>
            </h4>
            <div>
                <h4>我的图书</h4>
                <ul>
                    <li><a href="cart.html">我的图书</a></li>
                    <li><a href="myorderq.html">我的会员</a></li>
                    <li><a href="myprod.html">书籍评价</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li class="on"><a href="mygxin.html">我的中心</a></li>
                    <li><a href="address.html">借阅管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="mygrxx.html">个人信息</a></li>
                    <li><a href="remima.html">修改密码</a></li>
                </ul>
            </div>
        </div>
        <div class="PersonalSpaceRight fl">
            <div class="PersonalInformation clearfix">
                <div class="fl clearfix">
                    <a href="#" class="fl"><img src="images/HeadImage.png" /></a>
                    <p class="fl">
                        <span>星包客</span><a href="mygrxx.html">修改个人信息></a>
                    </p>
                </div>
                <div class="fr">绑定邮箱：14****0@qq.com</div>
            </div>
            <div class="PersonalSpaceMain">
                <div class="clearfix">
                    <a href="#" class="fl"><img src="images/gxin1.jpg" /></a>
                    <p class="fl">
                        <span>个人信息：<strong>0</strong></span>
                        <a href="myorderq.html">查看个人信息></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a href="#" class="fl"><img src="images/gxin2.jpg" /></a>
                    <p class="fl">
                        <span>借阅图书：<strong>0</strong></span>
                        <a href="myorderq.html">查看借阅图书></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a href="#" class="fl"><img src="images/gxin3.jpg" /></a>
                    <p class="fl">
                        <span>待评价图书：<strong>0</strong></span>
                        <a href="myprod.html">查看待评价图书></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a href="#" class="fl"><img src="images/gxin4.jpg" /></a>
                    <p class="fl">
                        <span>喜欢的图书：<strong>0</strong></span>
                        <a href="#">查看喜欢的图书></a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!--main-->
<!--PersonalSpace-->

<!--footer-->
<div class="footer">
    <div class="footer_container w">
        <div class="footer_social">
            <a href=""><img src="./images/camscanner.png" alt="官方微博" /></a>
            <a href=""><img src="images/camscanner.png" alt="官方公众号" /></a>
            <a href=""><img src="images/camu_camera.png" alt="客服QQ" /></a>
        </div>
        <div class="footer_copyright">Copyright 2021</div>
    </div>
    <p class="dibu">
        星星网站&copy;2013-2025公司版权所有
        陇ICP备080100-44备0000111000号<br />
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试
    </p>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script src="/Javascript/public.js"></script>
<!--footer-->
</body>
</html>


