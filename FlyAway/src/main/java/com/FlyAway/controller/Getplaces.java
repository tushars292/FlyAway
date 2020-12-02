package com.FlyAway.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Getplaces extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection dbCon;
	Statement theStatement;

    public Getplaces() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

public	void  connectToDb() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "");

			theStatement = dbCon.createStatement();

		} catch (ClassNotFoundException | SQLException e) {
	       System.out.println("Driver load exception : " + e);
		}
	}
	public ArrayList<String> fetchRecordsforplace( ) {
		String fetchQry = "select Destination from flight_information";
		ArrayList<String> destinationlist=new ArrayList<String>();
		try {


			ResultSet rs = theStatement.executeQuery(fetchQry);
		System.out.println("hi"); 
			while (rs.next()) {
				System.out.println("ki");
				String destination=rs.getString("Destination");
			
				if(!destinationlist.contains(destination)) {
					System.out.println("ti");
					destinationlist.add(destination);
				
				 
				}
			

			}

			
			

		} catch (SQLException e) {
			System.out.println("Unable to create a Statement : " + e);
		}
		return destinationlist;
	}
}
