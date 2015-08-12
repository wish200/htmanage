/**
 * 初始化公司基本信息
 * 
 * @param defValue
 *            默认公司code
 */
function initCompany(levelcode,defaultValue) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getCompany.do?searchDto.levelCode="+levelcode,
		success : function(data) {
			initCompanyOption(data,defaultValue);
		}
	});
}
function initCompanyOption(data, defaultValue) {
	
	// 初始化默认选择
	var defaultCode = typeof (defaultValue) != "undefined" ? defaultValue : "";
	var gson = data;
	var company = "";
	var i = 0;
	var option1 = "";
	$("#comCode").empty();
	option1="<dd value='000000'>总公司</dd>";
	var size = gson.length;
	for (; i < size; i++) {
		company = gson[i];
		option1 += "<dd value='" + company.comcode + "'>" + company.comname
				+ "</dd>";
	}
	$("#comCode").append(option1);
	if(defaultCode!=''){
		var defaultObj=$("#comCode").find("dd[value='" + defaultCode + "']");
		$("#comCode").prev('input').val(defaultObj.attr('value'));
		$("#comCode").parent('div').find('span').text(defaultObj.html());
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
				$("#department").parent('div').find('span').text("请选择");
				$("#department").parent('div').find('input').val("");
				$("#depposition").parent('div').find('span').text("请选择");
				$("#depposition").parent('div').find('input').val("");
				
				$("#department").html(departmentHTML);
				if($(this).attr('value')=='000000'){
					$("#department").find('dd').each(function(){
						$(this).css("display","");
					});
				}else{
					$("#department").find('dd[imp=0]').each(function(){
						$(this).css("display","none");
					});
				}
				thisul.find("dd").unbind("click");
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
function initDepartment(defValue,depcatg) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getDep.do",
		success : function(data) {
			initDepartmentOption(data,defValue);
		}
	});
}
var departmentHTML;
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
			option1 += "<dd imp='"+department.depcatg+"' value='" + department.newdepcode + "'>"
					+ department.depname + "</dd>";

		}
		departmentHTML=option1;
		if(defCode!=''){
			$("#department").html(departmentHTML);
			var comcode=$("#comcode").val();
			if(comcode=='000000'){
				$("#department").find('dd').each(function(){
					$(this).css("display","");
				});
			}else{
				$("#department").find('dd[imp=0]').each(function(){
					$(this).css("display","none");
				});
			}
//			$("#departmentDiv").remove();
//			$('body').append('<div id="departmentDiv" style="display:none"></div>');
//			$("#departmentDiv").append(option1);
			var defaultObj=$("#department").find("dd[value='" + defCode + "']");
			$("#department").prev('input').val(defaultObj.attr('value'));
			$("#department").parent('div').find('span').text(defaultObj.text());
		}
//		$("#department").append(option1);
		
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
					$("#depposition").html(depPositionHtml);
					if($(this).attr('imp')=='0'){
						$("#depposition").find('dd[rem!=1]').each(function(){
							$(this).css("display","none");
						});
					}else{
						 if($("#comCode").prev('input').val()=='000000'){
							 if(depcode=='D6012011Y'){
								 $("#depposition").find('dd').each(function(){
										$(this).css("display","none");
								 });
								 $("#depposition").find('dd[rem=2]').each(function(){
										$(this).css("display","");
								 });
								 $("#depposition").find('dd[rem=4]').each(function(){
										$(this).css("display","");
								 });
							 }else if(depcode=='D6009011Y'){
								 $("#depposition").find('dd').each(function(){
										$(this).css("display","none");
								 });
								 $("#depposition").find('dd[rem=3]').each(function(){
										$(this).css("display","");
								 });
								 $("#depposition").find('dd[rem=4]').each(function(){
										$(this).css("display","");
								 });
								 $("#depposition").find('dd[rem=5]').each(function(){
										$(this).css("display","");
								 });
							 }else{
								 $("#depposition").find('dd').each(function(){
										$(this).css("display","none");
								 });
								 $("#depposition").find('dd[rem=3]').each(function(){
										$(this).css("display","");
								 });
								 $("#depposition").find('dd[rem=4]').each(function(){
										$(this).css("display","");
								 });
							 }
							 
						 }else{
							 if(depcode=='D6012011Y'){
								 $("#depposition").find('dd').each(function(){
										$(this).css("display","none");
								 });
								 $("#depposition").find('dd[rem=7]').each(function(){
										$(this).css("display","");
								 });
								 $("#depposition").find('dd[rem=8]').each(function(){
										$(this).css("display","");
								 });
							 }else{
								 $("#depposition").find('dd').each(function(){
										$(this).css("display","none");
								 });
								 $("#depposition").find('dd[rem=8]').each(function(){
										$(this).css("display","");
								 });
								 $("#depposition").find('dd[rem=9]').each(function(){
										$(this).css("display","");
								 });
							 }
						 }
					}
					thisul.find("dd").unbind("click");
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
var depPositionHtml;
function initDepPosition(defdepPos) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : contextRootPath + "/common/cond_getDepPos.do",
			success : function(data) {
				initDepPositionOption(data, defdepPos);
			}
		});
}

