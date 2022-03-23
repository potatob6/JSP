<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>图书查询</title>


	<script type="text/javascript">
		function $(id) {
			return document.getElementById(id);
		}

		function checkReg() {
			var bookseach = $("bookseach").value;
			var checkright = true;
			if (bookseach == "" ) //检查为空
			{
				alert("请确认输入是否正确！！");
				checkright = false;
			} else 
			{
			return checkright;
		}
	</script>

	<link href="css/BookSeek/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/BookSeek/style.css" rel='stylesheet' type='text/css' />
	<link href="./fonts/fonts" rel="stylesheet">
	<link rel="stylesheet" href="./css/login.css" />
	<link rel="stylesheet" href="./css/nav.css" />
	<link rel="stylesheet" href="./css/footer.css">
	<link
			href="./css/all.css"
			rel="stylesheet"
	/>
<body>

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
	</header>

	<div id="home" class="banner-w3pvt d-flex">
		<div class="container">
			<form action="index.html" method="get" onSubmit="return checkReg()" onReset="clearInfo()">

				<div class=" bnr-txt-w3pvt">
					<div class="bnr-w3pvt-txt mt-sm-5">

                    <strong><h2>图书查询</h2><br></strong>
						<div class="form-group col-md-6">
							<h4>您可以选择输入书籍信息<br>或选择图书类型查询图书</h4><br><br>
							<input type="text" class="form-control" id="myname" value="" required="required"
								placeholder="请输入书籍ISBN/书名或信息！" name="">
								<br>
						</div>
						<div class="form-group col-md-6">
							<input list="Area" placeholder="请选择图书类型！" />
							<datalist id="Area">
								<option value="医学.养身">
								<option value="文学">
								<option value="政治.法律">
								<option value="儿童读物">
								<option value="百科">
								<option value="社会科学">
								<option value="古典名著">
								<option value="社会科学">
								<option value="历史">
								<option value="地理">
							</datalist>
								&nbsp;&nbsp;&nbsp;
								<input type="reset" name="" id="" value="重置" />
								&nbsp;&nbsp;&nbsp;<input type="submit" name=""
									id="" value="查询" />
						</div>

						
						</div>

					</div>
				</div>

			</form>
		</div>
	</div>
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
