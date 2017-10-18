<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/include.jsp"%>
<head>
<meta charset="UTF-8">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <meta content="telephone=no, address=no" name="format-detection" />
    <link href="${ctx}/css/clear.css" rel="stylesheet">
    <link href="${ctx}/css/all.css" rel="stylesheet">
    <script src="${ctx}/js/rem.js"></script>
</head>
<body style="background-color: #fff;">
<div id="page">
<!--     <div id="c-head">
        <header id="head">
            <div class="head-back"><i></i></div>
            <div class="head-title">纪念日助手</div>
            <div class="head-icon"></div>
        </header>
    </div> -->
    <div id="c-con">
        <div class="c-wraps clearfloat">
            <!-- <a class="c-leftbtn c-btn" href="javascript:;">首页</a> -->
            <a class="c-rightbtn c-btn" onclick="toEditor()" href="javascript:;">编辑</a>
        </div>
        <div class="c-wraps c-msg clearfloat">
        <c:if test="${(sessionScope.date==null || sessionScope.date=='')}" var="condition" scope="request">
        	<div class="c-mtop">没有这个纪念日</div>
        </c:if>
        <c:if test="${(sessionScope.date!=null && sessionScope.date!='')}" var="condition" scope="request">
            <div class="c-mtop">${sessionScope.date.dateTitle}</div>
            <div class="c-mcon">
            <div class="c-mcons">
	            <c:if test="${sessionScope.date.remark2=='今天'}" var="condition" scope="request">
	           		<span class="c-mtit">就是<span class="c-time c-today">今天</span></span>
	            </c:if>
	            <c:if test="${sessionScope.date.remark2!='今天'}" var="condition" scope="request">
	            	<span class="c-mtit">${sessionScope.date.remark}<span class="c-mtime">${sessionScope.date.remark1}</span>${sessionScope.date.remark2}</span>
	            </c:if>
                <p class="c-mtimes">目标日:<span>${sessionScope.date.remark3}</span></p>
            </div>
            </div>
        </c:if>
        </div>
        <div class="c-wraps c-btns clearfloat">
            <!-- <button class="c-leftbtn c-btn">保存图片</button>
            <button class="c-rightbtn c-btn">分享</button> -->
        </div>
        <div class="c-wraps c-btns clearfloat">
            <button type="button" class="c-leftbtn c-btn" id="addT">添加提醒</button>
        </div>
    </div>
    <div id="Ms">
        <div id="Ms-con">
            <p class="ms-tit">长按-扫码-关注</p>
            <p>即可添加提醒</p>
            <img src="${ctx}/images/ewm.jpg" alt="">
        </div>
    </div>
</div>
<script src="${ctx}/js/jquery-2.1.0.min.js"></script>
<script src="${ctx}/js/fastclick.js"></script>
<script>
	document.title="纪念日助手";
    //弹出二维码弹
    var addT = $("#addT");
    var Ms = $("#Ms");
    var Mscon = $("#Ms-con");
    addT.on("click", function(){
        Ms.css("display","block");
        Mscon.css("opacity","1");
    });
    //隐藏二维码
    function stopPropagation(e) {
        var ev = e || window.event;
        if (ev.stopPropagation) {
            ev.stopPropagation();
        }
        else if (window.event) {
            window.event.cancelBubble = true;
        }
    }
    Ms.on("click",function () {
        Ms.css("display","none");
        Mscon.css("opacity","0");
    });
    Mscon.on("click",function (e) {
        stopPropagation(e);
    });
    
    function toEditor(){
    	window.location.href=ctx+'/editDate.jsp'; 
    }
</script>
</body>
</html>