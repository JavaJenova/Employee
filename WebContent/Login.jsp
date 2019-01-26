<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
 {
  font-family: "Open Sans", sans-serif;
  line-height: 1.25;
}
table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
}

table caption {
  font-size: 1.5em;
  margin: .5em 0 .75em;
}

table tr {
  background-color: #f8f8f8;
  border: 1px solid #ddd;
  padding: .35em;
}

table th,
table td {
  padding: .625em;
  text-align: center;
}

table th {
  font-size: .85em;
  letter-spacing: .1em;
  text-transform: uppercase;
}

@media screen and (max-width: 600px) {
  table {
    border: 0;
  }

  table caption {
    font-size: 1.3em;
  }
  
  table thead {
    border: none;
    clip: rect(0 0 0 0);
    height: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;
    width: 1px;
  }
  
  table tr {
    border-bottom: 3px solid #ddd;
    display: block;
    margin-bottom: .625em;
  }
  
  table td {
    border-bottom: 1px solid #ddd;
    display: block;
    font-size: .8em;
    text-align: right;
  }
  
  table td::before {
    /*
    * aria-label has no advantage, it won't be read inside a table
    content: attr(aria-label);
    */
    content: attr(data-label);
    float: left;
    font-weight: bold;
    text-transform: uppercase;
  }
  
  table td:last-child {
    border-bottom: 0;
  }
}
</style>

</head>
<body>
<table>
  <caption>Login detail</caption>
<p><a href="http://localhost:8080/webProject/nancy.html"></a></p>
<%
ResultSet rs = null;
try
{
Class.forName("com.mysql.jdbc.Driver");

//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root"," ");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
PreparedStatement ps=conn.prepareStatement("select * from emp_details");
 rs=ps.executeQuery();

} catch (ClassNotFoundException e) {
response.getWriter().print("Something Wents Wrong!!!!!!!! Please try again") ;

}


%>

<table align="center";>


<tr><th>ID</th><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th><th>MOBILE</th><th>DATE OF BIRTH</th><th>GENDER</th><th>QUALIFICATION</th><th>DATE OF JOINING</th><th>YEAR OF EXPERIENCE</th> </tr>
<%
while(rs.next())
{
%>
<tr><td><%out.println(rs.getString(1)); %></td>  <td><%out.println(rs.getString(2)); %></td>   <td><%out.println(rs.getString(3)); %></td>    <td><%out.println(rs.getString(4)); %></td> <td><%out.println(rs.getString(5)); %></td> <td><%out.println(rs.getString(6)); %></td> <td><%out.println(rs.getString(7)); %></td> <td><%out.println(rs.getString(8)); %></td> <td><%out.println(rs.getString(9)); %></td> <td><%out.println(rs.getString(10)); %></td> </tr>
<%

}
%>
</table>

</body>
</html>