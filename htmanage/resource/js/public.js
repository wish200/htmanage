/*----------------------------- 
Name: public javascript
Design:West
Time: 2013-10
-----------------------------*/

/** 字符长度限制 */
function characterLimit(id,length,alertMess){
		  var value=$("#"+id).val().replace(/[^\x00-\xff]/g, 'xx');
		  if(value.length>length){
			   alert(alertMess);
			   $("#" + id).focus();// 获取输入框焦点
			   return false;
		  }else{
			   return true;
		  }
}
/** ID是否有数据校验 */
function haveData(obj_id, title, defalutValue) {
	var val = defalutValue ? defalutValue : '';
	var obj_val = $.trim($("#" + obj_id).val());
	if (obj_val == val||obj_val == '') {
		alert(title);
		$("#" + obj_id).focus();// 获取输入框焦点
		return false;
	}
	return true;
}
/** 禁用 BackSpace 在只读情况下返回上一个页面* */
/*$(document).keydown(
		function(e) {
			var doPrevent;
			if (e.keyCode == 8) {
				var d = e.srcElement || e.target;
				if (d.tagName.toUpperCase() == 'INPUT'
						|| d.tagName.toUpperCase() == 'TEXTAREA') {
					doPrevent = d.readOnly || d.disabled;
				} else
					doPrevent = true;
			} else
				doPrevent = false;

			if (doPrevent)
				e.preventDefault();
		});*/

// 表格样式
$(function() {
	/*$('.lines p:last-child').css('border', 0);
	$(".riskDisc").css('padding', 0);
	$(".riskDisc li:odd").addClass('bg_fa');
	$(".riskDisc li:last").css('border-bottom', '0');*/
	tab_bg();
//	fujian();
});
// 顶部导航
$(function() {
//	$(".timeout").click(function(){
//		  $("body").append("<div  class='black_overlay'>" +
//		  "<div style='position:fixed;top:55%; left:40%;background-color: fffff'> " +
//		  "系统正在加载，请稍后..d ...<img src='../risk/images/timeout.gif' height='40' width='40' alt='正在加载。。' /></div></div>");
//		  $(".black_overlay").height($(document).height());
//          $(".black_overlay").show(); 
//	});	
//	$(".timeout").unload(function(){
//		$(".black_overlay").hide();
//	});
	$('.mainNav li,.mainNav dt').hover(function() {
		$(this).find('dl').eq(0).toggle();
	});
});

// 查询
$(function() {
	$('.search a.a_sea').click(function(){
		$(this).find('i').toggleClass('active');
		$('.searchCont').slideToggle();	
		//$('.searchCont table').find('input.text').val('');
		//$('.searchCont table').find('select option:first-child').attr('selected','selected');
	});
	
	/***清空查询条件*/
	$(".btnReset").click(function() {
		$(".tabSearch").find("select option:first-child").attr("selected","selected");
		$(".tabSearch").find("input[type='text']").val("");
	});
	
	$('.btnSearch').click(function() {
		var _this = $(this);
		 var statDate=$('#year').val()+ $('#month').val();
		  $('#statDate').val(statDate);
		  if(statDate==''||statDate==null){
			  alert("请选择数据期次！");
			  return false;
		  }
		_this.val('查询中...').addClass('btnDis').attr('disabled', 'disabled');
		setTimeout(function() {
			$('.searchCont').slideUp(function() {
				$('.search a.a_sea').find('i').removeClass('active');
				_this.val('查询').removeClass('btnDis').removeAttr('disabled');
			});
		}, 2000);
		_this.parents("form").submit();
	});
});

// 表格操作
$(function() {
	$('.operate').each(function(i) {
		$(this).css('z-index', 900 - i).attr('ind', i + 1);
	});
	$('.operate').hover(function() {
		var s = $('.operate').size();
		if ($(this).attr('ind') == s || $(this).attr('ind') == (s - 1)) {
			$('#page').css('z-index', 1);
		}
		$(this).find('span').addClass('hover');
		var ws =$(this).width();
		var ow = $(this).find('ul').outerWidth();
		var c = ws/2 - ow +8;
		$(this).find('ul').show();
	}, function() {
		$(this).find('span').removeClass('hover');
		$(this).find('ul').hide();
		$('#page').css('z-index', 9999);
	});
	
});

