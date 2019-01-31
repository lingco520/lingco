<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title>battcn-plus - 登录</title>
<link href="http://static.battcn.com/back/css/bootstrap.min.css?v=3.3.5"	rel="stylesheet" />
<link href="http://static.battcn.com/back/css/font-awesome.min.css?v=4.4.0"	rel="stylesheet" />
<link href="http://static.battcn.com/back/css/animate.min.css" rel="stylesheet" />
<link href="http://static.battcn.com/back/css/style.min.css?v=4.0.0" rel="stylesheet" />
<link href="http://static.battcn.com/back/css/login.min.css" rel="stylesheet" />
<script type="text/javascript" src="http://static.battcn.com/back/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" src="http://static.battcn.com/back/js/plugins/layer/layer.min.js"></script>
<script>
	if (window.top !== window.self) {
		window.top.location = window.location
	};
</script>
</head>

<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-7">
				<div class="signin-info">
					<div class="logopanel m-b">
						<h1>[ battcn-plus ]</h1>
					</div>
					<div class="m-b"></div>
					<h3>
						欢迎使用 <strong>battcn-plus </strong>
					</h3>
					<ul class="m-b">
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							优势一：调用API，一键增删改查</li>
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							优势二：集成插件，不在为分页排序烦恼</li>
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							优势三：日志系统，进行数据分析</li>
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							优势四：持续更新，让系统更加强大</li>
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							优势五：界面自适应，兼容各大平台</li>
					</ul>
				</div>
			</div>
			<div class="col-sm-5">
                <h3>名称：${user.name!}</h3>
                <h3>城市：${user.location!}</h3>
                <h3>性别：<#if user.gender?string == 'm'>男<#else>女</#if></h3>
                <h3>注册时间：${user.createdAt?date!}</h3>
                <h3>头像：<img src="${user.avatarLarge!}"/></h3>
			</div>
		</div>
		<div class="signup-footer">
			<div class="pull-left">@布衣王者服装</div>
		</div>
	</div>
</body>

</html>