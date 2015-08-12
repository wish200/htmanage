//验证flash是否安装。
function verfificationFlash(obj){
	var fls=flashChecker();
	var s="";
	if(fls.f){
//		document.write("您安装了flash,当前flash版本为: "+fls.v+".x");
	} 
	else{
//		document.write("您没有安装flash"); 
        obj.html("<div style=''><span style=''>你没有安装flash插件或者flash版本过低,请点击此处,<a href='http://get.adobe.com/cn/flashplayer' target='_blank'>下载最新版本</a><span></div>");
	} 
//	var isIE = !-[1,];
//	if(isIE){
//	     try{
//	         var swf1 = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');
//	     }
//	     catch(e){
//	         obj.html("<div style=''><span style=''>你没有安装flash插件或者flash版本过低,请点击此处,<a href='http://get.adobe.com/cn/flashplayer' target='_blank'>下载最新版本</a><span></div>");
//	     }
//	}
//	else {
//	     try{
//	         var swf2 = navigator.plugins['Shockwave Flash'];
//	         if(swf2 == undefined){
//	        	 obj.html("<span style=''>你没有安装flash插件或者flash版本过低,请点击此处,<a href='http://get.adobe.com/cn/flashplayer' target='_blank'>下载最新版本</a><span>");
//	         }
//	         else {
//	         }
//	     }
//	     catch(e){
//	         obj.html("<span style=''>你没有安装flash插件或者flash版本过低,请点击此处,<a href='http://get.adobe.com/cn/flashplayer' target='_blank'>下载最新版本</a><span>");
//	     }
//	}
}
function flashChecker()
{
var hasFlash=0;         //是否安装了flash
var flashVersion=0; //flash版本
var isIE=/*@cc_on!@*/0;      //是否IE浏览器

if(isIE)
{
var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash'); 
if(swf) {
hasFlash=1;
VSwf=swf.GetVariable("$version");
flashVersion=parseInt(VSwf.split(" ")[1].split(",")[0]); 
}
}else{
if (navigator.plugins && navigator.plugins.length > 0)
{
var swf=navigator.plugins["Shockwave Flash"];
    if (swf)
     {
hasFlash=1;
        var words = swf.description.split(" ");
        for (var i = 0; i < words.length; ++i)
{
            if (isNaN(parseInt(words[i]))) continue;
            flashVersion = parseInt(words[i]);
}
    }
}
}
return {f:hasFlash,v:flashVersion};
}