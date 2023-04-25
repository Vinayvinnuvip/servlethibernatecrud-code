package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.SequenceInputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dto.User1;
import com.service.User1Service;
@WebServlet("/register")

public class Register extends HttpServlet {
	
	
	User1Service us=new User1Service();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String name=req.getParameter("name");
		int id=Integer.parseInt(req.getParameter("id"));
		int age=Integer.parseInt(req.getParameter("age"));
		String mail=req.getParameter("mail");
		String pass=req.getParameter("pass");
		User1 u=new User1();
		u.setAge(age);
		u.setName(name);
		u.setId(id);
		u.setEmail(mail);
		u.setPassword(pass);
		
		User1 u1=us.saveUser(u);
		System.out.println("saved"+u1.getName());
		PrintWriter out=resp.getWriter();
		out.print("Sucessfully registered"+" please login..!");
		req.getRequestDispatcher("login.html").include(req, resp);
	}

}
