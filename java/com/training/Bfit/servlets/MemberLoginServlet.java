package com.training.Bfit.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.Bfit.dao.MemberDao;
import com.training.Bfit.model.Members;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Members member=MemberDao.isMember(username, password);
         
         
         if (member.getMember_Id()!=0) {
        	 HttpSession session = request.getSession();
           
             // Store data in the session
        	 session.setAttribute("memberId", member.getMember_Id());
             request.setAttribute("userName", username);
             request.setAttribute("fullName", member.getFullName());
             request.setAttribute("email", member.getEmail());
             request.setAttribute("phoneNumber", member.getPhone_Number());
            request.setAttribute("address", member.getAddress());
             request.setAttribute("plans", member.getPlans());
            
        
             
           
             	request.getRequestDispatcher("/Dashboard2.jsp").forward(request, response);
				//response.sendRedirect("Dashboard.jsp");
			} else {
//				response.sendRedirect("Error.jsp");
				request.setAttribute("errorMessage", "Invalid Username and Password");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
				
			}
		
	}

}
