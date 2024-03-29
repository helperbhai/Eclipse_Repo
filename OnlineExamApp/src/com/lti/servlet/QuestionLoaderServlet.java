package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.QuestionBank;
import com.lti.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
	
	private List<Question> questions;
	private int noOfQuestions;
	
	@Override
	public void init() throws ServletException {
		questions = QuestionBankLoader.loadQuestionOnJava();
		noOfQuestions = questions.size();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer questionNo = (Integer) session.getAttribute("qNo");
		if(questionNo == null)
			questionNo = 0;
		else
			questionNo++;
		session.setAttribute("qNo", questionNo);
		
		if(questionNo>= questions.size()) {
			
			response.setContentType("text/html");
			PrintWriter pr= response.getWriter();
			pr.print("<form action='DisplayScoreServlet'>");
			pr.print("<button type ='submit'>Submit Test</button>");
			pr.print("</form>");
		}
	
		Question  q = questions.get(questionNo++);
		session.setAttribute("currentQs", q);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		out.print("<form action= 'CalculateScoreServlet'>");
		out.print("<h3>" + q.getQuestion() + "</h3>");
		int optionNo = 0;
		for(Option o : q.getOptions()) {			
			out.print("<h4><input type='radio' name ='op' value= '"+(optionNo++)+"'/>" + o.getOption()+ "</h4>");			
		}
		out.print("<button type ='submit'>Continue</button>");
		out.print("</form>");
	}
}

