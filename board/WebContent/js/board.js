/**
 * 
 */
readServer = function(page){

	$.ajax({
		
		url : '/board/List.do',
		method : 'post',
		data : {"page" : page},
		success : function(data){
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
	
}