package com.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  java.sql.*;

/**
 * Servlet implementation class Listprocess
 */
@WebServlet("/Listprocess")
public class Salary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Salary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

	}

}
