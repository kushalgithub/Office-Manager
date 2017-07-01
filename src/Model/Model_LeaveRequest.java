package Model;

public class Model_LeaveRequest {
	int Emp_Id;
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public int getApprove() {
		return Approve;
	}
	public void setApprove(int approve) {
		Approve = approve;
	}
	String StartDate;
	String EndDate;
	String Reason;
	int Approve;
	int Request_Id;
	int Total_Leaves;
	int LeaveDays;
	public int getLeaveDays() {
		return LeaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		LeaveDays = leaveDays;
	}
	public int getTotal_Leaves() {
		return Total_Leaves;
	}
	public int setTotal_Leaves(int total_Leaves) {
		return Total_Leaves = total_Leaves;
	}
	public int getRequest_Id() {
		return Request_Id;
	}
	public void setRequest_Id(int request_Id) {
		Request_Id = request_Id;
	}
	String FirstName;
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
	String LastName;
}
