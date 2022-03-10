<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书管理系统</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        #bg{
            width: 100vw;
            height: 100vh;
            position: relative;
            overflow: hidden;
        }
        #bgimg{
            position: absolute;
            top: 0; left: 0; right: 0; bottom: 0;
            background: url("./wallpaper.jpg") center center no-repeat;
            background-size: cover;
            filter: blur(1.1rem);
            transform: scale(1.2);
        }
        #main{
            position: fixed;
            left: 0; top: 0;
            width: 100vw;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        h2{
            color: white;
            font: 6rem lighter;
            letter-spacing: 20px;
            transition: all 0.3s;
        }
        h2:hover{
            cursor: pointer;
            color: gray;
            user-select: none;
        }
    </style>
</head>
<body>
    <div id="bg">
        <div id="bgimg"></div>
    </div>
    <div id="main">
        <h2 style="">图书管理系统</h2>
    </div>
</body>
</html>