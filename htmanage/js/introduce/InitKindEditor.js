//初始化KindEditor插件
function InitKindEditor(id) {
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create(id, {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
					'bold', 'italic', 'underline', 'removeformat', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'insertorderedlist', 'insertunorderedlist', '|', 'link' ],
			afterBlur : function() {
				 this.sync();
				 var limitNum = 500;  //设定限制字数
				 if(this.count('text') > limitNum) {
				       //超过字数限制自动截取
				       var strValue = editor.text();
				       strValue = strValue.substring(0,limitNum);
				       alert('限制500字！');
				       this.text(strValue);
				    }
				 this.sync();
			}
		});
	});
}