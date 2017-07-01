package Model;

public class Model_PayRoll {

	public int getPay_Id() {
		return Pay_Id;
	}
	public void setPay_Id(int pay_Id) {
		Pay_Id = pay_Id;
	}
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getMonth_Salary() {
		return Month_Salary;
	}
	public void setMonth_Salary(int month_Salary) {
		Month_Salary = month_Salary;
	}
	public int getBonus() {
		return Bonus;
	}
	public void setBonus(int bonus) {
		Bonus = bonus;
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
	int Pay_Id;
	int Emp_Id;
	String Month;
	int Year;
	int Month_Salary;
	int Bonus;
	String FirstName;
	String LastName;
		
}
