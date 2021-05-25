<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int seq = (Integer)request.getAttribute("result");
	if(seq > 0){
%>

{

	"sw"  : "ok",
	"seq" : "<%=seq%>"

}
<%}else{
%>

	{
		"sw"  : "no",
		"seq" : "<%=seq%>"
	}

<%
}%>