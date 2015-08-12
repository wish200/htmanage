/**
 * 初始化部门基本信息
 * 
 * @param defValue
 *            默认部门Code
 */
function initDepartment(comcode,defValue) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getDep.do?searchDto.comCode="+comcode,
		success : function(data) {
			initDepartmentOption(data, defValue);
		}
	});
}
function initDepartmentOption(data, defValue) {
	// 初始化默认选择
	var defCode = typeof (defValue) != "undefined" ? defValue : "";
	var gson = data;
	var department = "";
	var i = 0;
	var option1 = "<dd value=\"\">请选择</dd>";
		$("#department").empty();
		var size = gson.length;
		for (; i < size; i++) {
			department = gson[i];
			option1 += "<dd title='"+department.depname+"' imp='"+department.depcatg+"' value='" + department.newdepcode + "'>"
					+ department.depname + "</dd>";

		}
		$("#department").append(option1);
		var selected = $("#department").find("dd[value='" + defCode + "']");
		selected.attr("selected", true);
		$("#department").prev().prev().click(function(){
			var thisinput=$(this);
			var thisInputvar=$(this).next("input");
			var thisul=$(this).parent().find("dl");
			if(thisul.css("display")=="none"){
				if(thisul.height()>150){thisul.css({height:"100"+"px","overflow-y":"scroll"});};
				thisul.fadeIn("100");
				thisul.parent().css("z-index","9999");
				thisul.hover(function(){},function(){thisul.fadeOut("100");thisul.parent().css("z-index","2");});
				thisinput.parent().hover(function(){},function(){thisul.fadeOut("100");thisul.parent().css("z-index","2");});
				thisul.find("dd").click(function(){
					thisinput.text($(this).text());
					thisInputvar.val($(this).attr('value'));
					thisul.fadeOut("100");
					});
				}
			else{
				thisul.fadeOut("fast");
				}
		});
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