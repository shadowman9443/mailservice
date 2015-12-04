package com.montu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ComposeServlet
 */
public class ComposeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		
		String sender=(String)session.getAttribute("username");
		
		String reciever=request.getParameter("request_id");
		String msg=request.getParameter("message");
		int i=SendMessage.sendMsg(sender,reciever,msg);
		
		if(i>0){
			out.print("message successfully send");
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		}
		else{
			out.print("Sorry,Message was not sent");
			RequestDispatcher rd=request.getRequestDispatcher("compose.jsp");
			rd.include(request, response);
		}
		
		
		
		
		
		
		
	}

}
