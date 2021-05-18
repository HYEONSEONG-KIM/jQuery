<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProdVO prod = (ProdVO)request.getAttribute("prodvo");

%>

<%if(prod != null){ %>
{
	"sw" : "OK",
	"nm" : "<%=prod.getProd_name() %>",
	"id" : "<%=prod.getProd_id() %>",
	"price" : "<%=prod.getProd_price()%>",
	"lgu" : "<%=prod.getProd_lgu() %>",
	"detail" : "<%=prod.getProd_detail() %>"
}

<%}else{
%>
	{
		"sw" : "NO"
	}
		
<%}%>