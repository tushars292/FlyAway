package com.FlyAway.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Booking
 */
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	Statement theStatement;
	ResultSet rs;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flightno = request.getParameter("book");
		System.out.println(flightno);
		HttpSession session = request.getSession();
		Booking bk = new Booking();
		bk.connectToDb();
	String fetchQry=(String)	session.getAttribute("fetchQry");
ResultSet rs=	bk.fetchRecordsforplace(response, request, fetchQry);

		
		try {
			ArrayList<String> ut = new ArrayList<String>();
			System.out.println("hi"+rs);
			while (rs.next()) {
				System.out.println("enetered the loop");
				
				if (rs.getString("Flight_No").equals(flightno)) {
                System.out.println("got the value");
					
					ut.add(rs.getString("Flight_Name"));
					ut.add(flightno);
					ut.add(rs.getString("Source"));
					ut.add(rs.getString("Destination"));
					ut.add(rs.getString("Depature"));
					ut.add(rs.getString("Arrival"));
					ut.add(rs.getString("No_of_stops"));
					ut.add(rs.getString("time"));
					ut.add(rs.getString("price"));
				
			break;

				}

			}
			
		
	                   
			

			session.setAttribute("flightinformation", ut);
			response.sendRedirect("userlogin.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	ResultSet fetchRecordsforplace(HttpServletResponse response, HttpServletRequest request, String fetchQry) {
		ResultSet rs=null;
		try {

			 rs = theStatement.executeQuery(fetchQry);


		
		} catch (SQLException e) {
			System.out.println("Unable to create a Statement : " + e);
		}
		return rs;
	}
}
