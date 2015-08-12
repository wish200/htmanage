/*----------------------------- 
Name: 邮件类型
Author: 张洋洋
Updater:  
Time: 2013-10
[{"templatecatno":"T0001","templatecatname":"测试","validstate":"1","levelcode":1,"remark":"111"},
{"templatecatno":"T0002","templatecatname":"测试","validstate":"1","levelcode":1,"remark":"2123"}]

-----------------------------*/




function initTemplateCatno(defModule) {
	var ajaxData;
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getTemplateCatno.do",
		success : function(data) {
			ajaxData=data;
			templateModule(data, defModule);
		}
	});
	 $("#templateModuleId").prev().prev().click(function(){
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
		                if($(this).parent('dl').attr('id')=='templateModuleId'){//改变所属功能模块后
		                	$("#templatecatno").val("");
		                	$("#templatecatno").prev("span").html("请选择");
		                	templateEmail(ajaxData);
		                }else if($(this).parent('dl').attr('id')=='templateEmailId'){//改变邮件类型的时候
		                	 var templateEmailId=$(this).attr('value');
		                	 var oldTemplatecatNo=$("#oldTemplatecatNo").val();
		                	 if(templateEmailId!=''&&templateEmailId!=oldTemplatecatNo){
			       	          $.ajax({
			                           url :contextRootPath +'/sysconfig/emailTemplate_exitsTepName.do',
			                           type : 'POST',
			                           data :{
			                              'searchDto.templatecatno':templateEmailId,
			                              'searchDto.comCode':comCode
			                           },
			                           dataType : 'json',
			                           error : function() {
			                               alert('系统错误。请与管理员联系');
			                           },
			                           success :function(data){
			                               if(data>0){
			                                   alert("此邮件类型已经存在，请从新选择");
			                                   $("#templatecatno").val("");
			                                   $("#templatecatno").prev("span").html("请选择");
			       		                	   templateEmail(ajaxData, defEmail);
			       		                	   $('#Caddressee').val('');
			  				       		    	$('#BCCid').val('');
			  				       		   	 $('#Depid').val('');
			                               }
			                           }
			                       }); 
		                	 }
		                }else if($(this).parent('dl').attr('id')=='yinMoBan'){//改变引用模板后
		                	if($(this).attr('value')!=''){
		                		$("#editor_id").val($(this).prev().val());
		                	}
		                }
		                thisul.find("dd").unbind('click');
		            });
		        }
		    else{
		        thisul.fadeOut("fast");
		        }
		});
}

// 所属功能模块
function templateModule(data, defModule) {
	// 初始化默认选择
	var defModuleValue = typeof (defModule) != "undefined" ? defModule : "";
	var gson = data;
	var i = 0;
	var template = "";
	var templateSize = gson.length;
	var option1 = "<dd value=\"\">请选择</dd>";
	$("#templateModuleId").empty();
	for (; i < templateSize; i++) {
		template = gson[i];
		if (template.levelcode == 1) {
			option1 += "<dd value='" + template.templatecatno + "'>"
					+ template.templatecatname + "</dd>";
		}
	}
	$("#templateModuleId").append(option1);
}

// 所属功能模块
function templateEmail(data) {
	var option2 = "<dd value=\"\">请选择</dd>";
	$("#templateEmailId").empty();
	var module = $("#moduleid").val();
	var gson = data;
	var i = 0;
	var template = "";
	var templateSize = gson.length;
	for (; i < templateSize; i++) {
		console.log(template);
		template = gson[i];
		if (template.levelcode == 2 && template.fathercode == module) {
			option2 += "<dd value='" + template.templatecatno + "'>"
					+ template.templatecatname + "</dd>";
		}
	}
	$("#templateEmailId").append(option2);
}