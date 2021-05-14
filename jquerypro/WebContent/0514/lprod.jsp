<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();

	List<LprodVO> lprodList = smc.queryForList("lprod.selectLprod");

%>
[
	<%for(int i = 0; i < lprodList.size(); i++){
		if(i > 0) out.print(",");
		%>
		{
			"Lprod_id" : "<%=lprodList.get(i).getLprod_id() %>",
			"Lprod_gu" : "<%=lprodList.get(i).getLprod_gu() %>",
			"Lprod_nm" : "<%=lprodList.get(i).getLprod_nm() %>"
		}
		
		
		
		
	<% }%>


]
