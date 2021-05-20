<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "../js/jquery-3.6.0.min.js" type = "text/javascript"></script>
<style>
	p{
		font-size: 2.0em;
		color : blue;
	}
</style>

<script type="text/javascript">
	$(function(){
		
		$('#btncode').on('click',function(){
			// 입력값 가져오기
			vdong = $('#dong').val().trim();
			
			if(vdong.length < 1){
				alert("동을 입력하세요");
				return false;
			}
			
			// 서버로 입력한 동을 data로 보내서 처리
			$.ajax({
				url : '/jquerypro/SearchCode.do',
				type : 'get',
				data : {'dong' : vdong},
				success : function(data){
					$('#result').html(data);
				},
				error : function(xhr){
					alert(xhr.status)
				},
				dataType : 'html'
			})
		})
		
		// 결과 화면에서 하나를 선택하면
		$('#result').on('click', '.ziptr', function(){
			zip = $('td:eq(0)', this).text();
			addr = $('td:eq(1)', this).text();
			
			$('#zip',opener.document).val(zip);
			$('#Address1',opener.document).val(addr);
			
			window.close();
			
		
		})
		
	})
</script>
</head>
<body>
	<div>
		<p>찾고자 하는 동을 입력하세요</p>
		<input type = "text" id = "dong">
		<input type = "button" value = "검색" id = "btncode">
		<br><br>
		<div id = "result"></div>
	</div>
</body>
</html>