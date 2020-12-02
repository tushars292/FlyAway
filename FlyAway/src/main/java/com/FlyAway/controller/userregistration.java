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

/**
 * Servlet implementation class userregistration
 */
public class userregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	Statement theStatement;
    public userregistration() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		if(newpassword.equals(confirmpassword)) {
			userregistration us=new userregistration();
			us.connectToDb();
			us.insertrecord(username, newpassword, response, request);
		}else {
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

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Can't load the driver or can't connect to db : " + e);
		}
	}

	void insertrecord(String username, String password, HttpServletResponse response,HttpServletRequest request) {
		try {
			String insertQry = "insert into user_table(username, password) values ('"+username +"', '"+password+"')";
			if (theStatement.executeUpdate(insertQry) > 0) {
				response.sendRedirect("userlogin.jsp");
			}
			else {
				response.sendRedirect("userregister.jsp");
			}

		} catch (Exception e) {
			System.out.println("Unable to create a Statement : " + e);
		}
	}
}
