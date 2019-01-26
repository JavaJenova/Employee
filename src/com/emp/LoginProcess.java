package com.emp;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public LoginProcess() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("psw");

		String query ="select * from user where user_email='"+email+"' and user_password='"+password+"'";
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			if(rs.next()) {
				String name = rs.getString("user_name");
				HttpSession hs = request.getSession();
				hs.setAttribute("u_name", name);
				response.sendRedirect("emp_list.jsp");
			}else {
				response.sendRedirect("login.html");
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			
	}

}
