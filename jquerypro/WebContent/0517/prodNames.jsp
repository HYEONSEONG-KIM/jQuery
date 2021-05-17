<%@page import="kr.or.ddit.prod.controller.ProdController"%>
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<ProdVO> list = (List<ProdVO>)request.getAttribute("listvalue");

%>


	<%
		if(list !=null && list.size() >0){	
	%>
			{
				"sw" : "ok",
				"data2" : [
					<%for(int i = 0; i < list.size(); i++){
						ProdVO vo = list.get(i);
						if(i > 0) out.print(",");	
					%>
						{
							"nm" : "<%=vo.getProd_name() %>",
							"id" : "<%=vo.getProd_id() %>"
						}
						
						
					<% }%>
				]
			}
	<%
		}else{
		%>
			{
				"sw" : "no"
			}
		<%}%>

