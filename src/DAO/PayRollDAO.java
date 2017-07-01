package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectionUtil.DataConnection;
import Model.Model_LeaveRequest;
import Model.Model_PayRoll;

public class PayRollDAO {

	public String addSalary(Model_PayRoll modpay) {
		PreparedStatement ps = null;
		Connection con = null;
		try{
		con = DataConnection.DBConnection();
		//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
		String q = "INSERT INTO payroll(Emp_Id,Month,Year,Month_Salary) VALUES (?,?,?,?)";
		ps = con.prepareStatement(q);
		ps.setInt(1, modpay.getEmp_Id());
		ps.setString(2, modpay.getMonth());
		ps.setInt(3,modpay.getYear());
		ps.setInt(4,modpay.getMonth_Salary());
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

	public List<Model_PayRoll> BonusToAssign(int id) throws SQLException {
		
		Connection con = null;
		con = DataConnection.DBConnection();		
		
		List<Model_PayRoll> bonuslist=new ArrayList<Model_PayRoll>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM registration_tbl NATURAL JOIN payroll where WorksUnder='"+id+"'");

		while(rs.next()){
		Model_PayRoll modpay = new Model_PayRoll();
		modpay.setEmp_Id(rs.getInt("Emp_Id"));
		modpay.setPay_Id(rs.getInt("Pay_Id"));
		modpay.setLastName(rs.getString("LastName"));
		modpay.setFirstName(rs.getString("FirstName"));
		modpay.setYear(rs.getInt("Year"));
		modpay.setMonth_Salary(rs.getInt("Month_Salary"));
		modpay.setMonth(rs.getString("Month"));
		bonuslist.add(modpay);

		}


		return bonuslist;


		
	
	}

	public String addBonus(Model_PayRoll modpay) {
		PreparedStatement ps = null;
		Connection con = null;
		try{
		con = DataConnection.DBConnection();
		//PreparedStatement ps  = con.prepareStatement("INSERT INTO registration_tbl(FirstName,LastName,Address,PhoneNumber,Personal_Email,UserName) VALUES (?,?,?,?,?,?)");
		int pid = modpay.getPay_Id();
		int eid = modpay.getEmp_Id();
		String q = "update payroll set Bonus=? where Pay_Id='"+pid+"' and Emp_Id='"+eid+"';";
		ps = con.prepareStatement(q);
		ps.setInt(1, modpay.getBonus());
		
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

	public List<Model_PayRoll> paycheckList(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = DataConnection.DBConnection();		
		
		List<Model_PayRoll> checklist=new ArrayList<Model_PayRoll>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM payroll where Emp_Id='"+id+"'");

		while(rs.next()){
		Model_PayRoll modpay = new Model_PayRoll();
		//modpay.setEmp_Id(rs.getInt("Emp_Id"));
		modpay.setPay_Id(rs.getInt("Pay_Id"));
		//modpay.setLastName(rs.getString("LastName"));
		//modpay.setFirstName(rs.getString("FirstName"));
		modpay.setYear(rs.getInt("Year"));
		modpay.setMonth_Salary(rs.getInt("Month_Salary"));
		modpay.setMonth(rs.getString("Month"));
		modpay.setBonus(rs.getInt("Bonus"));
		checklist.add(modpay);

		}


		return checklist;
				
	}

}
