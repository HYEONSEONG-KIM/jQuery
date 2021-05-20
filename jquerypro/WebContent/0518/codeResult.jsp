<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <style>
   	.ziptr:hover{
   		background: lime;
   	}
   </style>
<%
	List<ZipVO> list = (List<ZipVO>)request.getAttribute("zipList");
	
%>

<%-- [--%>
<table>
<tr>
			<td>우편번호</td>
			<td>주소</td>
			<td>번지</td>
		</tr>
	<%for(int i = 0; i < list.size(); i++){
		ZipVO vo = list.get(i);
		//if(i > 0) out.print(",");
		String bunji = vo.getBunji();
		if(bunji == null){
			bunji = "";
		} 
	%>
	
		<tr class = "ziptr">
			<td><%=vo.getZipcode()%></td>
			<td><%=vo.getSido()%> <%=vo.getGugun()%><%=vo.getDong() %></td>
			<td><%=bunji%></td>
		</tr>
	
		<%-- {
			"zipcode": "<%=vo.getZipcode() %>",
			"addr"	 : "<%=vo.getSido()%> <%=vo.getGugun()%>,
			"bunji"	 : "<%=bunji %>"
		
		} --%>
		
	
	<%}%>
	</table>

<%-- ]--%>