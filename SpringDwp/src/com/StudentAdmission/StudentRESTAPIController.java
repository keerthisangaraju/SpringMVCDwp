package com.StudentAdmission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRESTAPIController
{

	@RequestMapping(value ="/students", method = RequestMethod.GET)
	public ArrayList<StudentDetails> getStudentsList()
	{
		StudentDetails student1 = new StudentDetails();
		student1.setStudentname("Keerthi");
		
		StudentDetails student2 = new StudentDetails();
		student2.setStudentname("Sridhar");
		
		StudentDetails student3 = new StudentDetails();
		student3.setStudentname("Aneesh");
		
		StudentDetails student4 = new StudentDetails();
		student4.setStudentname("Ashvith");
		
		ArrayList<StudentDetails> StudentList = new ArrayList<StudentDetails>();
		StudentList.add(student1);
		StudentList.add(student2);
		StudentList.add(student3);
		StudentList.add(student4);

		return StudentList;
			
	}
	
	@RequestMapping(value ="/students/{name}", method = RequestMethod.GET)
	public StudentDetails getStudent(@PathVariable("name") String studentname) throws SQLException
	{
		StudentDetails student = new StudentDetails();
		
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

		Statement stmt = conn.createStatement();
		    
		    ResultSet rs = stmt.executeQuery("select * from student where studentname ="+studentname+"");
		    
		    while(rs.next())
		    {
		    	String gender = rs.getString("gender");
		    	
		    	System.out.println("Cityname is "+gender);
		    	
				student.setStudentgender(gender);
		    }

		    return student;
	}
	
}
