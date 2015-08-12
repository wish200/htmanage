function showObj(o){
	var msg = "" ;
	for(tmp in o){
		msg+= tmp+";" ;
	}
	return msg ;
}

function isValid(str){
	if(!str) return false ;
	if($.trim(str).length==0) return false ;
	return true ;
}