/*----------------------------- 
Name: 管理信息 javascript
Author: zh
Updater:  
Time: 2015-07
-----------------------------*/

/*--------------
查看图片
---------------*/

function selectForward(e){
			var newwin = window.open();
			var picPath = e.src;
			newwin.document.write("<img src='"+picPath+"'>");
} 

/*--------------
查看音频
---------------*/
function selectForward1(Path){
			var newwin = window.open(Path);
} 

function changeFile(e,fileType){
	    //$(e).parent('.filebtn').prev('.changeTxt').find('input[type="text"]').val($(e).val());
		$("#"+fileType).val($(e).val());
}

/*--------------
上传图片和音频
---------------*/
function fileUpload(index,field,type)
    {  
		var isorigin="0";
		$("#isorigin"+index).attr("name","isorigin");
    	$("#isorigin"+index).attr("id","isorigin");
		if($("#isorigin").is(':checked')||type=="audio"){
			isorigin = "1"; 
		}
	
    	$("#Filedata"+index).attr("name","Filedata");
    	$("#Filedata"+index).attr("id","Filedata");
    	$("#filespan"+index).remove();
    	var path = $("#Filedata").val(); 
    	var filename = path.substring(path.lastIndexOf('\\')+1,path.lastIndexOf('.')); 
		if(path==""){
			alert("请选择上传文件！");
			return ;
		}
		var fileContentType = path.substring(path.lastIndexOf('.')+1).toLowerCase();
		
		if(type=='pic'){
			if(fileContentType!="jpg" && fileContentType!="gif" && fileContentType!="png" && fileContentType!="jpeg"){
				alert("格式不正确，上传格式包括：JPG，GIF，PNG，JPEG,请重新选择文件！");//上传格式包括：JPG，GIF，PNG，JPEG，
				return;
			}
		}else if(type=='audio'){
			
			if(fileContentType!="mp3" && fileContentType!="amr" ){
				alert("格式不正确，上传格式包括：mp3,请重新选择文件！");//上传格式包括：JPG，GIF，PNG，JPEG，
				return;
			}
		}
			
   
   		$("#loading"+index).ajaxStart(function(){
    		$(this).show();
        })//开始上传文件时显示一个图片
        .ajaxComplete(function(){
            $(this).hide();
        });//文件上传完成将图片隐藏起来
        
        $.ajaxFileUpload
        (
            {
            	data:{moduleid:field,isorigin:isorigin,type:type},
                url: '${ctx}/common/attchMent_uploadFile.do',//用于文件上传的服务器端请求地址
                secureuri:false,//一般设置为false
                fileElementId:'Filedata',//文件上传空间的id属性  <input type="file" id="file" name="file" />
                dataType: 'text',//返回值类型 一般设置为json
                success: function (data, status)  //服务器成功响应处理函数
                {
                   
								if(type=='pic'){
									var span = "<span id='filespan"+index+"'><img hspace=\"2\" vspace=\"2\" border=\"1\" align=\"middle\" height=\"100\" width=\"100\"  src=\""+ data + "\" onclick=\"selectForward(this);\" />"+
						            	"</span>";
									$("#"+field).val(data);
								}else{
									var span = "<span id='filespan"+index+"' onclick=selectForward1('./../jsp/program/play.jsp?name="+filename+"&path="+data.replace('duration','&duration')+"') > listen1"+
						            	"</span>";
									if(data.indexOf("duration=")>0){
										$("#audiolength").val(data.substr(data.indexOf("duration=")+9));
										$("#"+field).val(data.substr(0,data.indexOf("duration=")));
									}else{
										$("#"+field).val(data);
									}
									
								}
						          
						          $("#Filedata").parent().append(span);
						          $("#Filedata").attr("name","Filedata"+index);
					    		  $("#Filedata").attr("id","Filedata"+index);
					    		  $("#isorigin").attr("name","isorigin"+index);
					    		  $("#isorigin").attr("id","isorigin"+index);
						          alert("上传成功！");
	            
                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                    alert(e);
                }
            }
        )
        
        return false;

    }