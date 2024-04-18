package com.training.Bfit.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.Bfit.dao.SuspensionDao;

/**
 * Servlet implementation class SuspensionServlet
 */
@WebServlet("/SuspensionServlet")
public class SuspensionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuspensionServlet() {
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
		HttpSession session = request.getSession();
		String startDateInput=request.getParameter("suspendStartDate");
		String endDateInput=request.getParameter("suspendEndDate");
		int planId=Integer.parseInt(request.getParameter("planId"));
		System.out.println(planId);
		LocalDate startDate=LocalDate.parse(startDateInput);
		LocalDate endDate=LocalDate.parse(endDateInput);
		long dayDifference=ChronoUnit.DAYS.between(startDate, endDate)+1;
		int memberId=(Integer)session.getAttribute("memberId");
		if(dayDifference<=30) {
		boolean isSuccess=SuspensionDao.createSuspension(memberId,planId,startDate, dayDifference);
		if(isSuccess) {
			response.sendRedirect("SuspensionConfirmation.jsp");
		}else {
			response.sendRedirect("SuspensionError.jsp");
		}
		}else {
			
			response.sendRedirect("SuspensionError2.jsp");
		}
		doGet(request, response);
	}

}
