package com.FlyAway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Adminformser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	Statement theStatement;

	public Adminformser() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

	
		Adminformser ad = new Adminformser();
		ad.connectToDb();
		ad.fetchRecords(username, password, response,request);

	}

	void connectToDb() {

		try {
//	        	Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "");
//				Create a Statement
			theStatement = dbCon.createStatement();
			// if(dbCon !=null) {
//					System.out.println("Successfully connected to db...");
//				}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Can't load the driver or can't connect to db : " + e);
		}
	}

	void fetchRecords(String username, String password, HttpServletResponse response,HttpServletRequest request) {
		try {
			String usernametable = "";
			String passwordtable = "";

//				Write query to fetch records from table:studentDetails
			String fetchQry = "select * from admin_table";

//				Execute the query
			ResultSet rs = theStatement.executeQuery(fetchQry);

//				Traverse through the results
			while (rs.next()) {
				usernametable = rs.getString("username");
				passwordtable = rs.getString("password");

			}

			if (username.equalsIgnoreCase(usernametable) && password.equalsIgnoreCase(passwordtable)) {
				try {
					request.setAttribute("data", username );
					request.getSession().setAttribute("user",username); 
					RequestDispatcher rd =  
				             request.getRequestDispatcher("adminpage.jsp");
					rd.forward(request, response);
				
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				try {
					
					PrintWriter out = response.getWriter();  
					
					response.sendRedirect("Adminlogin.jsp");
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			System.out.println("Unable to create a Statement : " + e);
		}
	}
}
