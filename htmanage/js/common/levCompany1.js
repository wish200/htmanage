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
		initDepartment(defaultCode);
	}
	$("#"+mid).parent('div').find('span').click(function(){
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
				initDepartment(thisInputvar.val());
				$("#department").parent('div').find('span').text("请选择");
				$("#department").parent('div').find('input').val("");
				thisul.find("dd").unbind("click");
				$("#department").parent('div').find('span').unbind("click");
			});
		}else{
		    thisul.fadeOut("fast");
		}
	});
}
/**
 * 初始化部门基本信息
 * 
 * @param defValue
 *            默认部门Code
 */
function initDepartment(comcode,defValue,depcatg) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getDep.do?searchDto.comCode="+comcode,
		success : function(data) {
			initDepartmentOption(data,defValue);
		}
	});
}
function initDepartmentOption(data,defValue) {
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
		
		$("#department").parent('div').find('span').click(function(){
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
					var depcode=$(this).attr('value');
					thisul.fadeOut("100");
					$("#depposition").parent('div').find('span').text("请选择");
					$("#depposition").parent('div').find('input').val("");
					thisul.find("dd").unbind("click");
				});
			}else{
			    thisul.fadeOut("fast");
			}
		});
}
/*----------------------------- 
 Name: 公司下拉框 javascript
 Author: Zou_ZhuoQi
 Updater:  
 Time: 2013-12
 -----------------------------*/