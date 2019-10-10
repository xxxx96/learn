<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/19
  Time: 19:09
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
    <span>Brand Introduction</span>
    <strong>品牌介绍</strong>
</div>
<div class="about-del">
    <p style="text-align: left; line-height: 1.75em;"><span style="color: rgb(247, 41, 78); font-size: 36px;">“</span><span style="color: rgb(247, 41, 78);">影艺婚纱摄影 —— </span><span style="font-size: 12px;">洛阳地区较早从事专业婚礼策划服务的高端婚礼服务牌，是知名的婚礼策划品牌。自创立至今已近二十年，婚庆人已成功服务数千对新婚客户，并为诸多知名媒体及组织提供过婚礼创意及私人聚会服务。</span></p>
    <p style="line-height: 1.75em; text-align: left;"><span style="font-size: 12px; color: rgb(129, 129, 129);">拥有领衔洛阳业内的服务管理体制及客户服务保障体系，自预约至沟通、跟踪、确定、执行、售后及服务后的每一个服务环节都有完善的记录与客户满意度跟踪反 馈。</span>
    </p>

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