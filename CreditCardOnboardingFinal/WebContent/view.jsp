<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.AdminBean.AdminBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Student information: </h3>
<%ArrayList<AdminBean> li=(ArrayList<AdminBean>)request.getAttribute("list");%>

<table>
<%for(AdminBean ab:li){%>
<tr>
	<td>
	<%=ab.getFname()%>
	</td>
	<td>
	<%=ab.getLname()%>
	</td>
	<td>
	<%=ab.getUid()%>
	</td>
	<td>
	<%=ab.getStatus()%>
</tr>
<%}%>



</table>



</body>
</html>