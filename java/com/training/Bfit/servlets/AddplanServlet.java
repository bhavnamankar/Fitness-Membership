package com.training.Bfit.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.Bfit.dao.Membership_StatusDao;
import com.training.Bfit.dao.Membership_plansDao;
import com.training.Bfit.dao.TransactionDao;

/**
 * Servlet implementation class AddplanServlet
 */
@WebServlet("/AddplanServlet")
public class AddplanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddplanServlet() {
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
		System.out.println("servlet called");
		 HttpSession session = request.getSession();
		String planName=request.getParameter("plan");
		System.out.println(planName);
		int duration=Integer.parseInt(request.getParameter("duration"));
		System.out.println(duration);
		int planId=Membership_plansDao.getPlanId(planName, duration);
		int memId = (Integer) session.getAttribute("memberId");
		System.out.println(memId);
		session.setAttribute("planid", planId);
		session.setAttribute("duration", duration);		
		response.sendRedirect("payment.jsp");
	}
	

}
