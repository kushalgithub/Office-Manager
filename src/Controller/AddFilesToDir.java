package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.DirectoryDAO;
import Model.Model_DirectoryFiles;

/**
 * Servlet implementation class AddFilesToDir
 */
@WebServlet("/AddFilesToDir")
@MultipartConfig(maxFileSize = 428496729)

public class AddFilesToDir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFilesToDir() {
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
		int dirid = Integer.parseInt(request.getParameter("dirid"));
		System.out.println("id from controller"+dirid);
		int empid = (int) session.getAttribute("id");
		
		Part filePart = request.getPart("addfile");

		InputStream inputStream = null;
		String dirfilename =getFilename(filePart);
		String dirfiletype=filePart.getContentType();


		   
		   if (filePart != null) {
		           inputStream = filePart.getInputStream();
		   	
		}
		   
		   
		   
		   Model_DirectoryFiles moddir = new Model_DirectoryFiles();
		   
		   
		   moddir.setDir_Id(dirid);
		   moddir.setDirectoryFile_Name(dirfilename);
		   moddir.setDirectoryFile_Type(dirfiletype);
		   moddir.setDirectoryFile(inputStream);
		   moddir.setEmp_Id(empid);
		   
		   
		   
		   DirectoryDAO dd = new DirectoryDAO();

		  
		try {
			dd.addFileTodir(moddir);
			response.sendRedirect("DirectoryList.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("PublicList.jsp");
		
		   


		}
		private String getFilename(Part filePart) {
		final String partHeader = filePart.getHeader("content-disposition");
		   for (String content : filePart.getHeader("content-disposition").split(";")) {
		       if (content.trim().startsWith("filename")) {
		           return content.substring(
		                   content.indexOf('=') + 1).trim().replace("\"", "");
		       }
		   }

		// TODO Auto-generated method stub
		return null;
		}

	}


