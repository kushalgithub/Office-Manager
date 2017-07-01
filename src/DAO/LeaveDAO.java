package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import ConnectionUtil.DataConnection;
import Model.Model_LeaveRequest;
import Model.Model_Registration;

public class LeaveDAO {
	
	public String approveleave(Model_LeaveRequest modleave) throws SQLException{
	PreparedStatement ps = null;
	Connection con = null;
	
	con = DataConnection.DBConnection();
	//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
	String q = "INSERT INTO leaverequest_tbl(Emp_Id,StartDate,EndDate,Reason,LeaveDays,Approve) VALUES (?,?,?,?,?,0)";
	ps = con.prepareStatement(q);
	ps.setInt(1, modleave.getEmp_Id());
	ps.setString(2, modleave.getStartDate());
	ps.setString(3, modleave.getEndDate());
	ps.setString(4, modleave.getReason());
	ps.setInt(5, modleave.getLeaveDays());
	int i= ps.executeUpdate();
	
	if (i!=0){ //Just to ensure data has been inserted into the database
	return "suceess";
	}
	
		return "not successfull";	
	}
	
	public int AvailLeaves(int id) throws SQLException{
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from registration_tbl where Emp_Id='"+id+"' ");
		int totalleaves = 0;
		while(rs.next()){
		Model_LeaveRequest modleaves = new Model_LeaveRequest();
		totalleaves= modleaves.setTotal_Leaves(rs.getInt("Total_Leaves"));
		
		}


		return totalleaves;

		}
	
	
	public static List<Model_LeaveRequest> ShowLeaves(int id) throws SQLException{
		List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
		//DbConnection db = new DbConnection();
		//Model_LeaveRequest modleave = new Model_LeaveRequest();
		//int empid = modleave.getEmp_Id();
		//System.out.println("id from the dao"+empid);
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from leaverequest_tbl where Emp_Id='"+id+"' ");

		while(rs.next()){
		Model_LeaveRequest modleaves = new Model_LeaveRequest();
		modleaves.setApprove(rs.getInt("Approve"));
		modleaves.setStartDate(rs.getString("StartDate"));
		modleaves.setEndDate(rs.getString("EndDate"));
		modleaves.setReason(rs.getString("Reason"));
		modleaves.setLeaveDays(rs.getInt("LeaveDays"));
		leavelist.add(modleaves);

		}


		return leavelist;

		}

	public static List<Model_LeaveRequest> ShowLeavesToManager(int id) throws SQLException{
		List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
		//DbConnection db = new DbConnection();
		//Model_LeaveRequest modleave = new Model_LeaveRequest();
		//int empid = modleave.getEmp_Id();
		//System.out.println("id from the dao"+empid);
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM registration_tbl NATURAL JOIN leaverequest_tbl where WorksUnder='"+id+"' and ActionTaken IS NULL ");

		while(rs.next()){
		Model_LeaveRequest modleaves = new Model_LeaveRequest();
		modleaves.setEmp_Id(rs.getInt("Emp_Id"));
		modleaves.setFirstName(rs.getString("FirstName"));
		modleaves.setLastName(rs.getString("LastName"));
		modleaves.setApprove(rs.getInt("Approve"));
		modleaves.setApprove(rs.getInt("Approve"));
		modleaves.setStartDate(rs.getString("StartDate"));
		modleaves.setEndDate(rs.getString("EndDate"));
		modleaves.setReason(rs.getString("Reason"));
		modleaves.setRequest_Id(rs.getInt("Request_Id"));
		modleaves.setLeaveDays(rs.getInt("LeaveDays"));
		leavelist.add(modleaves);

		}


		return leavelist;

		}


	public List<Model_LeaveRequest> ApproveLeaves(int id) throws SQLException {
		
		
		
		Connection con = null;
		con = DataConnection.DBConnection();
		
		Statement st1=con.createStatement();
		//int id = Integer.parseInt(id);
		//System.out.println(manid);
		st1.executeUpdate("UPDATE leaverequest_tbl SET Approve = '1',ActionTaken='1' WHERE Request_Id = '"+id+"'");
		//st.executeUpdate("UPDATE registration_tbl SET Type = 'manager' WHERE Emp_Id = '"+manid+"'");
		System.out.println("successfully changed");

		
		
		List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM registration_tbl NATURAL JOIN leaverequest_tbl where WorksUnder='"+id+"' and ActionTaken IS NULL ");

		while(rs.next()){
		Model_LeaveRequest modleaves = new Model_LeaveRequest();
		modleaves.setEmp_Id(rs.getInt("Emp_Id"));
		modleaves.setFirstName(rs.getString("FirstName"));
		modleaves.setLastName(rs.getString("LastName"));
		modleaves.setApprove(rs.getInt("Approve"));
		modleaves.setApprove(rs.getInt("Approve"));
		modleaves.setStartDate(rs.getString("StartDate"));
		modleaves.setEndDate(rs.getString("EndDate"));
		modleaves.setReason(rs.getString("Reason"));
		leavelist.add(modleaves);

		}


		return leavelist;

		
		
/*		Statement st=con.createStatement();
		//int id = Integer.parseInt(id);
		//System.out.println(manid);
		st.executeUpdate("UPDATE leaverequest_tbl SET Approve = '1',ActionTaken='1' WHERE Emp_Id = '"+id+"'");
		//st.executeUpdate("UPDATE registration_tbl SET Type = 'manager' WHERE Emp_Id = '"+manid+"'");
		System.out.println("successfully changed");

*/
		
	}


	public List<Model_LeaveRequest> DiscardLeaves(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st1=con.createStatement();
		st1.executeUpdate("UPDATE leaverequest_tbl SET Approve = '0',ActionTaken='1' WHERE Request_Id = '"+id+"'");

		System.out.println("successfully changed");
		
		
		List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM registration_tbl NATURAL JOIN leaverequest_tbl where WorksUnder='"+id+"' and ActionTaken IS NULL ");

		while(rs.next()){
		Model_LeaveRequest modleaves = new Model_LeaveRequest();
		modleaves.setEmp_Id(rs.getInt("Emp_Id"));
		modleaves.setFirstName(rs.getString("FirstName"));
		modleaves.setLastName(rs.getString("LastName"));
		modleaves.setApprove(rs.getInt("Approve"));
		modleaves.setApprove(rs.getInt("Approve"));
		modleaves.setStartDate(rs.getString("StartDate"));
		modleaves.setEndDate(rs.getString("EndDate"));
		modleaves.setReason(rs.getString("Reason"));
		leavelist.add(modleaves);

		}


		return leavelist;

		
	}

	public void updatetotalleaves(int id, int difference) throws SQLException {
		//public String approveleave(Model_LeaveRequest modleave) throws SQLException{
			PreparedStatement ps = null;
			Connection con = null;
			con = DataConnection.DBConnection();
			System.out.println("DAO difference:"+difference);
		
		// TODO Auto-generated method stub
		String q = "UPDATE registration_tbl SET Total_Leaves='"+difference+"' WHERE Emp_Id = '"+id+"'";
		ps = con.prepareStatement(q);
		int i= ps.executeUpdate();

		
		
	}

	public void forwardLeaves(int empid) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		con = DataConnection.DBConnection();
		//System.out.println("DAO difference:"+difference);
	
	// TODO Auto-generated method stub
	String q = "UPDATE registration_tbl SET Total_Leaves=Total_Leaves+4 WHERE Emp_Id = '"+empid+"'";
	ps = con.prepareStatement(q);
	int i= ps.executeUpdate();

	}

		
	
}
