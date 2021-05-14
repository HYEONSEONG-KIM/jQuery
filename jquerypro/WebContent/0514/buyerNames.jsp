<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();

	List<BuyerVO> buyerNameList = smc.queryForList("buyer.buyerNames");

%>
[
	<%for(int i = 0; i < buyerNameList.size(); i++){
		if(i > 0) out.print(",");
		BuyerVO vo = buyerNameList.get(i);
		%>
		{
			"name" : "<%=vo.getBuyer_name()%>",
			"id" : "<%=vo.getBuyer_id()%>"
		}
		
		
	<%}%>

]
