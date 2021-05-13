<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("id");
	String upass = request.getParameter("pass");
	
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
	
	

%>