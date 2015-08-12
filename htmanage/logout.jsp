<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退出登录</title>
<%@include file="/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
$(function(){
	
	var message = $("#message").val();
	if(message ==null || message==""){
		alert("用户信息失效，请重新登录！");
	}else{
		alert(message);
	}
	 window.top.location.href=contextRootPath;
});

</script>
</head>

<body>
	 <input type="hidden" value="${loginMessage }" id="message"/>
</body>
</html>
