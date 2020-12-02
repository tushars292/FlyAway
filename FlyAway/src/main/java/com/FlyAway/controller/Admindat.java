package com.FlyAway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Admindat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection dbCon;
	Statement theStatement;

	public Admindat() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnchangepassword") != null) {
			response.sendRedirect("Changepassword.jsp");
		}else if (request.getParameter("btnchangepassword") != null) {
			response.sendRedirect("Changepassword.jsp");
		}

		PrintWriter out = response.getWriter();
		Admindat ad = new Admindat();
		ad.connectToDb();

		if (request.getParameter("btnplace") != null) {
			String fetchQry = "select Destination from flight_information";

			ad.fetchRecordsforplace(response, request, fetchQry, out);

		} else if (request.getParameter("btnairline") != null) {
			String fetchQryforairline = "select Flight_Name from flight_information";

			ad.fetchRecordsforairline(response, request, fetchQryforairline, out);
		} else if (request.getParameter("btnflightdetail") != null) {
			String fetchQry = "select * from flight_information";

			ad.fetchRecordsforflightdetail(response, request, fetchQry, out);
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

	void fetchRecordsforplace(HttpServletResponse response, HttpServletRequest request, String fetchQry,
			PrintWriter out) {
		try {

			List<String> destinationlist = new ArrayList<String>();
			ResultSet rs = theStatement.executeQuery(fetchQry);
			int i = 0;
			response.setContentType("text/html");
			 out.println("<body style='background-color:#d3d3d3;'>");
		
			out.println("<table style=\"width: 100%\">");
			out.println("<tr>");
			out.println("<td>S.No</td>");
			out.println("<td>Source/Destination</td>");
			out.println("</tr>");
			while (rs.next()) {

				String destination = rs.getString("Destination");

				if (!destinationlist.contains(destination)) {
					destinationlist.add(destination);
					i++;
					out.println("<tr>");
					out.println("<td>" + i + ")</td>");
					out.println("<td>" + destination + "</td>");

					out.println("</tr>");
				}

			}

			out.println("</	table>");
			 out.println("<body>");
		} catch (SQLException e) {
			System.out.println("Unable to create a Statement : " + e);
		}
	}

	void fetchRecordsforairline(HttpServletResponse response, HttpServletRequest request, String fetchQry,
			PrintWriter out) {
		try {

			List<String> destinationlist = new ArrayList<String>();
			ResultSet rs = theStatement.executeQuery(fetchQry);
			int i = 0;
			response.setContentType("text/html");
			 out.println("<body style='background-color:#d3d3d3;'>");
		
			out.println("<table style=\"width: 100%\">");
			out.println("<tr>");
			out.println("<td>S.No</td>");
			out.println("<td>Airline Name</td>");
			out.println("</tr>");
			while (rs.next()) {

				String destination = rs.getString("Flight_Name");

				if (!destinationlist.contains(destination)) {
					destinationlist.add(destination);
					i++;
					out.println("<tr>");
					out.println("<td>" + i + ")</td>");
					out.println("<td>" + destination + "</td>");

					out.println("</tr>");

				}

			}

			out.println("</	table>");
			 out.println("<body>");
		} catch (SQLException e) {
			System.out.println("Unable to create a Statement : " + e);
		}
	}

	void fetchRecordsforflightdetail(HttpServletResponse response, HttpServletRequest request, String fetchQry,
			PrintWriter out) {
		try {

			ResultSet rs = theStatement.executeQuery(fetchQry);
			response.setContentType("text/html");
			 out.println("<body style='background-color:#d3d3d3;'>");
		
			out.println("<table style=\"width: 100%\">");
			out.println("<tr>");
			out.println("<td>Id</td>");
			out.println("<td>Flight Name</td>");
			out.println("<td>Flight No</td>");
			out.println("<td>Source</td>");
			out.println("<td>Destination</td>");
			out.println("<td>Departure</td>");
			out.println("<td>Arrival</td>");
			out.println("<td>No of Stop</td>");
			out.println("<td>Time</td>");
			out.println("<td>Price</td>");
			out.println("</tr>");
		
			while (rs.next()) {
				int id = rs.getInt("S.No");
				String Flight_Name = rs.getString("Flight_Name");
				String Flight_No = rs.getString("Flight_No");
				String Source = rs.getString("Source");
				String Destination = rs.getString("Destination");
				String Departure = rs.getString("Depature");
				String Arrival = rs.getString("Arrival");
				int noofstop = rs.getInt("No_of_stops");
				String time = rs.getString("time");
				String price = rs.getString("price");
				out.println("<tr>");
				out.println("<td>"+id+"</td>");
				out.println("<td>"+Flight_Name+"</td>");
				out.println("<td>"+Flight_No+"</td>");
				out.println("<td>"+Source+"</td>");
				out.println("<td>"+Destination+"</td>");
				out.println("<td>"+Departure+"</td>");
				out.println("<td>"+Arrival+"</td>");
				out.println("<td>"+noofstop+"</td>");
				out.println("<td>"+time+"</td>");
				out.println("<td>"+price+"</td>");
				out.println("</tr>");
	

			}
			out.println("</	table>");
			 out.println("<body>");

		} catch (SQLException e) {
			System.out.println("Unable to create a Statement : " + e);
		}
	}
}
