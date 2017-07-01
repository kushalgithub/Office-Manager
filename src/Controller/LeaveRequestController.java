package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import DAO.EmployeeList;
import DAO.LeaveDAO;
import Model.Model_LeaveRequest;
import Model.Model_Registration;

/**
 * Servlet implementation class LeaveRequestController
 */
@WebServlet("/LeaveRequestController")
public class LeaveRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String flag = request.getParameter("flag");
    		if(flag.equals("employee")){
    			HttpSession session=request.getSession();
    			int id = (int) session.getAttribute("id");
    			System.out.println(id);
   			 Model_LeaveRequest modlea = new Model_LeaveRequest();
   			 //modlea.setEmp_Id(id);
   			LeaveDAO leavedao = new LeaveDAO();
   			 List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
			
			try {
			leavelist= leavedao.ShowLeaves(id);
			//System.out.println("Size Of List:"+inactivelist.size());
			
			session.setAttribute("leavelist", leavelist);
			response.sendRedirect("LeaveRequest.jsp");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			
		 }

    		}
    		
    		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		int id = (int) session.getAttribute("id");
		String startdate = request.getParameter("date1");
		String enddate = request.getParameter("date2");
		String reason = request.getParameter("reason"); 
		
		
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d1 = null;
		Date d2 = null;
		 try {
		        d1 = format.parse(startdate);
		        d2 = format.parse(enddate);
		    } catch (ParseException | java.text.ParseException e) {
		        e.printStackTrace();
		    }
		 long mldiff = d2.getTime()-d1.getTime();
		long diff = TimeUnit.MILLISECONDS.toDays(mldiff)+1;
		
		 System.out.println(d1);
		 System.out.println(d2);
		 System.out.println("difference of time"+(int)diff);
		 
		 LeaveDAO ld = new LeaveDAO();
		 int var = 0;
		 try {
			 var = ld.AvailLeaves(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 System.out.println(var);
		 System.out.println((int)session.getAttribute("id"));
		 if(diff>var||diff<=0){
			 request.setAttribute("NotValid", "You can not take more than four leaves.");
			 request.getRequestDispatcher("/LeaveRequest.jsp").forward(request, response);
		 }
		 else{
			 long total = diff - var;
			 Model_LeaveRequest modleave = new Model_LeaveRequest();
			 modleave.setEmp_Id(id);
			 modleave.setStartDate(startdate);
			 modleave.setEndDate(enddate);
			 modleave.setReason(reason);
			 modleave.setApprove(0);
			 modleave.setLeaveDays((int)diff);
			 //modleave.setTotal_Leaves();
			 LeaveDAO leavedao = new LeaveDAO();
			 
			String msg;
			try {
				msg = leavedao.approveleave(modleave);
				if(msg.equals("suceess")){
					request.setAttribute("leave", "Your application for leave submitted successfully.");
					request.getRequestDispatcher("/LeaveRequest.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		/*	List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
			
			try {
			leavelist= leavedao.ShowLeaves();
			//System.out.println("Size Of List:"+inactivelist.size());
			session.setAttribute("leavelist", leavelist);
			response.sendRedirect("LeaveRequest.jsp");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			
		 }  */
	}

	
	
}
}