package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDemo extends HttpServlet{
	
	PrintWriter out;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		out = res.getWriter();
		out.println("hello");
		System.out.println("hi at server");
		
		System.out.println("At service");
		String fname = req.getParameter("firstname");
		String lname =req.getParameter("lastname");
		String pwd = req.getParameter("pwd");
		String checkBoxValues[] = req.getParameterValues("vehicle");
		String radioButtonValue = req.getParameter("gender");
		
		 out = res.getWriter();
		
		//if(pwd.equals("srinivas")){
		out.println("First name :"+fname);
		out.println("Last name :"+lname);
		out.print("CheckBox values are");
		for(String s:checkBoxValues){
			out.println(s);
		}
		
		if(radioButtonValue.equals("male"))
			out.print("Radio Button Value is "+radioButtonValue);
		else
			out.print("Radio Button Value is"+radioButtonValue);
		}
		
		
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("At doget");
		out = resp.getWriter();
		out.print("doget");
		service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		out = resp.getWriter();
		System.out.println("At do post");
		out.print("dopost");
		service(req, resp);
	}
	

	
	
}
