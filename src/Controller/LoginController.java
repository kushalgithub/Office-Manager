package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import DAO.RegistrationDAO;
import Model.Model_Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		HttpSession session=request.getSession();
		
		
		if(username!=null && password!=null){
			Model_Login modlog = new Model_Login();
			modlog.setUserName(username);
			modlog.setPassword(password);
			
			
			LoginDAO lgdao = new LoginDAO();
			String msg = lgdao.Login(modlog);
				if(msg.equals("suceess")){
					session.setAttribute("id",modlog.getEmp_Id());
					session.setAttribute("emptype", modlog.getType());
					if(modlog.getType().equals("manager")){
						request.getRequestDispatcher("/manager.jsp").forward(request, response);
					}
					
					else if(modlog.getType().equals("admin")){
						request.getRequestDispatcher("/admin.jsp").forward(request, response);
					}
					
					else{
						request.getRequestDispatcher("/employee.jsp").forward(request, response);
					}
					
					
			}
			
			else{
				request.setAttribute("LoginError", "You are not allowed to login");
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			}
		}
	}

}
