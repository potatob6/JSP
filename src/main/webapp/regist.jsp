<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        body{
            width: 100vw;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }
        #topbar{
            height: 4rem;
            position: fixed;
            top: 0;right: 0;left: 0;
            z-index: 0;
        }
        #bg{
            position: fixed;
            top: 0; left: 0; right: 0; bottom: 0;
            background: url("wallpaper.jpg") center center no-repeat;
            filter: blur(2rem);
            transform: scale(1.1);
            background-size: cover;
            z-index: -1;
        }
        #topbar::after{
            position: fixed;
            z-index: -2;
            height: 4rem;
            opacity: 0.3;
            content: '';
            background-color: black;
            top: 0; left: 0; right: 0;
        }
        #regist_outter{
            position: relative;
            background: url("regist_pic.jpg") center center no-repeat;
            background-size: cover;
            width: 900px;
            height: 600px;
            border-radius: 10px;
            overflow: hidden;
        }
        #regist_right_cover{
            position: absolute;
            right: 0; top: 0; bottom: 0; left: 300px;
            backdrop-filter: blur(4rem);
            -webkit-backdrop-filter: blur(4rem);
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
        #regist_right_cover::before{
            position: absolute;
            right: 0; top: 0; bottom: 0; left: 0;
            content: '';
            background-color: black;
            opacity: 0.2;
            z-index: -1;
        }
        #regist_right_cover > * {
            color: white;
        }
        #regist_right_cover > div{
            margin: 20px 0;
            display: flex;
            width: 280px;
            flex-direction: row;
            align-items: center;
            justify-content: space-between;
        }
        input{
            margin: 0 20px;
            border: none;
            height: 2rem;
            outline: none;
            background-color: transparent;
            border-bottom: 2px solid #112d4e;
        }
    </style>
</head>
<body>
    <div id="bg"></div>
    <div id="topbar"></div>
    <div id="regist_outter">
        <div id="regist_right_cover">
            <h2>用户注册</h2>
            <div>
                <p>用户名</p>
                <input type="text">
            </div>
            <div>
                <p>密码</p>
                <input type="password">
            </div>
            <div>
                <p>确认密码</p>
                <input type="password">
            </div>
            <div>
                <p>电话号码</p>
                <input type="text">
            </div>
        </div>
    </div>
</body>
</html>