<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/20
  Time: 21:08
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
    <span>Contact Us</span>
    <strong>联系我们</strong>
</div>
<div class="contact_box">
    <div class="myMap" id="myMap">
        <iframe id="geoPage" width="100%" height="100%" frameborder="0" scrolling="no" src="http://apis.map.qq.com/tools/poimarker?type=0&amp;marker=coord:34.746229,112.375561;coordtype:3;title:影艺婚纱公司;addr:地点：河南省洛阳市麻屯镇政府对面&amp;key=RQXBZ-YIJWP-6Z7DL-VFTNK-Z6PQH-U5FBP&amp;referer=myapp"></iframe>
    </div>
    <div class="contact-info">
        <p><span class="icon"><img src="<%=basePath%>APP/images/tele.png"></span><span><strong>咨询电话：</strong>15037950136</span></p>
        <p><span class="icon"><img src="<%=basePath%>APP/images/wx.png"></span><span><strong>微信号码：</strong>15037950136</span></p>
        <p><span class="icon"><img src="<%=basePath%>APP/images/tm.png" width="23" height="19"></span><span><strong>地址：</strong>河南省洛阳市麻屯镇政府对面</span></p>
    </div>
</div>
</body>
<script>
    var swiper = new Swiper('.banner', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        autoplay : 5000
    });
</script>
<jsp:include page="common/footer.jsp"/>