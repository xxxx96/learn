<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/21
  Time: 13:43
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
<div class="anlidel">
    <h1 class="news_tit">${details.title}<span>发布时间：${details.time}</span></h1>
    <div class="artview_intro">${details.preface}</div>
    <div class="artview_content" style="display:block;font-family:Microsoft YaHei;font-size:12px;color:#5A5A5A;font-weight:normal;text-decoration:none;">

        <div class="artview_detail" setsid="article64">
			<span style="line-height:1.5;"><span style="line-height:24px;font-family:微软雅黑;">${details.text}</span><br>
			<br>
			<span style="line-height:24px;font-family:微软雅黑;"></span><br>
			<span style="line-height:22px;font-family:微软雅黑;"></span><span style="line-height:22px;font-family:微软雅黑;"></span></span>
            <c:forEach items="${pic}" var="pic">
                <div style="text-align:center;">
                    <img src="../../root/${pic}" alt="" height="389" width="309" style="font-family: sans serif;,tahoma,verdana, helvetica; line-height: 1.5; max-width: 300px; height: auto;">
                </div>
            </c:forEach>
        </div>

    </div>

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
