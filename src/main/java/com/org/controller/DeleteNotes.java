package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.NotesDao;
import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;

@WebServlet("/deleteNotes")
public class DeleteNotes extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		NotesDao dao = new NotesDao();
		boolean byId = dao.deleteNotesById(id);
		
		System.out.println(byId);
		
		resp.sendRedirect("home.jsp");
		
	}
}
