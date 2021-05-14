<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("id");
	String upass = request.getParameter("pass");
	
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
	
	Map<String, String> mem = new HashMap<String,String>();
	mem.put("mem_id", uid);
	mem.put("mem_pass", upass);
	
	MemberVO memVo = (MemberVO)smc.queryForObject("member.login", mem);
	
%>

	<% if(memVo != null){%>

{
	"sw" : "OK",
	"name" : "<%=memVo.getMem_name()%>"
	

}

	<%}else{%>
		{
			"sw" : "FAIL",
			"name" : "로그인 실패"
	

		}
	
	<%}%>