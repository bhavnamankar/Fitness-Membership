package com.training.Bfit.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class SuccessfullPaymentServlet
 */
@WebServlet("/SuccessfullPaymentServlet")
public class SuccessfullPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessfullPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("payment.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
			
			int planId=(Integer)session.getAttribute("planid");
			int duration=(Integer)session.getAttribute("duration");
			int memId = (Integer) session.getAttribute("memberId");
			
			Date currentDate=new Date();
			Date endDate=addMonthsToDate(currentDate,duration);
			boolean isSuccess=Membership_StatusDao.membershipStatus(planId, memId,currentDate,endDate);
			session.setAttribute("start_date", currentDate);
			session.setAttribute("end_date", endDate);
			 boolean isSuccess2=TransactionDao.sucessfullPayment(planId, memId);
			 if (isSuccess==true&&isSuccess2==true) {
					response.sendRedirect("Success.jsp");
				} else {
					response.sendRedirect("Error.jsp");
				}
		
	}
	public static Date addMonthsToDate(Date date,int months) {
		 Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.MONTH, months);
	        return calendar.getTime();
	}
}
