/*----------------------------- 
Name:根据风险等级获得 -- 风险管理信息 javascript
Author: Niu_ChunPing
Updater:  
Time: 2013-10  monthType 月份类型
-----------------------------*/
//初始化风险管理信息
function addTime(yearNums, muYearid, muMonthid, monthType) {
	var myDate = new Date().getFullYear();
	for ( var i = 0; i < yearNums; i++) {
		$(muYearid).append('<option >' + myDate + '</option>');
		myDate = myDate - 1;
	}
	$(muYearid).change(function() {
		if ($(muYearid).val() != "") {
			$(muMonthid + ' option:eq(1)').attr('selected', true);
		} else {
			$(muMonthid + ' option:eq(0)').attr('selected', true);
		}
	});
	$(muMonthid).change(function() {
		if ($(muMonthid).val() != "") {
			if ($(muYearid).val() == "") {
				$(muYearid + ' option:eq(1)').attr('selected', true);
			}
		} else {
			$(muYearid + ' option:eq(0)').attr('selected', true);
		}
	});
	if (monthType == 'Q') {
		for (i = 3; i < 13; i = i + 3) {
			if (i < 10) {
				k = '0' + i;
				if (i == 3) {
					q = "第一季度";
				} else if (i == 6) {
					q = "第二季度";
				} else if (i == 9) {
					q = "第三季度";
				}
			} else {
				k = i;
				if (i == 12) {
					q = "第四季度";
				}
			}
			$(muMonthid).append("<option value='" + k + "'>" + q + "</option>");
		}
	} else {
		for (i = 1; i < 13; i++) {
			if (i < 10) {
				i = '0' + i;
			}
			$(muMonthid).append('<option >' + i + '</option>');
		}
	}

}