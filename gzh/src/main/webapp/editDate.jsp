<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/include.jsp"%>
<head>
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <meta content="telephone=no, address=no" name="format-detection" />
    <link href="${ctx}/css/clear.css" rel="stylesheet">
    <link href="${ctx}/css/all.css" rel="stylesheet">
    <link href="${ctx}/css/mobiscroll.2.13.2.css" rel="stylesheet">
    <link href="${ctx}/css/jquery-confirm.min.css" rel="stylesheet">
    <script src="${ctx}/js/rem.js"></script>
</head>
<body>
<div id="page">
<!--     <div id="c-head">
        <header id="head">
            <div class="head-back"><i></i></div>
            <div class="head-title">添加纪念日</div>
            <div class="head-iconmore"></div>
        </header>
    </div> -->
    <div id="c-con">

        <div class="c-texts clearfloat">
            <div class="c-wrap">
                <input class="thingname" id="thingname" type="text" placeholder="事件名称(最多100字)" maxlength="100">
            </div>
        </div>
        <div class="c-texts clearfloat">
            <div class="c-wrap">
                <div class="settings" style="display:none;">
                    <select name="demo" id="demo">
                    </select>
                </div>
                <input name="test" id="test" placeholder="选择时间" class="demo-test-date demo-test-datetime demo-test-time demo-test-credit leftname" />
                <div class="onoff clearfloat" id="onoffdate">
                    <span class="on" id="on">公历</span>
                    <span class="off" id="off">农历</span>
                    <div class="onround" id="onround"></div>
                </div>
            </div>
        </div>
        <div class="c-texts clearfloat typechoose" id="typechoose">
            <div class="c-wrap">
                <span class="leftname">重复</span>
                <div class="r-type clearfloat">
                    <span class="r-types" id="typerepeat">不重复</span>
                    <i class="r-typeicon"></i>
                </div>
            </div>
        </div>
        <div class="c-texts clearfloat" id="typechooses">
            <div class="c-wrap">
                <span class="leftname">提醒</span>
                <div class="r-type clearfloat">
                    <span class="r-types" id="typeremind">不提醒</span>
                    <i class="r-typeicon"></i>
                </div>
            </div>
        </div>
        <div class="c-texts clearfloat">
            <div class="c-wrap">
                <span class="leftname">特别关注</span>
                <div class="onoff clearfloat" id="onoffattention">
                    <span class="on" id="on1">是</span>
                    <span class="off" id="off1">否</span>
                    <div class="onround" id="onround1"></div>
                </div>
            </div>
            <p style="font-size: .1rem">开启后此事件显示在顶部</p>
        </div>
        <!-- <div id="ckeep">保存</div> -->
        <div id="alert" style="color:#F00"> </div>
        <button id="ckeep">保 存</button>
        <button id="delete">删 除</button>
    </div>
    <div id="Mb">
        <div id="type-wrap">
            <div class="type-list">不重复</div>
            <div class="type-list">每天</div>
            <div class="type-list">每周</div>
            <div class="type-list">每月</div>
            <div class="type-list">每年</div>
        </div>
    </div>
    <div id="remindMb">
        <div id="type-wrapRemind">
            <div class="type-list">不提醒</div>
            <div class="type-list">每天</div>
            <div class="type-list">事件当天</div>
            <div class="type-list">提前一天</div>
            <div class="type-list">提前2天</div>
        </div>
    </div>
