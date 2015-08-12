/*
 *  初始化年月
 *  默认年月,默认上一个月。例如:201407
 *  yearNums 几年数据
 *  muYearid 年份ID
 *  muMonthid 月份ID
 *  monthType 月份类型
 */
function addTime(yearNums, muYearid, muMonthid, monthType) {
	var sysdate=sysDate;//session 服务器 上一个月份
	var yearStr=sysdate.substring(0,4);//年份
	var monthStr=sysdate.substring(4,6);//月份
	
	var sysdateQ=sysDateQ;//session 服务器 上一个月份
	var yearStrQ=sysdateQ.substring(0,4);//年份
	var monthStrQ=sysdateQ.substring(4,6);//月份
	monthType=='Q'?initYearMonthQ(yearNums,muYearid,muMonthid,yearStrQ,monthStrQ):initYearMonth(yearNums,muYearid,muMonthid,yearStr,monthStr);
}

//默认类型 initYearMonth();
function initYearMonth(yearNums,muYearid,muMonthid,yearStr,monthStr){
	$(muYearid).empty();//年份清空
	$(muMonthid).empty();//月份清空
	//year:
    var resultYearStr="";
	for ( var i = parseInt(yearStr); i >= 2012; i--) {
		resultYearStr+='<dd value="'+i+'" >' + i + '</dd>';
	}$(muYearid).append(resultYearStr);
	
	var resultMonthStr="";
	for ( var i = 1; i <= 12; i++) {
		if(i<10){
			resultMonthStr+='<dd value="0'+i+'" >' + "0"+i + '</dd>';
		}else{
			resultMonthStr+='<dd value="'+i+'" >' + i + '</dd>';
		}
		
	}$(muMonthid).append(resultMonthStr);
	/*显示年份和月份*/
	$(muYearid).prev().prev('span').html(yearStr);
	$(muMonthid).prev().prev('span').html(monthStr);
	$(muYearid).prev('input').val(yearStr);
	$(muMonthid).prev('input').val(monthStr);
}

//季度类型 initYearMonthQ();
function initYearMonthQ(yearNums,muYearid,muMonthid,yearStrQ,monthStrQ){
	$(muYearid).empty();//年份清空
	$(muMonthid).empty();//月份清空
	//year:
    var resultYearStr="";
	for ( var i = parseInt(yearStrQ); i >= 2012; i--) {
		resultYearStr+='<dd value="'+i+'" >' + i + '</dd>';
	}$(muYearid).append(resultYearStr);
	var resultMonthStr="";
		resultMonthStr+='<dd value="03" >' + "第一季度" + '</dd>';
		resultMonthStr+='<dd value="06" >' + "第二季度" + '</dd>';
		resultMonthStr+='<dd value="09" >' + "第三季度" + '</dd>';
		resultMonthStr+='<dd value="12" >' + "第四季度" + '</dd>';
	$(muMonthid).append(resultMonthStr);
	var resultMonth="";
	switch (monthStrQ){
		case "03":
			resultMonth="第一季度";
			break;
		case "06":
			resultMonth="第二季度";
			break;
		case "09":
			resultMonth="第三季度";
			break;
		case "12":
			resultMonth="第四季度";
			break;
	}
		$(muYearid).prev().prev('span').html(yearStrQ);
		$(muMonthid).prev().prev('span').html(resultMonth);
		$(muYearid).prev('input').val(yearStrQ);
		$(muMonthid).prev('input').val(monthStrQ);
}
