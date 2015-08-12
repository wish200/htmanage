/**
 * 初始化公司基本信息
 * 
 * @param defValue
 *            默认公司code
 */
function initCompany(id,defValue) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getCompany.do",
		success : function(data) {
			if(arguments.length==1){
				initCompanyOption('',data, defValue);
			}else{
				initCompanyOption(id,data, defValue);
			}
			
		}
	});
}
function initCompanyOption(id,data, defValue) {
	// 初始化默认选择
	var defCode = typeof (defValue) != "undefined" ? defValue : "";
	var gson = data;
	var company = "";
	var i = 0;
	var option1 = "<option value=\"\">请选择</option>";
	if(id==''){
		$("#company").empty();
		var size = gson.length;
		for (i=0; i < size; i++) {
			company = gson[i];
			option1 += "<option value='" + company.comcode + "'>" + company.comname+ "</option>";
			
		}
		$("#company").append(option1);
		var selected = $("#company").find("option[value='" + defCode + "']");
		selected.attr("selected", true);
	}else{
		$("#"+id).empty();
		var size = gson.length;
		for (i=0; i < size; i++) {
			company = gson[i];
			option1 += "<option value='" + company.comcode + "'>" + company.comname+ "</option>";
			
		}
		$("#"+id).append(option1);
		var selected = $("#"+id).find("option[value='" + defCode + "']");
		selected.attr("selected", true);
		
	}
	
}

/*----------------------------- 
 Name: 公司下拉框 javascript
 Author: Zou_ZhuoQi
 Updater:  
 Time: 2013-12
 -----------------------------*/