function initDepPositionOption(data, defValue) {
	// 初始化默认选择
	var defCode = typeof (defValue) != "undefined" ? defValue : "";
	var gson = data;
	var depPosition = "";
	var i = 0;
	var option1 = "<dd value=\"\">请选择</option>";
	$("#depposition").empty();
	var size = gson.length;
	for (; i < size; i++) {
		depPosition = gson[i];
		option1 += "<dd rem='"+depPosition.remark+"' value='" + depPosition.deppositioncode + "'>"
				+ depPosition.deppositionname + "</dd>";
	}
//	$("#depposition").append(option1);
	depPositionHtml=option1;
	if(defCode!=''){
		$("#depposition").html(depPositionHtml);
		var depart=$("#newdepcode").val();
		if(depart.indexOf('D7')!=-1){
			$("#depposition").find('dd[rem!=1]').each(function(){
				$(this).css("display","none");
			});
		}else{
			 if($("#comCode").prev('input').val()=='000000'){
				 if(depart=='D6012011Y'){
					 $("#depposition").find('dd').each(function(){
							$(this).css("display","none");
					 });
					 $("#depposition").find('dd[rem=2]').each(function(){
							$(this).css("display","");
					 });
					 $("#depposition").find('dd[rem=4]').each(function(){
							$(this).css("display","");
					 });
				 }else if(depart=='D6009011Y'){
					 $("#depposition").find('dd').each(function(){
							$(this).css("display","none");
					 });
					 $("#depposition").find('dd[rem=3]').each(function(){
							$(this).css("display","");
					 });
					 $("#depposition").find('dd[rem=4]').each(function(){
							$(this).css("display","");
					 });
					 $("#depposition").find('dd[rem=5]').each(function(){
							$(this).css("display","");
					 });
				 }else{
					 $("#depposition").find('dd').each(function(){
							$(this).css("display","none");
					 });
					 $("#depposition").find('dd[rem=3]').each(function(){
							$(this).css("display","");
					 });
					 $("#depposition").find('dd[rem=4]').each(function(){
							$(this).css("display","");
					 });
				 }
				 
			 }else{
				 if(depart=='D6012011Y'){
					 $("#depposition").find('dd').each(function(){
							$(this).css("display","none");
					 });
					 $("#depposition").find('dd[rem=7]').each(function(){
							$(this).css("display","");
					 });
					 $("#depposition").find('dd[rem=8]').each(function(){
							$(this).css("display","");
					 });
				 }else{
					 $("#depposition").find('dd').each(function(){
							$(this).css("display","none");
					 });
					 $("#depposition").find('dd[rem=8]').each(function(){
							$(this).css("display","");
					 });
					 $("#depposition").find('dd[rem=9]').each(function(){
							$(this).css("display","");
					 });
				 }
			 }
		}
		var defaultObj=$("#depposition").find("dd[value='" + defCode + "']");
		$("#depposition").prev('input').val(defaultObj.attr('value'));
		$("#depposition").parent('div').find('span').text(defaultObj.text());
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
