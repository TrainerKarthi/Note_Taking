package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;

@WebServlet("/updateNotes")
public class UpdateNotes extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int id = Integer.parseInt( req.getParameter("id"));
		
		
		Notes notes = new Notes();
		notes.setId(id);
		notes.setTitle(title);
		notes.setDescription(description);
		
		HttpSession session = req.getSession();
		int userId = (int) session.getAttribute("userId");
		
		UserDao dao = new UserDao();
		User user = dao.fetchUserById(userId);
	
		List<Notes> list = new ArrayList<Notes>();
		list.add(notes);
		
		user.setNoteses(list);
		notes.setUser(user);
		
		dao.saveAndUpdateUser(user);
		
		resp.sendRedirect("home.jsp");
	}

}
