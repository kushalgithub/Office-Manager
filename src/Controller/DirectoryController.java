package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DirectoryDAO;
import Model.Model_Directory;

/**
 * Servlet implementation class DirectoryController
 */
@WebServlet("/DirectoryController")
public class DirectoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equals("dir")){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			request.getRequestDispatcher("/CreateDirectory.jsp").forward(request, response);
			
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

		
		/*String dirname = request.getParameter("DirectoryName");
		String dirtype = request.getParameter("DirectoryType");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id of:"+id);
		System.out.println("name of dir"+dirname);
		System.out.println("type of dir"+dirtype);
		Model_Directory moddir = new Model_Directory();
		
		
		String msg;
		DirectoryDAO dd = new DirectoryDAO();
		msg = dd.addDirectory(moddir);
		if(msg.equals("suceess")){
			request.setAttribute("success", "Successfully Created");
			request.getRequestDispatcher("/CreateDirectory.jsp").forward(request, response);
		}
		
		String hir=null;
		try {
			hir = dd.getHirarchy(id);
			System.out.println("Hirarchy of current id:"+hir);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hir);
		moddir.setDirName(dirname);
		moddir.setDirName(dirtype);
		moddir.setEmp_Id(id);
		moddir.setDirAccessList(hir);
*/			}

}
