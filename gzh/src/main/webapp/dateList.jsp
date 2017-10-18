<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/include.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <meta content="telephone=no, address=no" name="format-detection" />
    <link href="${ctx}/css/clear.css" rel="stylesheet">
    <link href="${ctx}/css/all.css" rel="stylesheet">
    <script src="${ctx}/js/rem.js"></script>
</head>
<body>
<div id="page">
<!--     <div id="c-head">
        <header id="head">
            <div class="head-back"><i></i></div>
            <div class="head-title">我的纪念日</div>
            <div class="head-icon"></div>
        </header>
    </div> -->
    <div id="c-con">
       	<c:if test="${requestScope.dateList!=null && requestScope.dateList!=''}" var="condition" scope="request">
			<c:forEach var="adList" items="${requestScope.dateList}" varStatus="list">
				<c:if test="${adList.attentionDate==1}" var="condition" scope="request">
			 		<div class="c-text" onclick="getDetail('${adList.dateId}')">
			            <div class="c-wrap">
			                <span class="c-name">${adList.dateTitle}</span>
			                <span class="c-times">${adList.remark}<span class="c-time" style="font-size: .3rem;">${adList.remark1}</span>${adList.remark2}</span>
			            </div>
			            <p class="c-yytime">${adList.remark3}</p>
			        </div>
				</c:if>
				<c:if test="${adList.attentionDate==0}" var="condition" scope="request">
			 		<div class="c-text" onclick="getDetail('${adList.dateId}')">
			            <div class="c-wrap">
			                <span class="c-name">${adList.dateTitle}</span>
			                <c:if test="${adList.remark2=='今天'}" var="condition" scope="request">
			                	<span class="c-times">就是<span class="c-time c-today">今天</span></span>
			                </c:if>
			                <c:if test="${adList.remark2!='今天'}" var="condition" scope="request">
			                	<span class="c-times">${adList.remark}<span class="c-time">${adList.remark1}</span>${adList.remark2}</span>
			                </c:if>
			            </div>
			        </div>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${requestScope.dateList==null || requestScope.dateList==''}" var="condition" scope="request">
	       	<c:if test="${sessionScope.dateList!=null && sessionScope.dateList!=''}" var="condition" scope="request">
				<c:forEach var="adList" items="${sessionScope.dateList}" varStatus="list">
					<c:if test="${adList.attentionDate==1}" var="condition" scope="request">
				 		<div class="c-text" onclick="getDetail('${adList.dateId}')">
				            <div class="c-wrap">
				                <span class="c-name">${adList.dateTitle}</span>
				                <span class="c-times">${adList.remark}<span class="c-time" style="font-size: .3rem;">${adList.remark1}</span>${adList.remark2}</span>
				            </div>
				            <p class="c-yytime">${adList.remark3}</p>
				        </div>
					</c:if>
					<c:if test="${adList.attentionDate==0}" var="condition" scope="request">
				 		<div class="c-text" onclick="getDetail('${adList.dateId}')">
				            <div class="c-wrap">
				                <span class="c-name">${adList.dateTitle}</span>
				                <c:if test="${adList.remark2=='今天'}" var="condition" scope="request">
				                	<span class="c-times">就是<span class="c-time c-today">今天</span></span>
				                </c:if>
				                <c:if test="${adList.remark2!='今天'}" var="condition" scope="request">
				                	<span class="c-times">${adList.remark}<span class="c-time">${adList.remark1}</span>${adList.remark2}</span>
				                </c:if>
				            </div>
				        </div>
					</c:if>
				</c:forEach>
			</c:if>
		</c:if>
       	<c:if test="${(requestScope.dateList==null || requestScope.dateList=='')&&(sessionScope.dateList==null || sessionScope.dateList=='')}" var="condition" scope="request">
			<div class="c-text">
	            <div class="c-wrap">
	                <span class="c-name">你还没有添加纪念日</span>
	                <span class="c-times"></span>
	            </div>
	        </div>
		</c:if>

    </div>
    <div id="cadd"></div>
</div>
<script>
document.title="我的纪念日";
 	function getDetail(id){
	    $.ajax({     
	        type:"POST",     
	        url:ctx+"/getDetail",
			dataType : "json",
			data:{
					"dateId":id
					},
			success : function(data) {
				window.location.href=ctx+'/card.jsp'; 
			}
		});
	}
    	 
</script>
</body>
</html>