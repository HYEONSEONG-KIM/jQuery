<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("id");
	
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
	
	List<BuyerVO> buyerList = smc.queryForList("buyer.buyerDetail",uid);
%>

	<%for(int i = 0 ; i < buyerList.size(); i++){
		if(i > 0) out.print(",");
		%>
		{
			"buyer_id" : "<%=buyerList.get(i).getBuyer_id() %>",
			"buyer_name" : "<%=buyerList.get(i).getBuyer_name() %>",
			"buyer_lgu" : "<%=buyerList.get(i).getBuyer_lgu() %>",
			"buyer_bank" : "<%=buyerList.get(i).getBuyer_bank() %>",
			"buyer_bankno" : "<%=buyerList.get(i).getBuyer_bankno() %>",
			"buyer_bankname" : "<%=buyerList.get(i).getBuyer_bankname() %>",
			"buyer_zip" : "<%=buyerList.get(i).getBuyer_zip() %>",
			"buyer_add1" : "<%=buyerList.get(i).getBuyer_add1() %>",
			"buyer_add2" : "<%=buyerList.get(i).getBuyer_add2() %>",
			"buyer_mail" : "<%=buyerList.get(i).getBuyer_mail() %>"
		}
	
	
	<% }%>





