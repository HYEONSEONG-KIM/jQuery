/**
 * 
 */
replyListServer = function(btn){
	
	
	$.ajax({
		url : '/board/ReplyList.do',
		type : 'post',
		data : {'bonum' : vidx},
		success : function(data){
			
			$(btn).parents('.pbody').find('.rep').remove();
			
			reply = "";
			$.each(data, function(i,v){
				
				reply += '<div class="panel-body rep">';
				reply += '<p class = "p1">작성자 : ' + v.name + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				reply += '날짜 : ' + v.redate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				
				reply += '</p>';
				reply += '<p class = "p2">';
				reply += '<input idx = "' + v.renum +'" type = "button" name = "modify" value = "댓글수정" class = "action" idx = "' + v.num +'">'
				reply += '<input idx = "' + v.renum +'" type = "button" name = "delete" value = "댓글삭제" class = "action" idx = "' + v.num +'">'
				reply += '</p>';
				reply += '<p class = "p3">';
				reply += v.cont
				reply += '</p>';
				reply += '</div>'
			})
			$(btn).parents('.panel').find('.pbody').append(reply);
		},
		error : function(xhr){
			alert(xhr.status)
		},
		dataType : 'json'
	})
	
}


replyServer = function(btn){
	
	
	
	$.ajax({
		
		url : '/board/ReplySave.do',
		type : 'post',
		data : reply,
		success : function(data){
			// 댓글 리스트 출력
			replyListServer(btn);
		},
		error : function(xhr){
			alert(xhr.status)
		},
		dataType : 'json'
		
	})
	
}

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
				code += '<a idx = "' + v.num + '"class = "list" data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.num +'">';
				code += v.subject + '</a>';
				code += '</h4>';
				code += '</div>';
				code += '<div id="collapse' +v.num +'" class="panel-collapse collapse out">';
				code += '<div class="panel-body pbody">';
				code += '<p class = "p1">작성자 : ' + v.writer + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '조회수 : ' + v.hit + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '날짜 : ' + v.wdate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				
				code += '</p>';
				code += '<p class = "p2">';
				code += '<input type = "button" name = "modify" value = "수정" class = "action" idx = "' + v.num +'">'
				code += '<input type = "button" name = "delete" value = "삭제" class = "action" idx = "' + v.num +'">'
				code += '</p>';
				code += '<p class = "p3">';
				code += v.content
				code += '</p>';
				
				// 댓글쓰기 구성
				code += '<p class = "p4">';
				code += '<textarea cols = "100" ></textarea>';
				code += '<input type = "button" value = "등록" name = "reply" class = "action" idx = "' + v.num +'">'
				code += '</p>'
				
				code +=	'</div>';
				code += '</div>';
				code += '</div>';
				
				
			})
			
			code += '</div>';
			
			$('#list').html(code);
			
			// 페이지 리스트 만들기
			
			pager = '<div class="container">';
			// 이전버튼
			if(data.sp > 1){
				pager += '<ul class="pager">';
				pager += '<li><a class = "prev" href="#">Previous</a></li>';
				pager += '</ul>';
			}
			
			
			// 페이지 번호 출력
			pager += '<ul class="pagination pager">';
			
			for(i = data.sp; i <= data.ep; i++){
				// 현재 페이지와 i값이 같은가 비교
				if(currentPage == i){
					 pager += '<li class="active"><a class = "paging" href="#">'+ i +'</a></li>';
				}else{
					pager += '<li><a class = "paging" href="#">'+ i +'</a></li>';
				}
			}
			
			 
			pager += '  </ul>';
			
			// 다음버튼
			if(data.tp > data.ep){
				pager += '<ul class="pager">';
				pager += '<li><a class = "next" href="#">Next</a></li>';
				pager += '</ul>';
			}
			
			pager += '</div>';
			
			$('#pageList').html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
	
}