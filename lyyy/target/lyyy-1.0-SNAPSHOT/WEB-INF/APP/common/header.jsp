<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/14
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath();  %>
<% String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>影艺婚纱摄影</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="telephone=no" name="format-detection">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>APP/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>APP/css/swiper.min.css">
    <script src="<%=basePath%>APP/js/jquery-1.7.1.min.js"></script>
    <script src="<%=basePath%>APP/js/swiper.min.js"></script>
    <script src="<%=basePath%>APP/js/my.js"></script>
</head>

