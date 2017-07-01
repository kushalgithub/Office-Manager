package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeAccessController
 */
@WebServlet("/ChangeAccessController")
public class ChangeAccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession();
		
		if(flag.equals("pubchange")){
			
			int dirid = Integer.parseInt(request.getParameter("dirid"));
			//System.out.println("change dir id from controller"+dirid);
			String dirname = request.getParameter("dirname");
			//System.out.println("change dir name from controller"+dirname);
			String dirtype = request.getParameter("dirtype");	
			//System.out.println("change dir type from controller"+dirtype);
			session.setAttribute("diridchange", dirid);
			session.setAttribute("dirnamechange", dirname);
			session.setAttribute("dirtypechange", dirtype);
			response.sendRedirect("ChangePublicDetails.jsp");
			
		}		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
