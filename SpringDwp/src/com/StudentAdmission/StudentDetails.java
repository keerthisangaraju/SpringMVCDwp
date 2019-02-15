package com.StudentAdmission;

import java.util.Date;
import java.util.List;

public class StudentDetails
{
	private String studentname; /* properties name should match with Form name(AdmissionForm)*/
	private String studentgender;
	private String studentage;
	private Long studentmobile;
	private Date studentdob;
	private List<String> studentskills;
	
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentage() {
		return studentage;
	}
	public void setStudentage(String studentage) {
		this.studentage = studentage;
	}
	public Long getStudentmobile() {
		return studentmobile;
	}
	public void setStudentmobile(Long studentmobile) {
		this.studentmobile = studentmobile;
	}
	public Date getStudentdob() {
		return studentdob;
	}
	public void setStudentdob(Date studentdob) {
		this.studentdob = studentdob;
	}
	public List<String> getStudentskills() {
		return studentskills;
	}
	public void setStudentskills(List<String> studentskills) {
		this.studentskills = studentskills;
	}
	public String getStudentgender() {
		return studentgender;
	}
	public void setStudentgender(String studentgender) {
		this.studentgender = studentgender;
	}
	
}
