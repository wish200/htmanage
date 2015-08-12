function initidxcatgory(id){
	$.ajax({
		            url :"${ctx }/common/cond_getIdxCatgory.do",
					type : 'POST',
					data : {
					},
					dataType : 'json',
					error : function() {
						alert('系统错误。请与管理员联系');
					},
					success : function(data) {
					  var gson = data;
					  var _html="";
					  $('#'+id).html("");
					  for(var i=0;i<gson.length;i++){
						  _html+="<dd value='"+gson[i].idxcatgorycode+"'>"+gson[i].idxcatgoryname+"</dd>"
//					    $('#'+id).append("<dd value='"+gson[i].idxcatgorycode+"'>"+gson[i].idxcatgoryname+"</dd>");
					  };
					  $('#'+id).html(_html);
					}
	});
}