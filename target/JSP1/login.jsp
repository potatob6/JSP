<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="星星图书管理系统" />
    <meta name="keywords" content="星星,管理,图书,理想,现实,知识." />
    <title>电商网站</title>
    <link rel="stylesheet" href="./css/login.css" />
    <link rel="stylesheet" href="./css/nav.css" />
    <link
      href="https://cdn.bootcdn.net/ajax/libs/font-awesome/5.15.3/css/all.css"
      rel="stylesheet"
    />
    <link rel="icon" href="./favicon.ico" mce_href="./favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="./favicon.ico" mce_href="./favicon.ico" type="image/x-icon">
  </head>
  <body>
    <!--navigation section-->
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
          <p>
            <a href="#"><img src="" /></a>
          </p>
        </div>
      </div>
      <div class="nav-menu flex-row">
        <div class="nav-brand">
          <a href="#" class="text-gray">星之光</a>
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
    <!--navigation section-->
    <main>
      <div id="LoginTitleSpace">
      </div>
      <section class="Background">
        <div class="card_front">
          <div class="Img">
            <img src="./images/cloud.png" alt="" id="cloud" />
            <img src="./images/bird1.png" alt="" id="bird1" />
            <img src="./images/bird2.png" alt="" id="bird2" />
            <img src="./images/forest.png" alt="" id="forest" />
            <img src="./images/water.png" alt="" id="water" />
            <img src="./images/moon.png" alt="" id="moon" />
            <img
              src="./images/mountains_behind.png"
              alt=""
              id="mountains_behind"
            />
            <img src="./images/mountains_front.png" alt="" id="mountains_front" />
          </div>
          <div class="JuddingFace">
            <div class="register box">
              <div class="form">
                <h2>注册</h2>
                <div class="inputBox">
                  <input
                    type="text"
                    name="user"
                    placeholder="请输入用户名:8~16位"
                    id="register_name"
                  />
                  <span id="s_username" class="error"></span>
                </div>
                <div class="inputBox">
                  <input
                    type="text"
                    placeholder="请填写注册邮箱"
                    id="register_email"
                  />
                  <span id="s_email" class="error"></span>
                </div>
                <div class="inputBox">
                  <input
                    type="text"
                    placeholder="请输入手机电话"
                    id="register_phone"
                  />
                  <span id="s_telphone" class="error"></span>
                </div>
                <div class="inputBox">
                  <input
                    type="password"
                    placeholder="请输入密码"
                    id="register_pwd"
                  />
                  <span id="s_password" class="error"></span>
                </div>
                <div class="inputBox">
                  <input
                    type="password"
                    placeholder="请再次输入密码"
                    id="register_repwd"
                  />
                  <span id="s_repassword" class="error"></span>
                </div>
                <div class="inputBox Center">
                  <input
                    type="Button"
                    placeholder="注册"
                    id="ChangeButton"
                    value="注册"
                    class="registerbutton"
                  />
                </div>
                <p class="forget Center">
                  返回登录?
                  <a href="#" class="ReturnLogin">点击这里</a>
                </p>
              </div>
            </div>
            <div class="login box">
              <div class="form">
                <h2>登录</h2>
                <form action="">
                  <div class="inputBox">
                    <input
                      type="text"
                      name="user"
                      placeholder="姓名"
                      id="login_name"
                    />
                  </div>
                  <div class="inputBox">
                    <input
                      type="password"
                      name="pwd"
                      placeholder="请输入密码"
                      id="login_pwd"
                    />
                  </div>
                  <div class="inputBox Center">
                    <input
                      type="Button"
                      placeholder="登录"
                      id="LoginButton"
                      value="登录"  href="index.html"
                    />
                  </div>
                  <p class="forget Center">
                    忘记密码?
                    <a href="#">点击这里</a>
                  </p>
                  <p class="forget Center">
                    没有密码?
                    <a href="#" class="RegisterButton">注册</a>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section>
        <div class="bottom_house">
          <div class="bottom Center"></div>
        </div>
      </section>
    </main>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="./Javascript/login.js"></script>
  </body>
</html>
