/*小于1000px时出横向滚动条开始*/
function size(){
	var w=document.documentElement.clientWidth;
	if(w<1280){
		$("html").css({"overflow-x":"scroll","width":"1280px"});
		$(".box").css({'width':'1280px'});
	}else{
			$("html").css({'overflow-x':'hidden','width':'100%'});
			$(".box").css({'width':'100%'});
	}
}
$(window).resize(function(){	
	size();
});
$(window).ready(function(){	
	size();
	});
function closePopWind(){
		$("#popWindow").remove();
		$('.black_overlay').remove();
}
/*模拟下拉列表框开始*/
function selectOption(){
	$(".select span").click(function(){
		var thisinput=$(this);
		var thisInputvar=$(this).next("input");
		var thisul=$(this).parent().find("dl");
		if(thisul.css("display")=="none"){
			if(thisul.height()>150){thisul.css({top:"-80px",height:"250"+"px","overflow-y":"scroll"});};
			thisul.fadeIn("100");
			thisul.parent().css("z-index","9999");
			thisul.hover(function(){},function(){thisul.fadeOut("100");thisul.parent().css("z-index","2");});
			thisinput.parent().hover(function(){},function(){thisul.fadeOut("200");thisul.parent().css("z-index","2");});
			thisul.find("dd").click(function(){
				thisinput.text($(this).text());
				thisInputvar.val($(this).attr('value'));
				thisul.fadeOut("100");
				});
			}
		else{
			thisul.fadeOut("fast");
			}
	});
}
//表头固定
function headerFixed(){
	var navH = $(".report_form").offset().top; 
	var height=$("#form_tit").height();
	var obj=$("#form_thead").next('table[class=form_table]');//表头多出的第一行
    $('<tr style="display:none" id="firstTr" height="'+height+'"></tr>').insertBefore(obj);
    var width=$(".report_form").width();
    $(window).unbind("scroll");
    $(window).scroll(function(){
        var scroH = $(this).scrollTop();
        var widthArray = new Array();
        $(".report_form>table thead tr td").each(function(){
    		 	widthArray.push($(this).width());
    	});
        if (scroH>=navH){
        	if(typeof($("#form_tit").html()) != 'undefined'){
        		$("#form_tit").css({"position":"fixed","top":"0px","width":width+"px"}).show();
        	}
        	if(typeof($("#form_thead").html()) != 'undefined'){
        		for(var i=0;i<widthArray.length;i++){
            		$("#form_thead").find("td").eq(i).width(widthArray[i]+"px");
            	}
            	$("#form_thead").css({"position":"fixed","top":"49px","width":width+"px"}).show();        	
            }
            $("#firstTr").show();
        }else{
        	$("#firstTr").hide();
        	$("#form_tit").css({"position":"static"});
        	$("#form_thead").css({"position":"fixed"}).hide();
        }
    });
}
	
$(document).ready(function(){
/* 文本框文字点击失去开始*/
jQuery.focusblur = function(focusid) {
   var focusblurid = $(focusid);
   var defval = focusblurid.val();
		   focusblurid.focus(function(){
   var thisval = $(this).val();
   if(thisval==defval){
				   $(this).val("");
				   $(this).css("color","#333");
			   }
		   });
		   focusblurid.blur(function(){
   var thisval = $(this).val();
   if(thisval==""){
				   $(this).val(defval);
				   $(this).css("color","#999");
			   }
		   });
     };
 //下面是调用方法
     $.focusblur(".search_inp input");
 });

/* 回到顶部开始*/
	$(function () {
	//当点击跳转链接后，回到页面顶部位置
	$("#back-to-top").click(function(){
	$('html,body').animate({scrollTop:0},500);
	return false;
	});
	});
	
	
$(window).ready(function(){	
//全选
	$('.all_checkbox').bind('click',function(){
		if($(this).hasClass('active')){
			$(this).parent().parent().find('font').removeClass('active').find('input').removeAttr('checked');
		}
		else
		{
			$(this).parent().parent().find('font').addClass('active').find('input').attr('checked',true);
		}
	});	
	//复选			
	$('.inpu_checkbox').bind('click',function(){
		var _this =$(this);
		var j=0;
		var i=0;
		if(_this.hasClass('active')){
			_this.removeClass('active').find('input').removeAttr('checked');
		}
		else
		{
			_this.addClass('active').find('input').attr('checked',true);
		};
		_this.parents(".layer1").find("input").each(function() {
					i++;
				});
		_this.parents(".layer1").find("input").each(function() {
			if($(this).parent().hasClass('active')){
				j++;
				}
		});
		if(i==j){
			$('.all_checkbox').addClass('active').find('input').attr('checked',true);
			}
		else{
			$('.all_checkbox').removeClass('active').find('input').removeAttr('checked');
			}
	});	
});	
/*模拟滚动条*/
/*$(function(){
		var Bool=false;
		var Scro=$("#scroll");
		var Scrp=$("#p");
		var Scrobd=$("#bd");
		var Scroul=$("#ul");
		var Scrp_Height =Scrp.outerHeight()/2;
		var Num2=Scro.outerHeight()-Scrp.outerHeight();
		var offsetX=0;
		var offsetY=0;
		Scrp.mousedown(function(e){  
		Bool=true;
	});
	$(document).mouseup(function(){
		Bool=false;
	});
	$(document).mousemove(function(e){
		if(Bool){
			var Num1= e.clientY - Scro.position().top;
			var y=Num1 - Scrp_Height;
			if(y<=1){
				Scrll(0);
				Scrp.css("top",1);
			}else if(y>=Num2){
				Scrp.css("top",Num2);
				Scrll(Num2);
			}else{
				Scrll(y);
			}
		}
	});
	function Scrll(y){
		var ulH = $("#ul").height();
		if(ulH>290){
			Scrp.css({"top":y,"display":"block"});
			Scroul.css("margin-top",-(y/(Scro.outerHeight()-Scrp.outerHeight()))*(Scroul.outerHeight()-Scrobd.height()));
			}
		else{
			Scrp.css({"top":0,"display":"none"});
			Scroul.css("margin-top",0);
			};
		
	}
	if(document.getElementById("scroll_bd").addEventListener) 
		document.getElementById("scroll_bd").addEventListener('DOMMouseScroll',wheel,true);
		document.getElementById("scroll_bd").onmousewheel=wheel;
		var Distance=Num2*0.1;
		function wheel(e){
			var evt = e || window.event;
			var wheelDelta = evt.wheelDelta || evt.detail;
			if(wheelDelta == -120 || wheelDelta == 3){
				var Distances=Scrp.position().top+Distance;
				if(Distances>=Num2){
					Scrp.css("top",Num2);
					Scrll(Num2);
				}else{
					Scrll(Distances);
				}
				return false;
			}else if (wheelDelta == 120 || wheelDelta == -3){
				var Distances=Scrp.position().top-Distance;
				if(Distances<=1){
					Scrll(0);
					Scrp.css("top",1);
				}else{
					Scrll(Distances);
				}
				return false;
			}   
		}
	
});*/



