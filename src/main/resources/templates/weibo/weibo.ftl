<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的主页</title>
</head>
<body>
<h1>名称：${user.name!}</h1>
<h1>城市：${user.location!}</h1>
<h1>性别：<#if user.gender?string == 'm'>男<#else>女</#if></h1>
<h1>注册时间：${user.createdAt?date!}</h1>
<h1>头像：<img src="${user.avatarLarge!}"/></h1>
</body>
</html>