<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/21
  Time: 13:01
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
    <span>Case Apprecaction</span>
    <strong>案例赏析</strong>
</div>
<div class="anli-box">
    <div class="waterfall">
        <ul class="prolists">
            <c:forEach items="${details}" var="each">
                <li>
                    <a href="anlidel?id=${each.id}"><img src="../root/${each.picUrl}"></a>
                    <a class="urlfont" href="anlidel?id=${each.id}">${each.title}</a>
                    <a class="abstract" href="anlidel?id=${each.id}">${each.preface}</a>
                </li>
            </c:forEach>


        </ul>

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