package com.hb.guest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.guest.model.GuestDao;

@WebServlet("/guest/del.do")
public class DeleteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="./list.do";
		String param=request.getParameter("idx").trim();
		
		try{
			int sabun=Integer.parseInt(param);
			GuestDao dao = new GuestDao();
			dao.deleteOne(sabun);
		}catch(Exception e){
			url="detail.do?idx="+param;
		}finally{
			response.sendRedirect(url);
		}
	}

}
