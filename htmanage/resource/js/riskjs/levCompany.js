/**
 * 初始化公司基本信息
 * 
 * @param defValue
 *            默认公司code
 */
function initCompany(levelcode,mid) {
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getCompany.do?searchDto.levelCode="+levelcode,
		success : function(data) {
			initCompanyOption(data, mid);
		}
	});
}
function initCompanyOption(data, mid) {
	// 初始化默认选择
	var gson = data;
	var company = "";
	var i = 0;
	var option1 = "<option value=\"\">请选择</option>";
	$(mid).empty();
	var size = gson.length;
	for (; i < size; i++) {
		company = gson[i];
		option1 += "<option value='" + company.comcode + "'>" + company.comname
				+ "</option>";

	}
	$(mid).append(option1);
}

/*----------------------------- 
 Name: 公司下拉框 javascript
 Author: Zou_ZhuoQi
 Updater:  
 Time: 2013-12
 -----------------------------*/