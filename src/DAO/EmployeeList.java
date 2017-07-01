package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import ConnectionUtil.DataConnection;
import Model.Model_LeaveRequest;
import Model.Model_PayRoll;
import Model.Model_Registration;

public class EmployeeList {
	
	public List<Model_Registration> InactiveList() throws SQLException{
		List<Model_Registration> inactivelist=new ArrayList<Model_Registration>();
		//DbConnection db = new DbConnection();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from registration_tbl where isActive ='0' and Type!='admin'");

		while(rs.next()){
		Model_Registration modreg = new Model_Registration();
		modreg.setFirstName(rs.getString("FirstName"));
		modreg.setLastName(rs.getString("LastName"));
		modreg.setPersonal_Email(rs.getString("Personal_Email"));
		modreg.setIsActive(rs.getInt("IsActive"));
		modreg.setAddress(rs.getString("Address"));
		modreg.setPhoneNumber(rs.getString("PhoneNumber"));
		modreg.setWorksUnder(rs.getInt("WorksUnder"));
		modreg.setUserName(rs.getString("UserName"));
		modreg.setEmp_Id(rs.getInt("Emp_Id"));
		inactivelist.add(modreg);
System.out.println(modreg.getFirstName());
		}

		return inactivelist;
		}

	public static List<Model_Registration> ActiveList() throws SQLException{
		List<Model_Registration> inactivelist=new ArrayList<Model_Registration>();
		//DbConnection db = new DbConnection();
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from registration_tbl where isActive ='1' ");

		while(rs.next()){
		Model_Registration modreg = new Model_Registration();
		modreg.setFirstName(rs.getString("FirstName"));
		modreg.setLastName(rs.getString("LastName"));
		modreg.setPersonal_Email(rs.getString("Personal_Email"));
		modreg.setIsActive(rs.getInt("IsActive"));
		modreg.setAddress(rs.getString("Address"));
		modreg.setPhoneNumber(rs.getString("PhoneNumber"));
		modreg.setWorksUnder(rs.getInt("WorksUnder"));
		modreg.setUserName(rs.getString("UserName"));
		modreg.setType(rs.getString("Type"));
		modreg.setEmp_Id(rs.getInt("Emp_Id"));
		inactivelist.add(modreg);

		}


		return inactivelist;

		}

	public void assignmanager(String id, String managerid) throws SQLException {
		
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		int manid = Integer.parseInt(managerid);
		//System.out.println(manid);
		String abovemanagers = null;
		ResultSet rs=st.executeQuery("select * from registration_tbl where Emp_Id ='"+manid+"'");
		while(rs.next()){
		abovemanagers = rs.getString("WorksUnderList");
		abovemanagers=abovemanagers +"<" +id+ ">";
		}

		st.executeUpdate("UPDATE registration_tbl SET IsActive = '1', WorksUnder='"+manid+"',WorksUnderList='"+abovemanagers+"' WHERE Emp_Id = '"+id+"'");
		st.executeUpdate("UPDATE registration_tbl SET Type = 'manager' WHERE Emp_Id = '"+manid+"'");
		System.out.println("successfully changed");

		
	}

	public String AssignSalary(int id, int salary) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		
		st.executeUpdate("UPDATE registration_tbl SET AssignSalary='"+salary+"' WHERE Emp_Id = '"+id+"'");
		
		return "success";
	}
	
	
	public int TotalSalary(int id) throws SQLException{
		Connection con = null;
		con = DataConnection.DBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from registration_tbl where Emp_Id='"+id+"' ");
		int salary = 0;
		while(rs.next()){
		Model_PayRoll modpay = new Model_PayRoll();
		int totalsalary = rs.getInt("AssignSalary");
		salary = totalsalary/12;
		modpay.setMonth_Salary(salary);
		}


	return salary;
	}

}
