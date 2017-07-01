package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectionUtil.DataConnection;
import Model.Model_Login;
import Model.Model_Registration;

public class LoginDAO {
	
	public String Login(Model_Login modlog){
		//DataConnection dbcon = new DataConnection();
		PreparedStatement ps = null;
		Connection con = null;
		try{
		con = DataConnection.DBConnection();
		//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
		String q = "select * from registration_tbl where UserName=? and Password=?";
		ps = con.prepareStatement(q);
		ps.setString(1, modlog.getUserName());
		ps.setString(2, modlog.getPassword());
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String username = rs.getString("UserName");
			String password = rs.getString("Password");
			String type = rs.getString("Type");
			int empid = rs.getInt("Emp_Id");
			int active = rs.getInt("IsActive");
		//System.out.println("username of:"+username);
		//System.out.println("pass of:"+password);
		//System.out.println("emp_id"+empid);
		//System.out.println("active:"+active);
		
		if (username.equals(modlog.getUserName())&& password.equals(modlog.getPassword())&&active!=0){
			modlog.setEmp_Id(empid);
			modlog.setType(type);
		return "suceess";
		}
		else{
			return "username and password does not match!";
		}
		
		/*endwhile*/}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return "Not suceeded!";
		
		

		}


}
