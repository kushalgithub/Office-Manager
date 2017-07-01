package Model;

public class Model_Registration {
	
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getPersonal_Email() {
		return Personal_Email;
	}
	public void setPersonal_Email(String personal_Email) {
		Personal_Email = personal_Email;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getWorksUnder() {
		return WorksUnder;
	}
	public void setWorksUnder(int worksUnder) {
		WorksUnder = worksUnder;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public int getIsActive() {
		return IsActive;
	}
	public void setIsActive(int isActive) {
		IsActive = isActive;
	}
	int Emp_Id;
	private String FirstName;
	private String LastName;
	private String Address;
	private String PhoneNumber;
	private String Personal_Email;
	private String Type;
	private int WorksUnder;
	private int Level;
	private int IsActive;
	private int AssignSalary;
	public int getAssignSalary() {
		return AssignSalary;
	}
	public void setAssignSalary(int assignSalary) {
		AssignSalary = assignSalary;
	}
	private int Total_Leaves;
	public int getTotal_Leaves() {
		return Total_Leaves;
	}
	public void setTotal_Leaves(int total_Leaves) {
		Total_Leaves = total_Leaves;
	}
	private String UserName;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	private String Password;

}
