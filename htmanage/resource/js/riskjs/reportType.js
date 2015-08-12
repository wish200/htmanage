function initReportTpye(reporttype){
	var year=$('#year').val();
	var month=$('#month').val();
	$.ajax({
		type : "post",
		dataType : "json",
		url : contextRootPath + "/common/cond_getReportType.do?searchDto.statDate="+year+month+'&searchDto.reporttype='+reporttype,
		success : function(data) {
			initReportTpye1(reporttype,data);
			
		}
	});
};
function initReportTpye1(reporttype,data){
	var kindGson = data;
	var kind = "";
	var i = 0;
	var option1 = "<option value=\"\">请选择</option>";
	if(reporttype==2){
		option1 += "<option value='ALL'>全部</option>";
	}
	$("#bksstype").empty();
	var kindSize = kindGson.length;
	for (; i < kindSize; i++) {
		kind = kindGson[i];
		option1 += "<option value='" + kind.reportcode + "'>" + kind.reportname+ "</option>";
	}
	$("#bksstype").append(option1);
}