//表格表头固定
function  tdFixed(){
    var tdwidth=$('.tdTitle').find('td');
    for(var i=0;i<tdwidth.size();i++){
       tdwidth.eq(i).attr("width",tdwidth.eq(i).width()); 
    } 
	var table='<div style="padding:10px;"><table id="fixed" style="position:fixed;z-index:999;top:0;display:none" class="tabBasic tab_bg" width="98.3%"  cellpadding="0" cellspacing="0">';
	var tr;
	if($('.bigTitle')[0]!=null){
		if($('.tdTitle').eq(1)[0]!=null){
			tr=$('.bigTitle')[0].outerHTML+$('.tdTitle').eq(0)[0].outerHTML+$('.tdTitle').eq(1)[0].outerHTML;
		}else{
			tr=$('.bigTitle')[0].outerHTML+$('.tdTitle')[0].outerHTML;
		}
	}
	else{
		if($('.title')[0]!=null){
	    	tr=$('.title')[0].outerHTML+$('.tdTitle')[0].outerHTML;
	    }else{
	    	tr=$('.tdTitle').eq(0)[0].outerHTML;
	    };
	}
    var entable='</table></div>';
    $('body').append(table+tr+entable);
 };
window.onscroll=function(){
	var dd="";
	var tt=55;
	if(document.documentElement&&document.documentElement.scrollTop){
	      dd=document.documentElement.scrollTop;
    }else if(document.body){
      dd=document.body.scrollTop;
    }
    if(dd>tt){
       $('#fixed').show();
    }else{
       $('#fixed').hide();
    }
};
// 附件弹出表格操作
function  fujian() {
	$('.u322_normal').each(function(i) {
		$(this).css('z-index', 900 - i).attr('ind', i + 1);
	});
	$('.u322_normal').hover(function() {
		var s = $('.u322_normal').size();
		if ($(this).attr('ind') == s || $(this).attr('ind') == (s - 1)) {
			$('#footer').css('z-index', 1);
		}
		 
		$(this).find('span').addClass('hover');
		var ws =$(this).width();
		var ow = $(this).find('ul').outerWidth();
		var c = ws/2 - ow +8;
		$(this).find('ul').show();
	}, function() {
		$(this).find('span').removeClass('hover');
		$(this).find('ul').hide();
		$('#footer').css('z-index', 9999);
	});
};

// 返回顶部、滚动定位
$(function() {
	$('#footer a').click(
			function() {
				'undefined' == typeof (document.body.style.maxHeight) ? $(
						window).scrollTop(0) : $('body,html').stop().animate({
					scrollTop : 0
				}, 150);
			});
			$(window).scroll(function() {
				$(window).scrollTop() > 85 ? $('.subNav,.leftHide').addClass(
						'fixed') : $('.subNav,.leftHide').removeClass('fixed');
			});
});

// 屏幕分辨率为于1024X768
$(function() {
	if ($(window).width() < 1200) {
		$('.search .tabSearch select').width(130);
		$('.search .tabSearch .text').width(118);
	}
});

/*// icon操作
$(function() {
	// 导出
	$('.export').click(function() {
		$(this).find('ul').fadeToggle();
		return false;
	});
	// 删除
	$('.a_del').click(function() {
		$(this).parents('.operate').parent().parent('tr').fadeOut(function() {
			$(this).remove();
			tab_bg();
		});
	});
	$(document).bind('click', function() {
		$('.export ul').fadeOut();
	});
	// 提示
	$('.icofaq').hover(function() {
		$(this).find('font').toggle();
	});
});*/

// 动态调整五级风险库宽度
/*$(function() {
	var h2_width = $('.basic h2').width();
	var lev_width = Math.floor(h2_width / 5);
	$('.lev').css('width', lev_width);
	$('.lev_5').css('width', h2_width - 4 * lev_width + 6);
});*/

// 选择
/*$(function() {
	$('.scope input').click(function() {
		var sc = $(this).offset();
		$(this).toggleClass('unable');
		$('.showScope').css({
			'left' : sc.left - 269,
			'top' : sc.top + 20
		}).fadeToggle();
	});
	$('.rdBtn .btn_xz').click(function() {
		var sc = $(this).offset();
		var w = $('.chooseDialog').width();
		var h = $('.chooseDialog').height();
		$(this).toggleClass('active');
		$('.chooseDialog').css({
			'left' : sc.left - w + 59,
			'top' : sc.top - h - 3,
			'position' : 'absolute'
		}).fadeToggle();
	});

	$('.showScope .scBot input').hover(function() {
		$(this).toggleClass('this_hover');
	}).click(function() {
		$('.showScope').fadeOut();
	});

});*/

