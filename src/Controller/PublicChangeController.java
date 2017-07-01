package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DirectoryDAO;
import Model.Model_Directory;

/**
 * Servlet implementation class PublicChangeController
 */
@WebServlet("/PublicChangeController")
public class PublicChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicChangeController() {
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
		doGet(request, response);
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		
		String dirname = request.getParameter("DirectoryName");
		String dirtype = request.getParameter("DirectoryType");
		int dirid = Integer.parseInt(request.getParameter("id"));
		System.out.println("public change controller id of:"+dirid);
		System.out.println("public change controller name of dir"+dirname);
		System.out.println("public change controller type of dir"+dirtype);
		if(dirname!=null||dirtype!=null){
		Model_Directory moddir = new Model_Directory();
		DirectoryDAO dd = new DirectoryDAO();
		
		/*String msg;
		DirectoryDAO dd = new DirectoryDAO();
		msg = dd.addDirectory(moddir);
		if(msg.equals("suceess")){
			request.setAttribute("success", "Successfully Created");
			request.getRequestDispatcher("/CreateDirectory.jsp").forward(request, response);
		}
		*/
		String underid ="<" +Integer.toString(id)+">";
		
		
		String hir=null;
		try {
			hir = dd.getHirarchy(id);
			//System.out.println("Hirarchy of current id:"+hir);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String underlist=null;
		
		try {
			underlist = dd.getUnderList(underid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String protectedlist = hir + underlist;
		//System.out.println("list from controller for under:"+underlist);
		System.out.println(hir);
//		moddir.setDirName(dirname);
//		moddir.setDirType(dirtype);
//		moddir.setEmp_Id(id);
//		moddir.setDirAccessList(hir);
//		
		String msg = null;
		String msg1=null;

		
		if(dirtype.equals("Protected")||dirtype.equals("Default")){		
			
			/*moddir.setDirName(dirname);
			moddir.setDirType(dirtype);
			moddir.setEmp_Id(id);
			moddir.setDirAccessList(protectedlist);
*/			try {
	msg1=dd.updatePublicDir(protectedlist,dirtype,dirid);
	request.setAttribute("changed", "Successfully Changed the permission of public directory.");
	request.getRequestDispatcher("/manager.jsp").forward(request, response);

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
			
			
			//if(msg1.equals("suceess")){
				//request.setAttribute("changed", "Successfully Changed the permission of public directory.");
				//request.getRequestDispatcher("/manager.jsp").forward(request, response);
			//}
			
			
			
			
		}
			
		else{
			
			try {
				msg1=dd.updatePublicDir(hir,dirtype,dirid);
				request.setAttribute("changed", "Successfully Changed the permission of public directory.");
				request.getRequestDispatcher("/manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}	

		
		
		
		
		
		
	}

}
}
