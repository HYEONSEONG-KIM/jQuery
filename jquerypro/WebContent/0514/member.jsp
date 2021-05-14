<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
	
	List<MemberVO> memList = smc.queryForList("member.selectAll");

%>
[
	<%for(int i = 0; i < memList.size(); i++){
		if(i > 0) out.print(",");
		
	%>
		
		
		{
			"이름" : "<%=memList.get(i).getMem_name()%>",
			"아이디" : "<%=memList.get(i).getMem_id()%>",
			"주소" : "<%=memList.get(i).getMem_add1()%>",
			"전화번호" : "<%=memList.get(i).getMem_hp()%>"
		
		}
	<%}%>


]
