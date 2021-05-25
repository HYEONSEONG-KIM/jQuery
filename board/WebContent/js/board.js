/**
 * 
 */
writeServer = function(){
	
	
	$.ajax({
		url : '/board/Write.do',
		method : 'post',
		data :  $('form').serializeArray(),
		success : function(data){
			readServer(1);
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}


readServer = function(page){

	$.ajax({
		
		url : '/board/List.do',
		method : 'post',
		data : {"page" : page},
		success : function(data){
			datas = data.datas
			
			code = '<div class="panel-group" id="accordion">';
			$.each(datas,function(i,v){
				
				code += '<div class="panel panel-default">';
				code += '<div class="panel-heading">';
				code += '<h4 class="panel-title">';
				code += '<a data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.num +'">';
				code += v.subject + '</a>';
				code += '</h4>';
				code += '</div>';
				code += '<div id="collapse' +v.num +'" class="panel-collapse collapse out">';
				code += '<div class="panel-body">';
				code += '<p class = "p1">작성자 : ' + v.writer + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '조회수 : ' + v.hit + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '날짜 : ' + v.wdate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				
				code += '</p>';
				code += '<p class = "p2">';
				code += '<input type = "button" name = "modify" value = "수정" class = "action">'
				code += '<input type = "button" name = "delete" value = "삭제" class = "action">'
				code += '</p>';
				code += '<p class = "p3">';
				code += v.content
				code += '</p>';
					
				code +=	'</div>';
				code += '</div>';
				code += '</div>';
				
			})
			
			code += '</div>';
			$('#list').html(code);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
	
}