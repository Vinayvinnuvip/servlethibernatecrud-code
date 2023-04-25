package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.User1Dao;
import com.dto.User1;
@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail=req.getParameter("mail");
		String pass=req.getParameter("pass");
		resp.setContentType("text/html");
		User1Dao us=new User1Dao();
		EntityManager em=us.getem();
		Query q =em.createQuery("select u from User1 u where u.email=:mail and u.password=:pass");
		q.setParameter("mail", mail);
		q.setParameter("pass", pass);
		PrintWriter out=resp.getWriter();
		List<User1> list=q.getResultList();
		System.out.println(list);
		if(list.size()>0) {

			HttpSession session=req.getSession();
			User1 u=list.get(0);
			session.setAttribute("id", u.getId());
			out.print("Successfullly loged in");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			out.print("User doesnt exist check details or register again");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}

}
