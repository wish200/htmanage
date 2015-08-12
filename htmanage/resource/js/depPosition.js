/**
 * 初始化部门岗位基本信息
 * 
 * @param defDep
 *            默认部门Code
 * @param defdepPos
 *            默认部门岗位代码
 */
var depPositionHtml;
function initDepPosition(defDep, defdepPos) {
		$.ajax({
			type : "post",
			dataType : "json",
			data : {"searchDto.newDepCode" : defDep} ,
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
	var option1 = "<option value=\"\">请选择</option>";
	$("#depPosition").empty();
	var size = gson.length;
	for (; i < size; i++) {
		depPosition = gson[i];
		option1 += "<option imp='"+depPosition.importlev+"' value='" + depPosition.deppositioncode + "'>"
				+ depPosition.deppositionname + "</option>";
	}
	$("#depPosition").append(option1);
	var selected = $("#depPosition").find("option[value='" + defCode + "']");
	selected.attr("selected", true);
	depPositionHtml=option1;
}

/*----------------------------- 
 Name: 部门岗位 javascript
 Author: Zou_ZhuoQi
 Updater:  
 Time: 2013-12
 -----------------------------*/
