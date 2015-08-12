/*----------------------------- 
Name: 邮件类型
Author: 张洋洋
Updater:  
Time: 2013-10
[{"templatecatno":"T0001","templatecatname":"测试","validstate":"1","levelcode":1,"remark":"111"},
{"templatecatno":"T0002","templatecatname":"测试","validstate":"1","levelcode":1,"remark":"2123"}]

-----------------------------*/

function initTemplateCatno(defModule, defEmail) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getTemplateCatno.do",
		success : function(data) {
			templateModule(data, defModule, defEmail);
		}
	});

}

// 所属功能模块
function templateModule(data, defModule, defEmail) {
	// 初始化默认选择
	var defModuleValue = typeof (defEmail) != "undefined" ? defModule : "";
	var defEmailValue = typeof (defEmail) != "undefined" ? defEmail : "";

	var gson = data;
	var i = 0;
	var template = "";
	var templateSize = gson.length;
	var option1 = "<option value=\"\">请选择</option>";
	$("#templateModuleId").empty();
	for (; i < templateSize; i++) {
		template = gson[i];
		if (template.levelcode == 1) {
			option1 += "<option value='" + template.templatecatno + "'>"
					+ template.templatecatname + "</option>";
		}
	}
	$("#templateModuleId").append(option1);

	var moduleSelected = $("#templateModuleId").find(
			"option[value='" + defModuleValue + "']");
	moduleSelected.attr("selected", true);

	if (defModuleValue != '') {
		templateEmail(gson, defEmailValue);
	}

	$("#templateModuleId").bind("change", function() {
		templateEmail(gson);
	});

}

// 所属功能模块
function templateEmail(data, defEmail) {
	var option2 = "<option value=\"\">请选择</option>";
	$("#templateEmailId").empty();
	var module = $("#templateModuleId :selected").val();
	var gson = data;
	var i = 0;
	var template = "";
	var templateSize = gson.length;

	for (; i < templateSize; i++) {
		console.log(template);
		template = gson[i];
		if (template.levelcode == 2 && template.fathercode == module) {
			option2 += "<option value='" + template.templatecatno + "'>"
					+ template.templatecatname + "</option>";
		}
	}

	$("#templateEmailId").append(option2);

	var templateEmailSelected = $("#templateEmailId").find(
			"option[value='" + defEmail + "']");
	templateEmailSelected.attr("selected", true);
}