// 折叠
/*$(function() {
	$('.fold').click(function() {
		var basicInforPre = $(this).parent();
		if (basicInforPre.hasClass('folded')) {
			basicInforPre.removeClass('folded');
			basicInforPre.next('.basicInfor').slideDown(200);
		} else {
			basicInforPre.next('.basicInfor').slideUp(200, function() {
				basicInforPre.addClass('folded');
			});
		}
	});
});*/

// 菜单
/*$(function() {
	$('.screenin li').each(function() {
		var _this = $(this);
		if (_this.find('ul').length)
			_this.addClass('li_list');
		_this.click(function() {
			if ($(this).find('ul').length != 0) {
				_this.toggleClass('active').children('ul').slideToggle();
			}
			return false;
		});
	});
});*/

// 对话框（用于弹出相对位置的层）
function DialogTive(obj, dom, bool) { // 第三个参数，控制层位于相对obj的左右侧显示
	var s = $(obj).offset();
	var w = $(dom).width();
	bool ? $(dom).css({
		'left' : s.left - w,
		'top' : s.top + 24
	}).slideToggle() : $(dom).css({
		'left' : s.left,
		'top' : s.top + 24
	}).slideToggle();
	$(window).resize(function() {
		$(dom).css({
			'left' : s.left,
			'top' : s.top + h
		});
	});
	return false;
};

// 关闭对话框（用于关闭相对位置的层）
function DialogTiveClose(dom) {
	$(dom).slideUp();
	return false;
};

// 对话框（用于弹出屏幕正中间的层）
function Dialog(dom, obj) {
	var _domW = $(dom).width() / 2;
	var _domH = $(dom).height() / 2;
	$('body').append('<div class=mask></div>');
	$('.mask').height($(document).height()).show();
	$(dom).css({
		'margin-left' : -_domW,
		'margin-top' : -_domH
	}).fadeIn();
	if ('undefined' == typeof (document.body.style.maxHeight)) {
		$("body")
				.append('<iframe frameborder="0" class="ie6_iframe"></iframe>');
		$('.ie6_iframe').height($(document).height());
	}
	$(window).resize(function() {
		var _domW = $(dom).width() / 2;
		var _domH = $(dom).height() / 2;
		$(dom).css({
			'margin-left' : -_domW,
			'margin-top' : -_domH
		});
	});
	if (obj) {
		DialogMove(dom, obj);
	}
	; // 弹层是否可拖拽
};

// 关闭对话框（用于关闭屏幕正中间的层）
function DialogClose(dom) {
	$(dom).fadeOut();
	$('.mask').fadeOut(function() {
		$('.mask').remove();
		$(".ie6_iframe").remove();
	});
	return false;
};

// 可拖拽的层
function DialogMove(dom, obj) {
	$(obj).css({
		'cursor' : 'move'
	});
	$(obj).mousedown(function(event) {
		var isMove = true;
		var abs_x = event.pageX - parseInt($(dom).css('margin-left'));
		var abs_y = event.pageY - parseInt($(dom).css('margin-top'));
		$(document).mousemove(function(event) {
			if (isMove) {
				$(obj).parents(dom).css({
					'margin-left' : event.pageX - abs_x,
					'margin-top' : event.pageY - abs_y
				});
			}
		}).mouseup(function() {
			isMove = false;
		});
	});
};
//公共的ajax
function asy_Ajax(url,data,dataType,successfm){
    $.ajax({
            url :url,
            type : 'POST',
            data :data,
            dataType : dataType,
            error : function() {
                alert('系统错误。请与管理员联系');
            },
            success :successfm
        }); 
}
//弹出层窗口
function showPopBox(){
        $("body").prepend("<div class='black_overlay'></div>");
		$(".black_overlay").css({opacity:"0.4"}).css("height",$(document).height()).show();
		$(".popBox .close").click(closePopBox);
}
//弹出层窗口关闭
function closePopBox(){
		 $(".popBox").fadeOut();
		 $(".black_overlay").fadeOut();
		 setTimeout(function(){
		 $(".popBox").remove();
		 $(".black_overlay").remove();
		 },500);
}
// 表格颜色
function tab_bg() {
		$('.tab_bg').find('tr').hover(function() {
			$(this).addClass('bg_f0');
		}, function() {
			$(this).removeClass('bg_f0');
		});
}