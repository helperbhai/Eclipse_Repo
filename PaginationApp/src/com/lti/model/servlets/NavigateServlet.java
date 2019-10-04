package com.lti.model.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NavigateServlet
 */
@WebServlet("/NavigateServlet")
public class NavigateServlet extends HttpServlet {
	
 private int pageSize = 2;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		Integer from = (Integer) session.getAttribute("from");
		Integer to = (Integer) session.getAttribute("to");
		from = to;
		to = to+2;
		session.setAttribute("from", from);
		session.setAttribute("to", to);
		response.sendRedirect("/ProductServlet");*/
		
		HttpSession session = request.getSession();
		Integer cursor = (Integer) session.getAttribute("cursor");
		if(cursor == null)
			cursor =1;
		
		String action = request.getParameter("action");
		if(action!=null) {
			if(action.equals("next"))
				cursor += pageSize;
			
		}
		
	
	}
}
