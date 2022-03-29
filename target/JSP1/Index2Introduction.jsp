<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/3/28
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>星星云详细介绍</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        body {
            height: 100vh;
            background: url("./images/background4.jpg") center center no-repeat ;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            overflow-x: hidden;
        }

        input {
            height: 100%;
            width: 100%;
        }

        #select {
            display: none;
        }

        .card {
            width: 400px;
            height: 600px;
            background-color: #ffffff;
            box-shadow: 0 0 50px 10px rgba((0), 0, 0, .3);
            transition: all .6s;
            text-align: center;
        }

        .img {
            width: 400px;
            height: 230px;
            background: url('./images/background2.png') no-repeat center center;
            background-size: cover;
            transition: all .6s;
        }

        .title {
            font-size: 30px;
            color: rgba(88, 88, 88);
            margin: 30px 0 15px 0;
            transition: all .6s;
            transition-delay: 3s;
        }

        .desc {
            width: 400px;
            margin-bottom: 20px;
            padding: 0 30px;
            line-height: 40px;
            opacity: 1;
            color: rgba(175, 175, 175);
        }

        .content {
            display: none;
            height: 1300px;
            text-align: center;
            padding: 0 20%;
            line-height: 40px;
            background-color: #ffffffff;
        }

        .content p {
            margin: 30px 0;
            text-align: left;
            display: table;
        }

        .icon {
            width: 300px;
            font-size: 22px;
            margin: 0 auto;
            display: flex;
            justify-content: center;
        }

        icon i {
            margin: 10px;
            font-size: 22px;
            color: red;
        }

        #select_label {
            display: block;
            position: absolute;
            width: 400px;
            height: 600px;
            z-index: 999;
        }

        #select:checked~.card #select_label {
            width: 100vw;
            height: 100vh;
        }

        #select:checked~.card {
            width: 100vw;
            height: 100vh;
        }

        #select:checked~.card .img {
            width: 100vw;
            height: 650px;
            overflow: hidden;
        }

        #select:checked~.card .title {
            transform: translate(-400px);
            color: #fff;
            font-size: 70px;
        }

        #select:checked~.card .desc {
            display: none;
            opacity: 0;
        }

        #select:checked~.card .icon {
            display: none;
        }

        #select:checked~.card .content {
            display: block;
            animation: content .2s;
            transform: translateY(-100px);
        }

        @keyframes content {
            from {
                opacity: 0;
                transform: translateY(0px);
            }
            to {
                opacity: 1;
                transform: translateY(-50px);
            }
        }
    </style>
</head>
<body>
<input type="checkbox" name="" id="select" />
<div class="card">
    <label for="select" id="select_label"></label>
    <div class="img"></div>
    <h2 class="title">星星云</h2>
    <p class="desc">
        星星云是星星图书管理系统的分享式云存储服务产品。为广大普通网民提供了存储容量大、免费、安全、便携、稳定的跨平台文件存储、备份、传递和共享服务。星星云为每个用户提供的免费初始容量空间，云盘最高上限是没有限制的。
    </p>
    <div class="content">
        <p>
            企业网盘是一个企事业单位私有的专用网盘系统，具有强大和简单易用的文档在线编辑预览、协同办公、部门或虚拟团队级文件共享、自动定时备份、历史资料归档等丰富功能。
        </p>
        <p>
            与免费的个人网盘相比，企业网盘具有更好的数据安全性，非单位人员一般无法获得系统登录地址，更不可能进入。同时企业网盘与个人网盘相比具有更强的团队协同功能，在组织架构、共享权限上能适应企业的需求。在多人共享、协作日常办公文档时能有效的提高工作效率。
        </p>
        <p>
            个人网盘的功能是存储和共享。存储，也就是上传一些电影电视剧、照片或者其他的相关资料。而共享，就是将你存储的资料分享给别人。个人网盘只要满足这两个功能，加上页面简洁易操作，就可以满足大部分用户的需求。但是，这两个功能对于企业网盘来说，远远不够。
        </p>
        <p>
            企业网盘是一种云产品，主要利用互联网后台数据中心的海量计算和存储能力为企业提供数据汇总分发、存储备份和管理等服务。企业网盘是针对企业而言的，是企业私有的专用网盘系统。与免费的个人网盘相比，企业网盘具有企业功能，如在线协同办公，团队资源共享、团队管理等。另外企业网盘比个人网盘更具有数据安全性。
        </p>
        <p>
            逐步关闭个人云盘服务，转型企业云服务。在网盘存储、传播内容合法性和安全性得到彻底解决之前不再考虑恢复，并在2017年2月1日清空用户数据。
        </p>
    </div>
    <div class="icon">
        <i class="fa fa-bookmark"></i>
        <i class="fa fa-facebook-official"></i>
        <i class="fa fa-twitter"></i>
        <i class="fa fa-instagram"></i>
    </div>
</div>
</body>
</html>

