<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/14
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath();  %>
<% String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>
<jsp:include page="common/header.jsp" />
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
<div class="wed-tit">
    <span>The Latest Activity</span>
    <span>——珍藏最动人的时刻，留存最迷人的瞬间——</span>
    <span>影艺摄影<em class="red">最新活动</em></span>
</div>
<ul class="active-list">
    <li><a href="javascript:"><img src="<%=basePath%>APP/images/m_act1.jpg"></a></li>
    <li><a href="javascript:"><img src="<%=basePath%>APP/images/m_act2.jpg"><span>遇见你<em>在樱花烂漫的季节</em></span></a></li>
    <li><a href="javascript:"><img src="<%=basePath%>APP/images/m_act3.jpg"><span>感恩回馈</span></a></li>
</ul>
<div class="clear"></div>
<div class="activ-img">
    <img src="<%=basePath%>APP/images/m_ad.jpg">
    <div class="activ-word">
        <span>Full-summer Day</span>
        <span class="big">约惠盛夏之时</span>
        <span>酷热动人</span>
    </div>
</div>
<div class="wed-tit">
    <span>Popular Package</span>
    <span>——珍藏最动人的时刻，留存最迷人的瞬间——</span>
    <span>影艺摄影<em class="red">人气套系</em></span>
</div>
<div class="product">
    <ul>
        <c:forEach items="${details}" var="details">
            <c:if test="${details.categoryId==11}">
            <li>
                <a href="<%=basePath%>app/anlidel?id=${details.id}"><img src="../root/${details.picUrl}">
                    <div class="list-info">
                        <strong>${details.title}</strong>
                        <span>唯美场景</span>
                        <img src="<%=basePath%>APP/images/flower.png" width="100">
                    </div>
                </a>
            </li>
            </c:if>
        </c:forEach>
    </ul>
</div>
<div class="wed-tit">
    <span>Guest Appreciation</span>
    <span>——珍藏最动人的时刻，留存最迷人的瞬间——</span>
    <span>影艺摄影<em class="red">客片赏析</em></span>
</div>
<div class="anli">
    <ul>
        <c:forEach items="${details}" var="details">
            <c:if test="${details.categoryId==12}">
                <li>
                    <a href="<%=basePath%>app/view_del?id=${details.id}">
                        <img src="../root/${details.picUrl}">
                        <div class="anli-tit"><br>${details.manSurname}先生<br>&<br>${details.womanSurname}小姐</div>
                    </a>
                </li>
            </c:if>
        </c:forEach>
    <a href="view" class="btnarea">查看更多</a>
</div>
<jsp:include page="common/footer.jsp"/>
<script>
    var swiper = new Swiper('.banner', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        autoplay : 5000
    });
</script>
</body>
</html>
