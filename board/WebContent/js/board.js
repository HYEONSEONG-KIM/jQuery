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
				
				// 댓글쓰기 구성
				code += '<p class = "p4">';
				code += '<textarea cols = "100" ></textarea>';
				code += '<input type = "button" value = "등록" name = "reply" class = "action">'
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