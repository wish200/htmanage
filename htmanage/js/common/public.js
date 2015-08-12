 //Jquery-ajax自定义函数
function asy_Ajax(url,data,dataType,successfm){
    $.ajax({
            url :url,
            type : 'POST',
            data :data,
            dataType : dataType,
            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
            error : function() {
                alert('系统错误。请与管理员联系');
            },
            success :successfm
        }); 
}

function characterLimit(id,length,alertMess){
	  var value=$("#"+id).val().replace(/[^\x00-\xff]/g, 'xx');
	  if(value.length>length){
		   alert(alertMess);
		   $("#" + id).focus();// 获取输入框焦点
		   return false;
	  }else{
		   return true;
	  }
}
/** ID是否有数据校验 */
function haveData(obj_id, title, defalutValue) {
	var val = defalutValue ? defalutValue : '';
	var obj_val = $.trim($("#" + obj_id).val());
	if (obj_val == val||obj_val == '') {
		alert(title);
		$("#" + obj_id).focus();// 获取输入框焦点
		return false;
	}
	return true;
}
//邮箱验证
function regEmail(emailId) {
	var email = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/;
	var obj_val = $("#" + emailId).val();
	if (!obj_val.match(email)) {
		alert("邮件格式不正确,参考:z@126.com");
		$("#" + emailId).focus();// 获取输入框焦点
		return false;
	}
	return true;
}