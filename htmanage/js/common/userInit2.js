/**
 * 初始化公司基本信息
 * 
 * @param defValue
 *            默认公司code
 */
function initCompany(levelcode,defaultValue,defaultnewdepcode,defaultdepposition) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getCompany.do?searchDto.levelCode="+levelcode,
		success : function(data) {
			initCompanyOption(data,defaultValue,defaultnewdepcode,defaultdepposition);
		}
	});
}
function initCompanyOption(data, defaultValue,defaultnewdepcode,defaultdepposition) {
	
	// 初始化默认选择
	var defaultCode = typeof (defaultValue) != "undefined" ? defaultValue : "";
	var gson = data;
	var company = "";
	var i = 0;
	var option1 = "";
	$("#comCode").empty();
	option1="";
	if(defaultValue=='000000'){
		option1+="<dd value='000000'>总公司</dd>";
		var size = gson.length;
		for (; i < size; i++) {
			company = gson[i];
			option1 += "<dd value='" + company.comcode + "'>" + company.comname
					+ "</dd>";
		}
	}else{
		var size = gson.length;
		for (; i < size; i++) {
			company = gson[i];
			if(company.comcode==defaultValue){
			option1 += "<dd value='" + company.comcode + "'>" + company.comname
					+ "</dd>";
			}
		}
	}
	$("#comCode").append(option1);
	if(defaultCode!=''){
		var defaultObj=$("#comCode").find("dd[value='" + defaultCode + "']");
		$("#comCode").prev('input').val(defaultObj.attr('value'));
		$("#comCode").parent('div').find('span').text(defaultObj.html());
		initDepartment(defaultCode,defaultnewdepcode,defaultdepposition);
	}
	$("#comCode").parent('div').find('span').click(function(){
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
				$("#depposition").parent('div').find('span').text("请选择");
				$("#depposition").parent('div').find('input').val("");
				thisul.find("dd").unbind("click");
				$("#department").parent('div').find('span').unbind("click");
				$("#depposition").parent('div').find('span').unbind("click");
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
function initDepartment(comcode,defValue,defaultdepposition) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getDep.do?searchDto.comCode="+comcode,
		success : function(data) {
			initDepartmentOption(comcode,data,defValue,defaultdepposition);
		}
	});
}
function initDepartmentOption(comcode,data,defValue,defaultdepposition) {
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
		
		if(defCode!=''){
			var defaultObj=$("#department").find("dd[value='" + defCode + "']");
			$("#department").prev('input').val(defaultObj.attr('value'));
			$("#department").prev('input').attr("imp",defaultObj.attr('imp'));
			$("#department").parent('div').find('span').text(defaultObj.html());
			var importev;
			if(comcode=='000000'){
				importev='1';
			}else{
				importev='2';
			}
			initDepPosition(importev,defaultObj.html(),defaultdepposition);
		}
		
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
					thisInputvar.attr("imp",$(this).attr('imp'));
					var depcode=$(this).attr('value');
					thisul.fadeOut("100");
					$("#depposition").parent('div').find('span').text("请选择");
					$("#depposition").parent('div').find('input').val("");
					var importev;
					if(comcode=='000000'){
						importev='1';
					}else{
						importev='2';
					}
					initDepPosition(importev,$(this).html());
					thisul.find("dd").unbind("click");
					$("#depposition").parent('div').find('span').unbind("click");
				});
			}else{
			    thisul.fadeOut("fast");
			}
		});
}
/**
 * 初始化部门岗位基本信息
 * 
 * @param defDep
 *            默认部门Code
 * @param defdepPos
 *            默认部门岗位代码
 */
function initDepPosition(importev,depm,defdepPos) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : contextRootPath + "/common/cond_getDepPos.do?searchDto.importlev="+importev,
			success : function(data) {
				initDepPositionOption(data,depm, defdepPos);
			}
		});
}

function initDepPositionOption(data,depm,defValue) {
	// 初始化默认选择
	var defCode = typeof (defValue) != "undefined" ? defValue : "";
	var gson = data;
	var depPosition = "";
	var i = 0;
	var option1 = "<dd value=\"\">请选择</option>";
	$("#depposition").empty();
	var size = gson.length;
	var heGui=false;
	var ziJin=false;
	var jingLi=false;
	if(depm.indexOf("合规")!=-1){//证明合规部的
		heGui=true;
	}
	if(depm.indexOf("经理")!=-1||$("#department").prev('input').attr("imp")=='0'){//证明合规部的
		jingLi=true;
	}
	if(($("#comCode").prev('input').val()=='000000')&&($("#department").prev('input').val()=='201206252219410062cvs08')){//证明是总公司信息技术部的人
		ziJin=true;
	}
	
	for (; i < size; i++) {
		depPosition = gson[i];
		if(jingLi&&depPosition.department==2){//经理或者总裁
			option1 += "<dd rem='"+depPosition.remark+"' value='" + depPosition.deppositioncode + "'>"
			+ depPosition.deppositionname + "</dd>";
		}
		if(heGui&&depPosition.department==1){//是合规部人员
			option1 += "<dd rem='"+depPosition.remark+"' value='" + depPosition.deppositioncode + "'>"
			+ depPosition.deppositionname + "</dd>";
		}
		if(ziJin&&depPosition.department==3){//证明是总公司资金运营部门的
			option1 += "<dd rem='"+depPosition.remark+"' value='" + depPosition.deppositioncode + "'>"
			+ depPosition.deppositionname + "</dd>";
		}
		if(depPosition.department==4&&!jingLi){//任何实体部门都有的岗位
			option1 += "<dd rem='"+depPosition.remark+"' value='" + depPosition.deppositioncode + "'>"
			+ depPosition.deppositionname + "</dd>";
		}
		if(!jingLi&&!heGui&&depPosition.department==5){//除总公司合规部没有 ---总公司经办岗外
			option1 += "<dd rem='"+depPosition.remark+"' value='" + depPosition.deppositioncode + "'>"
			+ depPosition.deppositionname + "</dd>";
		}
		/*if(heGui){
			if(depPosition.department==1){
				continue;
			}
			if(heGui){
				if(depPosition.department==3){
					continue;
				}
			}
		}*/
		
	}
	$("#depposition").append(option1);
	
	if(defCode!=''){
		var defaultObj=$("#depposition").find("dd[value='" + defCode + "']");
		$("#depposition").prev('input').val(defaultObj.attr('value'));
		$("#depposition").parent('div').find('span').text(defaultObj.html());
	}
	
	$("#depposition").parent('div').find('span').click(function(){
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
				thisul.find("dd").unbind("click");
			});
		}else{
		    thisul.fadeOut("fast");
		}
	});
}
