package com.montu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Integer id=(Integer)session.getAttribute("id");
		System.out.println(id);
		Connection con=GetCon.getCon();
		try {
			
			PreparedStatement ps=con.prepareStatement("delete  from inbox6 where id = '"+id+"' ");
			
			//ps.setString(1,email);
			//ps.setString(2,password);
			int s =ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("delete","Mail has been Succefully deleted");
		RequestDispatcher rd=request.getRequestDispatcher("inbox.jsp");
		rd.include(request, response); 
	}

}
