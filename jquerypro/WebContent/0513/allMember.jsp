<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// sqlMap의 select구문 호출
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
	
	List<MemberVO> member = smc.queryForList("member.selectAll");


%>

<%-- member결과로 json object배열을 응답 데이터로 생성--%>
[
	<%for(int i = 0; i < member.size(); i++){ 
	%>		<%if(i > 0) out.print(",");
		%>
		{
			"name" : "<%=member.get(i).getMem_name()%>",
			"id" : "<%=member.get(i).getMem_id()%>"
		}
		
		<%-- <%if(i != member.size()-1){
		%>
		,
		<%	
		}%> --%>
	
	<%
	}%>
]

