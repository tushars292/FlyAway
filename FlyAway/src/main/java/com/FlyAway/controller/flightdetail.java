package com.FlyAway.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

public class flightdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	Statement theStatement;
	ResultSet rs;

	public flightdetail() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String source = request.getParameter("Source");
		String destination = request.getParameter("Destination");
		if (!(source.equals(destination))) {
			String no_of_people = request.getParameter("NoofPeople");
			String travel_date = request.getParameter("traveldate");
			ArrayList<String> ut = new ArrayList<String>();
			ut.add(source);
			ut.add(destination);
			ut.add(no_of_people);
			ut.add(travel_date);
			flightdetail fd = new flightdetail();
			fd.connectToDb();
			String fetchQry = "select * from flight_information where Source='" + source + "'AND Destination='"
					+ destination + "'";
			ResultSet rs=	fd.fetchRecordsforplace(response, request, fetchQry);
			request.setAttribute("resultset", rs);
			
			    HttpSession session=request.getSession();
			session.setAttribute("fetchQry", fetchQry);
				
			
			request.setAttribute("data", ut);
			

			request.getRequestDispatcher("flightsearch.jsp").forward(request, response);

		} else {
			PrintWriter out = response.getWriter();
		    out.println(" <script> ");
		    out.println(" function printPopUp() {  ");
		    out.println(" alert("+"Destination and Source can not be same"+")  ");  
		    out.println("   window.print() }  </script>  ");
		    out.println(" function printPopUp() {  ");
	                
	              
	     
			response.sendRedirect("index.jsp");
		}
	}

	void connectToDb() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "");

			theStatement = dbCon.createStatement();

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
