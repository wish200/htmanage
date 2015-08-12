/*----------------------------- 
Name: 风险管理信息 javascript
Author: Zou_ZhuoQi
Updater:  
Time: 2013-10
-----------------------------*/
//初始化风险管理信息

function initRisk(defLev1RiskCode, defLev2RiskCode, defLev3RiskCode) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getRiskKind.do",
		success : function(data) {
			initLev1RiskCode(data, defLev1RiskCode, defLev2RiskCode,
					defLev3RiskCode);
		}
	});
}
// 一级风险
function initLev1RiskCode(data, defLev1RiskCode, defLev2RiskCode,
		defLev3RiskCode) {
	// 初始化默认选择
	var lev1 = typeof (defLev1RiskCode) != "undefined" ? defLev1RiskCode : "";
	var lev2 = typeof (defLev2RiskCode) != "undefined" ? defLev2RiskCode : "";
	var lev3 = typeof (defLev3RiskCode) != "undefined" ? defLev3RiskCode : "";
	var kindGson = data;
	var kind = "";
	var i = 0;
	var option1 = "<dd value=\"\">请选择</dd>";
	$("#lev1RiskCode").empty();
	var kindSize = kindGson.length;
	for (; i < kindSize; i++) {
		kind = kindGson[i];
		if (kind.levelcode == 1) {
			option1 += "<dd value='" + kind.riskcode + "'>" + kind.riskname
					+ "</dd>";
		}
	}
	$("#lev1RiskCode").append(option1);
	// 设置风险name默认值
	var lev1Selected = $("#lev1RiskCode").find("dd[value='" + lev1 + "']");
	var lev1SelectedVal = lev1Selected.attr('value');
	var lev1SelectedText = lev1Selected.text();
	$('#lev1RiskCode').siblings('span').text(lev1SelectedText);
	$('#lev1RiskCode').prev('input').val(lev1SelectedVal);
//	var lev1RiskName = lev1SelectedVal == "" ? "" : lev1SelectedText;
//	$("#lev1RiskName").val(lev1SelectedText);
	if (lev1SelectedVal != '') {
		initLev2RiskCode(kindGson, lev2, lev3);
	}
	$("#lev1RiskCode").prev().prev().click(function(){
		var thisinput=$(this);
		var thisInputvar=$(this).next("input");
		var thisInputvarName=$(this).prev("input");
		var thisul=$(this).parent().find("dl");
		if(thisul.css("display")=="none"){
			if(thisul.height()>150){thisul.css({top:"-80px",height:"250"+"px","overflow-y":"scroll"});};
			thisul.fadeIn("100");
			thisul.parent().css("z-index","9999");
			thisul.hover(function(){},function(){thisul.fadeOut("100");thisul.parent().css("z-index","2");});
			thisinput.parent().hover(function(){},function(){thisul.fadeOut("100");thisul.parent().css("z-index","2");});
			thisul.find("dd").click(function(){
				thisinput.text($(this).text());
				thisInputvar.val($(this).attr('value'));
				thisInputvarName.val($(this).text());
				thisul.fadeOut("100");
				thisul.find("dd").unbind("click");
				initLev2RiskCode(kindGson);
				});
			}
		else{
			thisul.fadeOut("fast");
			}
	});
}
// 二级风险
function initLev2RiskCode(kindGson, defLev2RiskCode, defLev3RiskCode) {

	var option2 = "<dd value=\"\">请选择</dd>";
	$("#lev2RiskCode").empty();

	var selectLev1RiskCode = $("#lev1RiskCode").prev('input').val();
	for ( var i = 0, kindSize = kindGson.length; i < kindSize; i++) {
		kind = kindGson[i];
		
		if (kind.levelcode == 2 && kind.fathercode == selectLev1RiskCode) {
			option2 += "<dd value='" + kind.riskcode + "'>" + kind.riskname
					+ "</dd>";
		}
	}
	$("#lev2RiskCode").append(option2);
	// 设置被默认值
	var lev2Selected = $("#lev2RiskCode").find("dd[value='" + defLev2RiskCode + "']");
	var lev2SelectedVal = lev2Selected.attr('value');
	var lev2SelectedText = lev2Selected.text();
	if(lev2SelectedText!=''){
		$('#lev2RiskCode').siblings('span').text(lev2SelectedText);
		$('#lev2RiskCode').prev('input').val(lev2SelectedVal);
//		$("#lev2RiskName").val(lev2SelectedText);
	}
	
//	var lev2RiskName = lev2SelectedVal == "" ? "" : lev2SelectedText;
	$("#lev2RiskCode").prev().prev().click(function(){
		var thisinput=$(this);
		var thisInputvar=$(this).next("input");
		var thisInputvarName=$(this).prev("input");
		var thisul=$(this).parent().find("dl");
		if(thisul.css("display")=="none"){
			if(thisul.height()>150){thisul.css({top:"-80px",height:"250"+"px","overflow-y":"scroll"});};
			thisul.fadeIn("100");
			thisul.parent().css("z-index","9999");
			thisul.hover(function(){},function(){thisul.fadeOut("100");thisul.parent().css("z-index","2");});
			thisinput.parent().hover(function(){},function(){thisul.fadeOut("100");thisul.parent().css("z-index","2");});
			thisul.find("dd").click(function(){
				thisinput.text($(this).text());
				thisInputvar.val($(this).attr('value'));
				thisInputvarName.val($(this).text());
				thisul.fadeOut("100");
				thisul.find("dd").unbind("click");
				});
			}
		else{
			thisul.fadeOut("fast");
			}
	});

	if (lev2SelectedVal != "") {
		initLev3RiskCode(kindGson, defLev3RiskCode);
	}
	
//	$("#lev2RiskCode").bind("change", function() {
//		lev2SelectedVal = $("#lev2RiskCode :selected").val();
//		lev2SelectedText = $("#lev2RiskCode :selected").text();
//		lev2RiskName = lev2SelectedVal == "" ? "" : lev2SelectedText;
//		$("#lev2RiskName").val(lev2RiskName);
//		
//	});

}
// 三级风险
function initLev3RiskCode(kindGson, defLev3RiskCode) {

	var option3 = "<dd value=\"\">请选择</dd>";
	$("#lev3RiskCode").empty();

	var selectLev2RiskCode = $("#lev2RiskCode :selected").val();
	for ( var i = 0, kindSize = kindGson.length; i < kindSize; i++) {
		kind = kindGson[i];
		if (kind.levelcode == 3 && kind.fathercode == selectLev2RiskCode) {
			option3 += "<dd value='" + kind.riskcode + "'>" + kind.riskname
					+ "</dd>";
		}
	}
	$("#lev3RiskCode").append(option3);
	$("#").find("dd[value='" + +"']").attr("selected", true);

	// 设置被默认值
	var lev3Selected = $("#lev3RiskCode").find(
			"dd[value='" + defLev3RiskCode + "']");
	var lev3SelectedVal = lev3Selected.val();
	var lev3SelectedText = lev3Selected.text();
	lev3Selected.attr("selected", true);
	var lev3RiskName = lev3SelectedVal == "" ? "" : lev3SelectedText;
	$("#lev3RiskName").val(lev3RiskName);

	$("#lev3RiskCode").bind("change", function() {
		lev3SelectedVal = $("#lev3RiskCode :selected").val();
		lev3SelectedText = $("#lev3RiskCode :selected").text();
		lev3RiskName = lev3SelectedVal == "" ? "" : lev3SelectedText;
		$("#lev3RiskName").val(lev3RiskName);

	});

}