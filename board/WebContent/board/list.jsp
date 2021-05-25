<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
	int sPage = (Integer)request.getAttribute("sp");
	int ePage = (Integer)request.getAttribute("ep");
	int tPage = (Integer)request.getAttribute("tp");
%>

{
	"tp" : "<%=tPage%>",
	"ep" : "<%=ePage%>",
	"sp" : "<%=sPage%>",
	"datas" : [
	
		<%
	for(int i = 0; i < list.size(); i++){
		BoardVO vo = list.get(i);
		if(i > 0) out.print(",");
%>
	{
		"num" 		: "<%=vo.getNum() %>",
		"subject" 	: "<%=vo.getSubject() %>",
		"writer" 	: "<%=vo.getWriter() %>",
		"mail" 		: "<%=vo.getMail() %>",
		"hit" 		: "<%=vo.getHit() %>",
		"wdate" 	: "<%=vo.getWdate() %>",
		"content"	: "<%=vo.getContent().replaceAll("\r\n", "<br>") %>"
	}



<%
	}
%>
		
	
	]
}







<%-- 
[
<%
	for(int i = 0; i < list.size(); i++){
		BoardVO vo = list.get(i);
		if(i > 0) out.print(",");
%>
	{
		"num" 		: "<%=vo.getNum() %>",
		"subject" 	: "<%=vo.getSubject() %>",
		"writer" 	: "<%=vo.getWriter() %>",
		"mail" 		: "<%=vo.getMail() %>",
		"hit" 		: "<%=vo.getHit() %>",
		"wdate" 	: "<%=vo.getWdate() %>",
		"content"	: "<%=vo.getContent().replaceAll("\r\n", "<br>") %>"
	}



<%
	}
%>

] --%>