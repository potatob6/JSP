<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/3/19
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./static/css/index.css">
    <link rel="stylesheet" href="./plugins/icheck-bootstrap-3.0.1/icheck-bootstrap.min.css">
    <link rel="stylesheet" href="./plugins/bootstrap-table/bootstrap-table.css">
    <style type="text/css">
    </style>
</head>
<body>
<div id="page-container" class="sidebar-l sidebar-o side-scroll header-navbar-fixed main-content-height">
    <nav class="navbar navbar-inverse navbar-head">
        <div class="container-fluid">
            <div class="navbar-header navbar-logo">
                <img alt="Brand" class="img-logo" src="/favicon.png">
            </div>

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#">主页</a></li>
                    <li class="active"><a href="#">网盘</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">更多 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"></a></li>
                            <li><a href="#">相关信息</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">备注</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">联系我们</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="row row-content">
        <div class="col-xs-2 nav-left-height">
            <ul class="nav nav-pills nav-stacked nav-pills-stacked-example nav-ul-height">
                <li role="presentation" class="active"><a href="#">主页</a></li>
                <li role="presentation"><a href="#">登录</a></li>
                <li role="presentation"><a href="#">加入我们</a></li>
            </ul>
        </div>
        <div class="col-lg-10 div-content">
            <div class="button-content">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">上传</button>
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">上传文件</a></li>
                        <li><a href="#">上传文件夹</a></li>
                    </ul>
                </div>
                <div class="btn-group" role="group" aria-label="Basic example">
                    <button type="button" class="btn btn-default">新建文件夹</button>
                </div>
            </div>
            <div class="breadcrumb-content">
                <ol class="breadcrumb">
                    <li><a href="#">返回上一级</a></li>
                    <li><a href="#">Library</a></li>
                    <li class="active">Data</li>
                </ol>
            </div>
            <div class="table-content">
                <table id="tableError" class="table table-bordered table-hover"
                       data-toggle="table"
                       data-classes="table table-hover"
                       data-striped="true"
                       data-height="613">
                    <thead>
                    <tr>
                        <th>
                            <div class="icheck-primary">
                                <input type="checkbox" id="check-all">
                                <label for="check-all"></label>
                            </div>
                        </th>
                        <th>文件名</th>
                        <th>大小</th>
                        <th>修改日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <div class="icheck-primary">
                                <input type="checkbox" id="check1">
                                <label for="check1"></label>
                            </div>
                        </td>
                        <td><i class="glyphicon glyphicon-folder-open"></i>&nbsp;&nbsp;&nbsp;我的文件夹</td>
                        <td>-</td>
                        <td>2020-12-12 11:13</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="icheck-primary">
                                <input type="checkbox" id="check2">
                                <label for="check2"></label>
                            </div>
                        </td>
                        <td><i class="glyphicon glyphicon-file"></i>&nbsp;&nbsp;&nbsp;我的文件</td>
                        <td>10M</td>
                        <td>2020-12-12 11:13</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="jquery-3.5.1/jquery-3.5.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="plugins/bootstrap-table/bootstrap-table.js"></script>
<script type="application/javascript">

</script>
</body>
</html>