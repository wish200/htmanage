/*----------------------------- 
Name:根据风险等级获得 -- 风险管理信息 javascript
Author: Zou_ZhuoQi
Updater:  
Time: 2013-10
-----------------------------*/
//初始化风险管理信息

function initLev1Risk(levelCode,mid) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getRiskKind.do?searchDto.levelCode="+levelCode,
		success : function(data) {
			initLev1RiskCode(data,mid);
		}
	});
}
// 一级风险
function initLev1RiskCode(data,mid) {
	var kindGson = data;
	var kind = "";
	var i = 0;
	var option1 = "<option value=\"\">请选择</option>";
	$(mid).empty();
	var kindSize = kindGson.length;
	for (; i < kindSize; i++) {
		kind = kindGson[i];
		option1 += "<option value='" + kind.riskcode + "'>" + kind.riskname+ "</option>";
	}
	$(mid).append(option1);
}
