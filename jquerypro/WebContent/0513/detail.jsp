<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();

	MemberVO mem = (MemberVO)smc.queryForObject("member.selectOne",id);

%>

{
	"이름" : "<%=mem.getMem_name()%>",
	"주소" : "<%=mem.getMem_add1() + mem.getMem_add2()%>",
	"이메일" : "<%=mem.getMem_mail()%>",
	"전화번호" : "<%=mem.getMem_hp()%>",
	"생일" : "<%=mem.getMem_bir()%>"
}