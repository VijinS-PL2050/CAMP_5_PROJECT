package com.global.dbTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String user="root";
		String password="mebeena2426";
		String jdbcUrl="jdbc:mysql://localhost:3306/Global_Health_Care_Management?serverTimezone=UTC";
		String driver="com.mysql.cj.jdbc.Driver";
		
		//get connection to database
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting to database "+jdbcUrl+"\n");
			
			//Connection String
			Class.forName(driver);
			Connection myConnection=DriverManager.getConnection(jdbcUrl, user, password);
			out.println("SUCCESS!!!");
			myConnection.close();
		}catch(Exception ex) {
			throw new ServletException(ex);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
