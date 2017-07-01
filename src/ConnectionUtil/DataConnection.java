package ConnectionUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import Controller.*;
import DAO.*;
import Model.*;
public class DataConnection {
	
	static Connection con = null;
	 public static Connection DBConnection()
	    {
	        if (con != null) return con;
	        String url = "jdbc:mysql://localhost:3306/term_project?autoReconnect=true&useSSL=false";
			String uname = "root";
			String pass = "root";
	        return DBConnection(url, uname, pass);
	    }
	
	
	private static Connection DBConnection(String url,String uname,String pass)
	 {
	// Connection con = null;
	 //String url = "jdbc:mysql://localhost:3306/term_project?autoReconnect=true&useSSL=false";
	 //String username = "root";
	 //String password = "root";
	  
	 try
	 {
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");
	 } 
	 catch (ClassNotFoundException e)
	 {
	 e.printStackTrace();
	 }
	  con = DriverManager.getConnection(url, uname, pass);
	 } 
	 catch (Exception e) 
	 {
	 e.printStackTrace();
	 }
	 return con; 
	 }

}