</div>
<script src="${ctx}/js/mobiscroll.2.13.2.js"></script>
<script src="${ctx}/js/fastclick.js"></script>
<script src="${ctx}/js/jquery-confirm.min.js"></script>
<script type="text/javascript">
    //选择类型
    var i = 0;
    var j = 0;
    var r=0;
    var typechoose = $("#typechoose");
    var typechooses = $("#typechooses");
    var ckeep = $("#ckeep");
    var Mb = $("#Mb");
    var remindMb = $("#remindMb");
    var typewrap = $("#type-wrap");
    var typewrapRemind = $("#type-wrapRemind");
    var thingname = $("#thingname");
    var alert = document.getElementById('alert');
    var test = document.getElementById('test');
    var isGC=0;
    var isAttention=0;
    var dateId;
    var openId;
    
    $(function () {
        var curr = new Date().getFullYear();
        var opt={};
        opt.date = {preset : 'date'};
        opt.datetime = {preset : 'datetime'};
        opt.time = {preset : 'time'};
        
        if(${sessionScope.date.gc}==true){
        	i=0;
        	$("#off").css("display","none");
            $("#on").css("display","block");
            $("#onround").css("left","calc(100% - .2rem)");
            $(this).css("background","#999");
            isGC=1;
            i++;
        }else{
        	i=1;
        	$("#off").css("display","block");
            $("#on").css("display","none");
            $("#onround").css("left","0");
            $(this).css("background","#bbb");
            i--;
            isGC=0;
        }
        
        if(${sessionScope.date.attentionDate}==1){
        	j=0;
            $("#off1").css("display","none");
            $("#on1").css("display","block");
            $("#onround1").css("left","calc(100% - .2rem)");
            $(this).css("background","#999");
            isAttention=1;
            j++;
        }else{
        	j=1;
            $("#off1").css("display","block");
            $("#on1").css("display","none");
            $("#onround1").css("left","0");
            $(this).css("background","#bbb");
            j--;
            isAttention=0;
        }
        
        $("#thingname").val("${sessionScope.date.dateTitle}");
        $("#typeremind").html("${sessionScope.date.repetRemind}");
        $("#typerepeat").html("${sessionScope.date.remindType}");
        $("#test").val("${sessionScope.date.remark3}");
        dateId="${sessionScope.date.dateId}";
        openId="${sessionScope.date.openId}";

        opt.default = {
            theme: 'android-holo light',
            display: 'modal',
            mode: 'scroller',
            dateFormat: 'yyyy-mm-dd',
            lang: 'zh',
            showNow: true,
            nowText: "今天",
            stepMinute: 5,
            startYear: curr - 117, //开始年份
            endYear: curr + 100 //结束年份
        };
        $('.settings').bind('change', function() {
            var demo = 'datetime';
            $('.demo-test-' + demo).scroller('destroy').scroller($.extend(opt['datetime'], opt['default']));
            $('.demo').hide();
            $('.demo-' + demo).show();
        });
        $('#demo').trigger('change');
    });
    
    document.title="编辑纪念日";
    //点击选择重复类型（弹出框type-wrap中加载重复类型数据）
    typechoose.on("click", function(){
        r = 1;
        Mb.css("display","block");
    });
    //点击选择提醒类型（弹出框type-wrap中加载提醒类型数据）
    typechooses.on("click", function(){
        r = 2;
        remindMb.css("display","block");
    });
     typewrap.on("click",".type-list", function(){
         var text = $(this).html();
       	 Mb.css("display","none");
         $("#typerepeat").html(text);
     });
     
     typewrapRemind.on("click",".type-list", function(){
         var text = $(this).html();
       	 remindMb.css("display","none");
         $("#typeremind").html(text);
     });
     
     function isnull(val) {
         var str = val;
         if (str == '' || str == undefined || str == null) {
             return true;
         } else {
             return false;
         }
     }
     
     ckeep.on("click", function(){
    	 console.log($("#test").val());
    	 if($("#thingname").val()==""){
    		 alert.innerHTML="事件名称不能为空";
    		 return;
    	 }else if($("#test").val()==""){
    		 alert.innerHTML="时间不能为空";
    		 return;
    	 }else{
    		 alert.innerHTML="";
    	 }
    	 
	    $.ajax({     
	        type:"POST",     
	        url:ctx+"/saveDateDetils",
			dataType : "json",
			data:{
					"typerepeat":$("#typerepeat").html(),
					"typeremind":$("#typeremind").html(),
					"isGC":isGC,
					"isAttention":isAttention,
					"thingname":$("#thingname").val(),
					"datetime":$("#test").val(),
					"dateId":dateId,
					"openId":openId
					
				},
			success : function(data) {
				$("#typerepeat").html('');
				$("#typeremind").html('');
				isGC=0;
				isAttention=0;
				$("#thingname").val('');
				$("#test").val('');
				$.ajax({     
			        type:"POST",     
			        url:ctx+"/getDateList",
					dataType : "json",
					data:{ },
					success : function(data) {
						window.location.href=ctx+'/dateList.jsp'; 
					}
				});
				
			}
		});
    	 
     });
     
     
     $("#delete").on("click", function(){
    	 $.confirm({
			    title: '提示',
			    content: '确定要删除吗?',
			    width:"100px",
			    buttons: {
			        confirm:{
                     text: "确 定",
                     btnClass: 'btn-primary',
                     keys: ['enter'],
                     action: function(){
                    	 deleteDate();
                     }
                 },
			        cancel:{
                     text: "取 消",
                     btnClass: 'btn-primary',
                     keys: ['esc'],
                     action: function(){
                     }
                 } 
			    }
			});
     });
     
     function deleteDate(){
 	    $.ajax({     
	        type:"POST",     
	        url:ctx+"/deleteDate",
			dataType : "json",
			data:{
					"dateId":dateId
				},
			success : function(data) {
				$.ajax({     
			        type:"POST",     
			        url:ctx+"/getDateList",
					dataType : "json",
					data:{ },
					success : function(data) {
						window.location.href=ctx+'/dateList.jsp'; 
					}
				});
				
			}
		});
     }

    //是否特别关注（默认否）
    
    $("#onoffdate").on("click", function(){
        if(i==0){
            $("#off").css("display","none");
            $("#on").css("display","block");
            $("#onround").css("left","calc(100% - .2rem)");
            $(this).css("background","#999");
            isGC=1;
            i++;
        }else{
            $("#off").css("display","block");
            $("#on").css("display","none");
            $("#onround").css("left","0");
            $(this).css("background","#bbb");
            i--;
            isGC=0;
        }
    });
    
    
    $("#onoffattention").on("click", function(){
        if(j==0){
            $("#off1").css("display","none");
            $("#on1").css("display","block");
            $("#onround1").css("left","calc(100% - .2rem)");
            $(this).css("background","#999");
            isAttention=1;
            j++;
        }else{
            $("#off1").css("display","block");
            $("#on1").css("display","none");
            $("#onround1").css("left","0");
            $(this).css("background","#bbb");
            j--;
            isAttention=0;
        }
    });
</script>
</body>
</html>