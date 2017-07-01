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
import Model.Model_Registration;
import  ConnectionUtil.*;

public class RegistrationDAO {
	
	public String registerEmp(Model_Registration modreg){
	//DataConnection dbcon = new DataConnection();
	PreparedStatement ps = null;
	Connection con = null;
	try{
	con = DataConnection.DBConnection();
	//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
	String q = "INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName,Password,IsActive,Type,Total_Leaves) VALUES (?,?,?,?,?,?,?,0,'employee',4)";
	ps = con.prepareStatement(q);
	ps.setString(1, modreg.getFirstName());
	ps.setString(2, modreg.getLastName());
	ps.setString(3, modreg.getAddress());
	ps.setString(4, modreg.getPhoneNumber());
	ps.setString(5, modreg.getPersonal_Email());
	ps.setString(6, modreg.getUserName());
	ps.setString(7, modreg.getPassword());
	

	int i= ps.executeUpdate();
	
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

	public List<Model_Registration> getAllActiveEmployees() throws SQLException {
		
		
		List<Model_Registration> listreg = new ArrayList<Model_Registration>();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from registration_tbl where IsActive='1'");

		while(rs.next()){
		Model_Registration modreg = new Model_Registration();
		modreg.setEmp_Id(rs.getInt("Emp_Id"));
		modreg.setUserName(rs.getString("UserName"));
		listreg.add(modreg);

		}

		return listreg;

		// TODO Auto-generated method stub
		//return null;
	}

	public String CheckDuplicateUser(Model_Registration modreg) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from registration_tbl where UserName='"+modreg.getUserName()+"'");
		String valid="usernameAvilable";
		while(rs.next()){
			valid = "Has already same username";
		}

		return valid;

		
		
		
		
	}
}
	
