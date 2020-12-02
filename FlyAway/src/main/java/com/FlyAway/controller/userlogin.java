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

/**
 * Servlet implementation class userlogin
 */
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	Statement theStatement;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userlogin ul=new userlogin();
		if (request.getParameter("submit") != null) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
             ul.connectToDb();
             ul.fetchRecords(username, password, response, request);

			
		} else if (request.getParameter("userregis") != null) {
	
                response.sendRedirect("userregister.jsp");
		}
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
			String fetchQry = "select * from user_table";
Boolean filecheck=true;
			ResultSet rs = theStatement.executeQuery(fetchQry);

//				Traverse through the results
			while (rs.next()) {
				usernametable = rs.getString("username");
				passwordtable = rs.getString("password");
				if (username.equalsIgnoreCase(usernametable) && password.equalsIgnoreCase(passwordtable)) {
					try {
					
					            response.sendRedirect("flightbooking.jsp");
					             filecheck =false;
					              break;  
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		 if(filecheck) {
				try {
					
					response.sendRedirect("userlogin.jsp");
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			System.out.println("Unable to create a Statement : " + e);
		}
	}
}
