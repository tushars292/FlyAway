package com.FlyAway.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection dbCon;
	Statement theStatement;

	public Changepassword() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");

		Changepassword cp = new Changepassword();
		cp.connectToDb();
		cp.updateRecords(newpassword, confirmpassword, response, request);
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

	void updateRecords(String newpassword, String confirmpassword, HttpServletResponse response,
			HttpServletRequest request) {

		try {
			if (newpassword.equalsIgnoreCase(confirmpassword)) {
				String updateQry = "UPDATE admin_table set password='"+confirmpassword+"' where username ='ts'";
				try {
					theStatement.executeUpdate(updateQry);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				response.sendRedirect("adminpage.jsp");
				

			} else {
				response.sendRedirect("Changepassword.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
