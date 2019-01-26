package com.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup_process
 */
@WebServlet("/Signup_process")
public class Signup_process extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Signup_process() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String id = "2";
		String name = "xyz";
		String email = "xyz@gmail.com";
		String password = "zxcvb";
		String mobile = "234566";
		String query="insert into user values("+id+",'"+name+"','"+email+"','"+password+"',"+mobile+")";
		System.out.println(query);
		String s="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pws="";*/
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String conpass = request.getParameter("cpassword");

		String query ="insert into user values(0,'"+name+"','"+email+"','"+password+"','"+mobile+"')";
		System.out.println(query);
		String s="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pws="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection(s,user,pws);
			Statement st=c.createStatement();
			Boolean rs=st.execute(query);
			//System.out.println(rs);
			
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("login.html");
	}
}
		
		
		
		
		