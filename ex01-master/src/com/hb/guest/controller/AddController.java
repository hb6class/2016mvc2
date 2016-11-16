package com.hb.guest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.guest.model.GuestDao;
import com.hb.guest.model.GuestDto;

@WebServlet("/guest/add.do")
public class AddController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/guest/add.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GuestDao dao = null;
		GuestDto dto = new GuestDto();
		int sabun = Integer.parseInt(req.getParameter("sabun"));
		int pay = Integer.parseInt(req.getParameter("pay"));
		dto.setSabun(sabun);
		dto.setName(req.getParameter("name"));
		dto.setPay(pay);
		String view ="./list.do";
		try {
			dao = new GuestDao();
			dao.insertOne(dto);
		} catch (IllegalArgumentException e) {
			view ="./add.do";
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(view);
	}
}
