package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectionUtil.DataConnection;
import Model.Model_Directory;
import Model.Model_DirectoryFiles;
import Model.Model_DirectoryFiles_Retrieve;
import Model.Model_LeaveRequest;
import Model.Model_PayRoll;
import Model.Model_Registration;

public class DirectoryDAO {

	public String addDirectory(Model_Directory moddir) {
		PreparedStatement ps = null;
		Connection con = null;
		try{
		con = DataConnection.DBConnection();
		//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
		String q = "INSERT INTO directory_tbl(Emp_Id,DirName,DirType,DirAccessList) VALUES (?,?,?,?)";
		ps = con.prepareStatement(q);
		ps.setInt(1, moddir.getEmp_Id());
		ps.setString(2, moddir.getDirName());
		ps.setString(3, moddir.getDirType());
		ps.setString(4, moddir.getDirAccessList());
		
		int i= ps.executeUpdate();
		System.out.println("Data inserted " +i);
		if (i!=0){ //Just to ensure data has been inserted into the database
		return "suceess";
		}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return "Not suceeded!";

	}

	public String getHirarchy(int id) throws SQLException {
		Connection con = null;
		con = DataConnection.DBConnection();		
		
		//List<Model_PayRoll> bonuslist=new ArrayList<Model_PayRoll>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM registration_tbl where Emp_Id='"+id+"'");
		String hir=null;
		while(rs.next()){
		 hir = rs.getString("WorksUnderList");
		}


		return hir;

	}

	public List<Model_Directory> getPublicList() throws SQLException {
		
		List<Model_Directory> dirlist=new ArrayList<Model_Directory>();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from directory_tbl where DirType='Public'");

		while(rs.next()){
		Model_Directory moddir = new Model_Directory();
		moddir.setDir_Id(rs.getInt("Dir_Id"));
		moddir.setDirName(rs.getString("DirName"));
		moddir.setDirType(rs.getString("DirType"));
		moddir.setEmp_Id(rs.getInt("Emp_Id"));
		moddir.setDirAccessList(rs.getString("DirAccessList"));
		dirlist.add(moddir);

		}

		return dirlist;
		
	}

	
	public List<Model_Directory> getPrivateList(String id) throws SQLException {
		List<Model_Directory> dirlist=new ArrayList<Model_Directory>();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		System.out.println("from dao:"+id);
		String sql = "select * from directory_tbl where DirType='Private' and DirAccessList like '%"+id+"%'";
		System.out.println(sql);
		ResultSet rs=st.executeQuery(sql);

		while(rs.next()){
		Model_Directory moddir = new Model_Directory();
		moddir.setDir_Id(rs.getInt("Dir_Id"));
		moddir.setDirName(rs.getString("DirName"));
		moddir.setDirType(rs.getString("DirType"));
		moddir.setEmp_Id(rs.getInt("Emp_Id"));
		moddir.setDirAccessList(rs.getString("DirAccessList"));
		dirlist.add(moddir);

		}

		return dirlist;

	}

	public List<Model_Directory> getProtectedList(String idlike) throws SQLException {
		List<Model_Directory> dirlist=new ArrayList<Model_Directory>();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		System.out.println("from dao:"+idlike);
		String sql = "select * from directory_tbl where DirType='Protected' and DirAccessList like '%"+idlike+"%'";
		System.out.println(sql);
		ResultSet rs=st.executeQuery(sql);

		while(rs.next()){
		Model_Directory moddir = new Model_Directory();
		moddir.setDir_Id(rs.getInt("Dir_Id"));
		moddir.setDirName(rs.getString("DirName"));
		moddir.setDirType(rs.getString("DirType"));
		moddir.setEmp_Id(rs.getInt("Emp_Id"));
		moddir.setDirAccessList(rs.getString("DirAccessList"));
		dirlist.add(moddir);

		}

		return dirlist;

	}
	
	public List<Model_Directory> getDefaultList(String idlike) throws SQLException {
		List<Model_Directory> dirlist=new ArrayList<Model_Directory>();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		System.out.println("from dao:"+idlike);
		String sql = "select * from directory_tbl where DirType='Default' and DirAccessList like '%"+idlike+"%'";
		System.out.println(sql);
		ResultSet rs=st.executeQuery(sql);

		while(rs.next()){
		Model_Directory moddir = new Model_Directory();
		moddir.setDir_Id(rs.getInt("Dir_Id"));
		moddir.setDirName(rs.getString("DirName"));
		moddir.setDirType(rs.getString("DirType"));
		moddir.setEmp_Id(rs.getInt("Emp_Id"));
		moddir.setDirAccessList(rs.getString("DirAccessList"));
		dirlist.add(moddir);

		}

		return dirlist;

	}
	
	
	
	public void addFileTodir(Model_DirectoryFiles moddir) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement ps = null;
		Connection con = null;
		
		con = DataConnection.DBConnection();
		//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
		String q = "INSERT INTO directory_files(Emp_Id,Dir_Id,DirectoryFile_Name,DirectoryFile,DirectoryFile_Type) VALUES (?,?,?,?,?)";
		try {
		ps = con.prepareStatement(q);
		ps.setInt(1, moddir.getEmp_Id());
		ps.setInt(2, moddir.getDir_Id());
		ps.setString(3, moddir.getDirectoryFile_Name());
		ps.setBlob(4, moddir.getDirectoryFile());
		ps.setString(5, moddir.getDirectoryFile_Type());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}

	public List<Model_DirectoryFiles_Retrieve> getfileView(Model_DirectoryFiles_Retrieve modret) throws SQLException {
		List<Model_DirectoryFiles_Retrieve> viewfile = new ArrayList<Model_DirectoryFiles_Retrieve>();
		
		Connection con = null;
		con = DataConnection.DBConnection();		
		
		//List<Model_PayRoll> bonuslist=new ArrayList<Model_PayRoll>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM directory_files where Dir_Id='"+modret.getDir_Id()+"'");
		String hir=null;
		while(rs.next()){
			Model_DirectoryFiles_Retrieve modretfile = new Model_DirectoryFiles_Retrieve();
			modretfile.setDirectoryFile_Id(rs.getInt("DirectoryFile_Id"));
			modretfile.setDirectoryFile_Name(rs.getString("DirectoryFile_Name"));
			modretfile.setDirectoryFile_Type(rs.getString("DirectoryFile_Type"));
		 viewfile.add(modretfile);
		}


		return viewfile;

		
		
		// TODO Auto-generated method stub
	}

	public static  Model_DirectoryFiles_Retrieve getViewFile(int viewid)throws ClassNotFoundException, SQLException
	{
		Model_DirectoryFiles_Retrieve modret = new Model_DirectoryFiles_Retrieve();

		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
	//System.out.println(viewid);
	ResultSet rs = st.executeQuery("select * from directory_files where DirectoryFile_Id ='"+viewid+"'");

	while(rs.next()){
		modret.setDirectoryFile_Id((rs.getInt("DirectoryFile_Id")));
		modret.setDirectoryFile(rs.getBlob("DirectoryFile"));
		modret.setDirectoryFile_Name(rs.getString("DirectoryFile_Name"));
	}
	st.close();




	return modret;
	}

	public String getUnderList(String underid) throws SQLException {
		//List<Model_Registration> underlist = new ArrayList<Model_Registration>();
		Model_Registration modreg = new Model_Registration();

		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
	//System.out.println(viewid);
		String q = "select * from registration_tbl where WorksUnderList like '%"+underid+"%'";
		System.out.println(q);
	ResultSet rs = st.executeQuery(q);
	String list=null;
	while(rs.next()){
		//modreg.setEmp_Id((rs.getInt("Emp_Id")));
	 list = list+ "<"+ rs.getInt("Emp_Id") + ">";
	}
	st.close();
	System.out.println();
	System.out.println("list from under dao"+list);


	return list;

		
		
		// TODO Auto-generated method stub
		//return null;
	}

	public String addProtectedDirectory(Model_Directory moddir) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement ps = null;
		Connection con = null;
		try{
		con = DataConnection.DBConnection();
		//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
		String q = "INSERT INTO directory_tbl(Emp_Id,DirName,DirType,DirAccessList) VALUES (?,?,?,?)";
		ps = con.prepareStatement(q);
		ps.setInt(1, moddir.getEmp_Id());
		ps.setString(2, moddir.getDirName());
		ps.setString(3, moddir.getDirType());
		ps.setString(4, moddir.getDirAccessList());
		
		int i= ps.executeUpdate();
		System.out.println("Data inserted " +i);
		if (i!=0){ //Just to ensure data has been inserted into the database
		return "suceess";
		}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return "Not suceeded!";

	}

	public String getDirectoryHirarchy(int dirid) throws SQLException {
		
		
		Connection con = null;
		con = DataConnection.DBConnection();		
		
		//List<Model_PayRoll> bonuslist=new ArrayList<Model_PayRoll>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM directory_tbl where Dir_Id='"+dirid+"'");
		String hir=null;
		while(rs.next()){
		 hir = rs.getString("DirAccessList");
		}

		System.out.println("from dao hir"+hir);
		return hir;

		
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	public void addAnotherEmployee(String anotherlist,int dirid) throws SQLException {
		
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		
		st.executeUpdate("UPDATE directory_tbl SET DirAccessList='"+anotherlist+"' WHERE Dir_Id = '"+dirid+"'");
		
		//return "success";

		
		
		// TODO Auto-generated method stub
		
	}

	public List<Model_Directory> getPublicListforChange(int id) throws SQLException {
		List<Model_Directory> dirlist=new ArrayList<Model_Directory>();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from directory_tbl where DirType='Public' and Emp_Id='"+id+"'");

		while(rs.next()){
		Model_Directory moddir = new Model_Directory();
		moddir.setDir_Id(rs.getInt("Dir_Id"));
		moddir.setDirName(rs.getString("DirName"));
		moddir.setDirType(rs.getString("DirType"));
		moddir.setEmp_Id(rs.getInt("Emp_Id"));
		moddir.setDirAccessList(rs.getString("DirAccessList"));
		dirlist.add(moddir);

		}

		return dirlist;

		
		
		
		// TODO Auto-generated method stub
		//return null;
	}

	public String updatePublicDir(String protectedlist, String dirtype, int dirid) throws SQLException {
		
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		
		st.executeUpdate("UPDATE directory_tbl SET DirAccessList='"+protectedlist+"',DirType='"+dirtype+"' WHERE Dir_Id = '"+dirid+"'");
		// TODO Auto-generated method stub
		return "suceess";
	}

	

	
}