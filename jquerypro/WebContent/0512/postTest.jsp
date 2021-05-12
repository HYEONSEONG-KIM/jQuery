<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String ss ="0";
	String sid = request.getParameter("id");
	String spass = request.getParameter("pass");
	
	if(sid.equals("kimgustjd") && spass.equals("1234")){
		ss = "0";
	}else{
		ss = "1";
	} 
	 
	
	
%>
<%-- json object --%>

<%if(ss.equals("0")){
%>
	{	
		"sw" : "로그인 성공",
		"id" : "<%= sid %>"
	}
<%	
}else{
%>
	{
		"sw" : "로그인 실패",
		"id" : "<%= sid %>"
	}
		
<%
}
%>