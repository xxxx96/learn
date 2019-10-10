<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/21
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();  %>
<% String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>
<jsp:include page="common/header.jsp"/>
<body>
<div class="top">
    <a class="logo" href="index"><img src="<%=basePath%>APP/images/logo.png"></a>
    <h1>影艺婚纱摄影</h1>
    <span class="hide-nav"></span>
</div>
<div class="banner">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="<%=basePath%>APP/images/m_ban1.jpg"></div>
        <div class="swiper-slide"><img src="<%=basePath%>APP/images/m_ban2.jpg"></div>
        <div class="swiper-slide"><img src="<%=basePath%>APP/images/m_ban3.jpg"></div>
    </div>
    <div class="swiper-pagination"></div>
    <div class="activ-tit">
        <strong>婚纱摄影领导品牌</strong>
        <span>——执子之手 与子偕老——</span>
    </div>
</div>
<div class="about">
    <span>Guest Appreciation</span>
    <strong>客片大赏</strong>
</div>

<div class="viewdel-box">
    <h1 class="news_tit">${details.manSurname}先生&${details.womanSurname}小姐<span>发布时间：2017-02-23</span></h1>
    <div class="artview_intro">
        <c:forEach items="${pic}" var="pic">
            <img src="../root/${pic}">
        </c:forEach>
    </div>
</div>
<div class="clear"></div>
</body>
<script>
    var swiper = new Swiper('.banner', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        autoplay : 5000
    });
</script>
<jsp:include page="common/footer.jsp"/>
