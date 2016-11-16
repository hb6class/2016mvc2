package com.hb.mvc2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class IndexController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.print("<h1>index</h1>");
		System.out.println(request.getParameter("id"));
		request.setAttribute("msg", "HELLO");
		HttpSession session = request.getSession();
		session.setAttribute("msg2", "JavaWorld");
		System.out.println(session.getAttribute("msg2"));
		RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
//		response.sendRedirect("/Ex01.do?id="+request.getParameter("id"));
		//http://localhost:8080/Ex01.do?id=kkk
	}

}
