package com.FlyAway.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class registerpageinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerpageinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ArrayList<Object>> ary = new ArrayList<ArrayList<Object>>();
HttpSession session=request.getSession();
		String id[] = request.getParameterValues("id");
		String name[] = request.getParameterValues("name");
		String dateofbirth[] = request.getParameterValues("dateofbirth");
		String phone[] = request.getParameterValues("phone");
		String email[] = request.getParameterValues("email");
		for (int i = 0; i < name.length; i++) {
			ArrayList<Object> ar = new ArrayList<Object>();
			ar.add(id[i]);
			ar.add(name[i]);
			ar.add(dateofbirth[i]);
			ar.add(phone[i]);
			ar.add(email[i]);
			ar.add(request.getParameter("message"));
			ary.add(ar);
		}
		
		
		session.setAttribute("userlist", ary);
		//response.getWriter().println("List : " + session.getAttribute("userlist"));
		response.sendRedirect("finalflightdetail.jsp");
		

	}

}
