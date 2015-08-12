/**
 * 初始化公司基本信息
 * 
 * @param defValue
 *            默认公司code
 */
function initCompany(levelcode,mid,defaultValue) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getCompany.do?searchDto.levelCode="+levelcode,
		success : function(data) {
			initCompanyOption(data, mid,defaultValue);
		}
	});
}
function initCompanyOption(data, mid,defaultValue) {
	// 初始化默认选择
	var defaultCode = typeof (defaultValue) != "undefined" ? defaultValue : "";
	// 初始化默认选择
	var gson = data;
	var company = "";
	var i = 0;
	var option1 = "";
	$("#"+mid).empty();
	option1="<dd value='000000'>总公司</dd>";
	var size = gson.length;
	for (; i < size; i++) {
		company = gson[i];
		option1 += "<dd value='" + company.comcode + "'>" + company.comname
				+ "</dd>";

	}
	$("#"+mid).append(option1);
	if(defaultCode!=''){
		var defaultObj=$("#comCode").find("dd[value='" + defaultCode + "']");
		$("#comCode").prev('input').val(defaultObj.attr('value'));
		$("#comCode").parent('div').find('span').text(defaultObj.html());
	}
}

/*----------------------------- 
 Name: 公司下拉框 javascript
 Author: Zou_ZhuoQi
 Updater:  
 Time: 2013-12
 -----------------------------*/