/**
 * 封装了气泡图
 */
function Bubble(container , width , height){
	/**
	 * FIXME 这里还需要根据长和宽来初始化传入的对象
	 * 不过第一个版本不需要
	 */
	this.width=!width?400:width ;
	this.height=!height?300:height ;
	this.paper = Raphael(container, width,height);
	
	//report range 
	this.padding = 30 ;
	this.report = new Object() ;
	this.report.leftTop = {x:this.padding,y:this.padding} ;
	this.report.rightTop = {x:this.width-this.padding,y:this.padding} ;
	this.report.leftButtom = {x:this.padding,y:this.height-this.padding} ;
	this.report.rightButtom = {x:this.width-this.padding , y :this.height-this.padding} ;
	this.report.width = this.report.rightTop.x - this.report.leftTop.x ;
	this.report.height = this.report.leftButtom.y-this.report.leftTop.y ;
};

Bubble.prototype.render=function(data){
	var r = this.report ;
	var rangePathModel = "M@sx,@syS@ex,@sy,@ex,@eyH@sxV@syZ" ;
	//最外层
	var range1 = rangePathModel.replace("@sx",r.leftTop.x);
	range1 = range1.replace("@sy",r.leftTop.y) ;
	range1 = range1.replace("@sx",r.leftTop.y) ;
	range1 = range1.replace("@sy",r.leftTop.y) ;
	range1 = range1.replace("@sy",r.leftTop.y) ;

	range1 = range1.replace("@ex",r.rightButtom.x) ;
	range1 = range1.replace("@ex",r.rightButtom.x) ;
	range1 = range1.replace("@ey",r.rightButtom.y) ;
	this.paper.path(range1).attr("fill","#33ff00") ;
//	中层
	var range2 = rangePathModel.replace("@sx",r.leftTop.x);
	range2 = range2.replace("@sy",r.leftTop.y+this.report.height/3) ;
	
	range2 = range2.replace("@ex",r.leftTop.x+r.width*2/3) ;
	range2 = range2.replace("@sy",r.leftTop.y+r.height/3) ;
	range2 = range2.replace("@ex",r.leftButtom.x+r.width*2/3) ;
	range2 = range2.replace("@ey",r.rightButtom.y) ;
	range2 = range2.replace("@sx",r.leftTop.y) ;
	range2 = range2.replace("@sy",r.leftTop.y) ;

	this.paper.path(range2).attr("fill","#ffFF00") ;
	//下层
	var range3 = rangePathModel.replace("@sx",r.leftTop.x);
	range3 = range3.replace("@sy",r.leftTop.y+this.report.height*2/3) ;
	
	range3 = range3.replace("@ex",r.leftTop.x+r.width/3) ;
	range3 = range3.replace("@sy",r.leftTop.y+r.height*2/3) ;
	range3 = range3.replace("@ex",r.leftButtom.x+r.width/3) ;
	range3 = range3.replace("@ey",r.rightButtom.y) ;
	range3 = range3.replace("@sx",r.leftTop.y) ;
	range3 = range3.replace("@sy",r.leftTop.y) ;

	this.paper.path(range3).attr("fill","#ff0000") ;
	var dd=r.leftTop.y-30;
	this.paper.path("M"+r.leftTop.x+" "+dd+",L"+r.leftButtom.x+" "+r.leftButtom.y);
	var dds=r.leftButtom.y-20;
	var t=this.paper.path("M"+r.leftButtom.x+" "+r.leftButtom.y+"L"+r.leftButtom.x+30+" "+r.leftButtom.y+"");
	var dddd=r.leftTop.x-20;
	this.paper.text(dddd,r.leftTop.y+r.width/6,"绿");
	this.paper.text(dddd,r.leftTop.y+r.width/2,"黄");
	this.paper.text(dddd,r.leftTop.y+r.width/6*5,"红");
	
	this.paper.text(r.leftButtom.x+r.leftTop.x+r.width*1/8,r.leftButtom.y+20,"红");
	this.paper.text(r.leftButtom.x+r.leftTop.x+r.width*2/5,r.leftButtom.y+20,"黄");
	this.paper.text(r.leftButtom.x+r.leftTop.x+r.width*3/4,r.leftButtom.y+20,"绿");
	//生成气泡
	for(var i=0;i<data.length;i++){
		var k=0;
		if(data[i].color=='R'){//红
			k=1;
		}else if(data[i].color=='G'){
			k=3;
		}else  if(data[i].color=='Y'){
			k=2;
		}else{
			continue;
		}
		var pt = this.generatePoint(k) ;
		var c1 = this.paper.circle(pt.x,pt.y,4).attr("fill","#000000");
		var kk='';
		if(data[i].indexvalue!=null&&data[i].indexvalue!='--'){
			kk=data[i].indexvalue;
		}
		c1.name=data[i].cdIndexBaseDto.indexname+kk;
		c1.mouseover(function(){
			var x = this.attr("cx") ;
			var y = this.attr("cy") ;
			this.text = this.paper.text(x+20,y+20,this.name) ;
		}) ;
		c1.mouseout(function(){
			this.text.hide() ;
		}) ;	
		
	}
	
} ;
Bubble.prototype.generatePoint=function(level){
	var x = this.report.leftButtom.x ;
	var y = this.report.leftButtom.y ;
	var width = this.report.width ;
	
	var r = parseInt(width/3) ;
	var tr = parseInt(r*level*0.9) ;
	var br = parseInt(r*(level-1)*1.1) ;
	tr = tr*tr ;
	br = br*br ;
	
	while(true){
		var x1 = parseInt(Math.random()*width) ;
		var y1 = parseInt(Math.random()*width) ;
		if(x1-(x+10)<0||y1-(y-10)>0) continue ;//只能第一象限
		var length = (x1-x)*(x1-x) + (y1-y)*(y1-y) ;
		if(length>br&&length<tr){
			return {x:x1,y:y1} ;
		}
	}
} ;

function showObj(o){
	var msg = "" ;
	for(key in o) {
		msg += key ;
		msg += ";" ;
	}
	return msg ;
}


