<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String aa[] = {"홍길동", "개나리", "진달래", "무궁화", "수선화"};
%> 

	<ul>
		<%
			for(int i = 0; i < aa.length; i++){
			%>
			<li><%=aa[i]%></li>
			<%	
			}
		%>
	</ul>

</body>
</html>