/**
 * 初始化部门基本信息
 * 
 * @param defValue
 *            默认部门Code
 */
var departmentHtml;
function initDepartment(id,defValue) {
	
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getDep.do",
		success : function(data) {
			if(arguments.length==1){
				initDepartmentOption('',data, defValue);
			}else{
				initDepartmentOption(id,data, defValue);
			}
		}
	});
}
function initDepartmentOption(id,data, defValue) {
	
	// 初始化默认选择
	var defCode = typeof (defValue) != "undefined" ? defValue : "";
	var gson = data;
	var department = "";
	var i = 0;
	var option1 = "<option value=\"\">请选择</option>";
	if(id==''){
		$("#department").empty();
		var size = gson.length;
		for (; i < size; i++) {
			department = gson[i];
			option1 += "<option imp='"+department.depcatg+"' value='" + department.newdepcode + "'>"
					+ department.depname + "</option>";

		}
		$("#department").append(option1);
		var selected = $("#department").find("option[value='" + defCode + "']");
		selected.attr("selected", true);
		
	}else{
		$("#"+id).empty();
		var size = gson.length;
		for (; i < size; i++) {
			department = gson[i];
			option1 += "<option imp='"+department.depcatg+"' value='" + department.newdepcode + "'>"
					+ department.depname + "</option>";

		}
		$("#"+id).append(option1);
		var selected = $("#"+id).find("option[value='" + defCode + "']");
		selected.attr("selected", true);
	}
	departmentHtml=option1;
}
/**
 * 含有条件的
 * @param searchDto
 * @param defValue
 */
function initDepartmentSearchDto(depCatg,defValue){
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getDep.do?searchDto.depCatg="+depCatg,
		success : function(data) {
				initDepartmentOption('',data, defValue);
		}
	});
}

/*----------------------------- 
 Name: 部门下拉框 javascript
 Author: Zou_ZhuoQi
 Updater:  
 Time: 2013-12
 -----------------------------*/