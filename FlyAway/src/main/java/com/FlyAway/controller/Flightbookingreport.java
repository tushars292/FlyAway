package com.FlyAway.controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Flightbookingreport
 */
public class Flightbookingreport extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Flightbookingreport() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String [] seat= {"10-A","10-B","10-C","10-D","10-E","10-F","11-A","11-B","11-C"};

		request.setAttribute("seat", seat);
        request.getRequestDispatcher("FlightBookingreport.jsp").forward(request, response);
	}

}
