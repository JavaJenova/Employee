<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String id = request.getParameter("emp_id");
String date = request.getParameter("Sal_date");
String amnt = request.getParameter("Sal_amnt");


/* String id="657";
 String date="1991-10-05"; 
 String amount="10000";
 String query="select * from user where user id='"+id+"' and user date='"+date+"' and user salary='"+amount+"'";*/
try
{
Class.forName("com.mysql.jdbc.Driver");

//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root"," ");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
PreparedStatement ps=conn.prepareStatement("insert into Emp_Sal (emp_id,Sal_date,Sal_amnt) values ("+id+","+date+","+amnt+")");
 ps.execute();

} catch (Exception e) {

response.getWriter().print("Something Wents Wrong!!!!!!!! Please try again") ;
		return;
}

response.sendRedirect("younis.jsp");
%>
</body>
</html>

