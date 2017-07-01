package Model;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;

public class Model_DirectoryFiles_Retrieve implements Serializable{
	
	

	int DirectoryFile_Id;
	int Emp_Id;
	int Dir_Id;
	String DirectoryFile_Name;
	String DirectoryFile_Type;
	Blob DirectoryFile;
	
	
	public Blob getDirectoryFile() {
		return DirectoryFile;
	}
	public void setDirectoryFile(Blob directoryFile) {
		DirectoryFile = directoryFile;
	}
	public int getDirectoryFile_Id() {
		return DirectoryFile_Id;
	}
	public void setDirectoryFile_Id(int directoryFile_Id) {
		DirectoryFile_Id = directoryFile_Id;
	}
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	public int getDir_Id() {
		return Dir_Id;
	}
	public void setDir_Id(int dir_Id) {
		Dir_Id = dir_Id;
	}
	public String getDirectoryFile_Name() {
		return DirectoryFile_Name;
	}
	public void setDirectoryFile_Name(String directoryFile_Name) {
		DirectoryFile_Name = directoryFile_Name;
	}
	public String getDirectoryFile_Type() {
		return DirectoryFile_Type;
	}
	public void setDirectoryFile_Type(String directoryFile_Type) {
		DirectoryFile_Type = directoryFile_Type;
	}
	
}
