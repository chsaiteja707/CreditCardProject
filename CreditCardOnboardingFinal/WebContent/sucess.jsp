<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function fun1()
{
    window.history.forward();
}
setTimeout("fun1()",10);
</script>
<style>
     div {
            font-family: Gill Sans Ultra Bold;
  background-color:#369b82;
  width: 300px;
  border: 25px solid #702c44;
  padding: 25px;
  margin: 25px;
  text-align: center;
  position:center;
}
h1{color:#f7f7f9;text-align: center;}
        h2{color:azure; text-align: center;}
        form{text-align: center}
        legend{text-align: center}
    /*a:link, a:visited {
  background-color: azure;
  color: black;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;*/
}
    </style>
</head>
<body>

<%
    String uname=(String)session.getAttribute("uname");
	String lname=(String)session.getAttribute("lname");
	String gen=(String)session.getAttribute("gen");
	String cno=(String)session.getAttribute("cno");
	String uid=(String)session.getAttribute("uid");

%>
<div>
<h1>Welcome <%=uname%></h1>
<h1>Your account has been created sucessfully</h1>
<h1>Details</h1>
<h2>First Name : <%=uname%></h2>
<h2>Last Name : <%=lname %></h2>
<h2>Gender : <%=gen %></h2>
<h2>Account number : <%=uid%></h2>

<a href="firstpage.html"><button onclick="fun1()" style="height:30px;width:80px;"><b>LOGOUT</b></button></a>

</div>
</body>
</html>



