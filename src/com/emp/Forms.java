package com.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forms
 */
@WebServlet("/Forms")
public class Forms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		/*String emp_id="1";
		String fname="jeeva";
		String lname="dhivya";
		String emp_email="hsgdjsd";
		String emp_mobile="87687937433";
		String emp_dob="1995-02-5";
		String emp_gender="female";
		String qual="B.E";
		String jod="";
		String exp="2";
		String query="insert into emp_details values("+emp_id+",'"+fname+"', '"+lname+"','"+emp_email+"','"+emp_mobile+"',"+emp_dob+",'"+emp_gender+"','"+qual+"',"+jod+","+exp+")";
		
		String s="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pwd="";*/
		
		String id = request.getParameter("emp");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String dob = request.getParameter("date");
		String gen = request.getParameter("radio");
		String qua = request.getParameter("qualification");
		String doj = request.getParameter("date");
		String yoe = request.getParameter("Year Of Experience");
		
		String query ="insert into emp_details values('"+id+"','"+fname+"','"+lname+"' ,'"+email+"','"+mob+"','"+dob+"','"+gen+"','"+qua+"','"+doj+"','"+yoe+"')";
		System.out.println(query);
		String s="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pwd="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection(s,user,pwd);
			Statement st=c.createStatement();
			Boolean rs=st.execute(query);
			//System.out.println(rs);
			
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
