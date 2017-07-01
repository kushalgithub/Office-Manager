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
 * Servlet implementation class CreateDirectory
 */
@WebServlet("/CreateDirectoryController")
public class CreateDirectoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDirectoryController() {
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
		
		String dirname = request.getParameter("DirectoryName");
		String dirtype = request.getParameter("DirectoryType");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id of:"+id);
		System.out.println("name of dir"+dirname);
		System.out.println("type of dir"+dirtype);
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
			
			moddir.setDirName(dirname);
			moddir.setDirType(dirtype);
			moddir.setEmp_Id(id);
			moddir.setDirAccessList(protectedlist);
			msg1=dd.addProtectedDirectory(moddir);
			
			
			if(msg1.equals("suceess")){
				request.setAttribute("dircreated", "Successfully Created");
				request.getRequestDispatcher("/manager.jsp").forward(request, response);
			}
			
			
			
			
		}
			
		else{
			
			moddir.setDirName(dirname);
			moddir.setDirType(dirtype);
			moddir.setEmp_Id(id);
			moddir.setDirAccessList(hir);
			
			msg = dd.addDirectory(moddir);

			if(msg.equals("suceess")){
				request.setAttribute("dircreated", "Successfully Created");
				request.getRequestDispatcher("/manager.jsp").forward(request, response);
			}
			
			
			
			
		}	
			
		
		System.out.println(moddir.getDirName());
		System.out.println(moddir.getDirType());
		System.out.println(moddir.getEmp_Id());
		System.out.println(moddir.getDirAccessList());
		
		}
		}

}
