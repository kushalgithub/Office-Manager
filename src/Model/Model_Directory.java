package Model;

public class Model_Directory {
	
	int Dir_Id;
	int Emp_Id;
	String DirName;
	String DirType;
	String DirAccessList;
	public int getDir_Id() {
		return Dir_Id;
	}
	public void setDir_Id(int dir_Id) {
		Dir_Id = dir_Id;
	}
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	public String getDirName() {
		return DirName;
	}
	public void setDirName(String dirName) {
		DirName = dirName;
	}
	public String getDirType() {
		return DirType;
	}
	public void setDirType(String dirType) {
		DirType = dirType;
	}
	public String getDirAccessList() {
		return DirAccessList;
	}
	public void setDirAccessList(String dirAccessList) {
		DirAccessList = dirAccessList;
	}
}
