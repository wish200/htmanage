<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<!--系统登陆页面-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/jsp/common/taglibs.jsp" %>
<link rel="shortcut icon" href="${ctx }/images/title.jpg" type="/x-icon"/>
<title>绘听网络信息平台</title>
<script type="text/javascript">
$(function(){
	//解决浏览器记住账号密码后提示文字显示隐藏BUG
	$(':text,:password').each(function(i){
        if($(this).val() != '') $(this).nextAll('span').hide();
    });
    $(':text').click(function(i){
         $(':text').nextAll('span').hide();
         $(':password').nextAll('span').hide();
    });
	//输入框"X"操作
	$(':text,:password').keydown(function(){
		var _this = $(this);
		_this.nextAll('span').hide();
		if(!_this.parent().find('em').size()) _this.parent().append('<em></em>');
		
		_this.nextAll('em').click(function(){
			_this.val('');
			_this.nextAll('span').show();
			_this.focus();
			$(this).remove();
		});
	});
	
	//input框失去焦点后的提示文字与"X"显示隐藏
	$(':text,:password').blur(function(){
		$(':text,:password').each(function(i){
          if($(this).val() == '') $(this).nextAll('span').show();
        });
	});
	
	if("${loginMessage}"!=''){
	  $("#dtpass").html("<span style='margin-left:-23px'>你输入的用户名或者密码错误，请重新输入<span>");
	}
});

// function enterkey(){ 
// 	e = event.keyCode; 
// 	if (e==13){ 
// 	   if(haveData('username',"用户名不能为空！")
// 			&&haveData('password',"密码不能为空！")){
// 			$('#login').submit();
// 		}
// 	} 
// }  
//--登陆按钮 
function loginD(){
var username=true;var password=true;
   if($("#username").val()==''){
     $("#dtusername").html("您输入的用户名有误，请重新输入");
     username=false;
   }
   if($("#password").val()==''){
     $("#dtpass").html("您输入的密码有误，请重新输入");
     password=false;
   }
   if(username&&password){
      $('#login').attr('action',"${ctx}/common/login_login.do").submit();
   }
}

</script>
</head>
<body>
<div class="login_page">
	<div class="login_header">
    	<h1 class="login_logo">
        	<img src="${ctx }/images/login_logo_1.png" width="342" height="32" alt="绘听网络信息平台" />
        </h1>
    </div>
    <div class="login_wap">
    	<div class="login_con">
    	<form id="login" action="" method="post" autocomplete="off">
            	<dl>
                	<dd class="userIco">
                    	<input id="username" name="searchDto.userName" autocomplete="off" type="text" />
                    	<span>请输入用户名</span>   
                    </dd>
                    <dt id="dtusername" ></dt>
                	<dd class="passwordIco">
                    	<input id="password" name="searchDto.passWord" autocomplete="off" type="password" />
                    	<span>请输入密码</span>
                    </dd>
                    <dt id="dtpass" ></dt>
                </dl>
                <p><input onclick="loginD()" type="button" value="登　录" class="btnLogin" /></p>
            </form>
    </div>
    </div>
</div>
</body>
</html>