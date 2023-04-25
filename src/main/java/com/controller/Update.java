package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.User1;
import com.service.User1Service;
@WebServlet("/update")
public class Update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name= req.getParameter("name");
	int id=Integer.parseInt(req.getParameter("id"));
	int age=Integer.parseInt(req.getParameter("age"));
	String mail=req.getParameter("mail");
	String pass=req.getParameter("pass");
	resp.setContentType("text/html");
	User1Service us=new User1Service();
	User1 u=us.getUserById(id);
	if(u!=null) {
		u.setAge(age);
		u.setName(name);
		u.setId(id);
		u.setEmail(mail);
		u.setPassword(pass);
		us.update(u);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}else {
		PrintWriter out=resp.getWriter();
		out.print("user not exists");
		req.getRequestDispatcher("index.jsp").include(req, resp);
		
		
	}
	}

}
