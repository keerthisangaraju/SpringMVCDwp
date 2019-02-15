package com.StudentAdmission;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;


//import java.util.Map;   // Map

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;   // For RequestParam
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController 
{
		
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		/* To not bind studentmobile field from the AdmissionForm with the Student Properties */
		//binder.setDisallowedFields(new String[] {"studentmobile"});
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		binder.registerCustomEditor(Date.class, "studentdob", new CustomDateEditor(dateFormat,true));
	
	
	}
	
	@RequestMapping(value="/AdmissionForm", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm()
	{
		ModelAndView model = new ModelAndView("AdmissionForm");
		//model.addObject("Title", "Welcome to the Spring Framework");
		return model;
	}
	@ModelAttribute
	public void addCommonMesg(Model model)
	{
		model.addAttribute("Title", "Welcome to the Spring MVC");
	}
	
	/* With @ModelAttribute binding the requestParam to user-defined object properties */

	
	@RequestMapping(value="/submitAdmissionForm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") StudentDetails student, BindingResult result)
	{
		
		
		CustomPropertyEditor propEditor= new CustomPropertyEditor();
		
		String studentname = propEditor.CustomNameEditor(student.getStudentgender(),student.getStudentname());
		
		student.setStudentname(studentname);
		
		Long studentmobile = propEditor.CustomPhoneEditor(student.getStudentmobile());
		
		student.setStudentmobile(studentmobile);
		
		if(result.hasErrors())
		{
			
			FieldError errormsg = result.getFieldError();
			
			ModelAndView model = new ModelAndView("AdmissionForm");

			model.addObject("error", " You provided invalid data in the Field ===== "+errormsg.getField()+
								     " Your default Error Message is ===== "+errormsg.getDefaultMessage()+
								     " Error Code ==== "+errormsg.getCode()+
								     " Error on the Object ==== "+errormsg.getObjectName()
								     );
			
			return model;
		}
		
		// @ModelAttribute("student") it lets you use this student object properties in the AdmissionSuccessModelAttribute jsp file
		ModelAndView model = new ModelAndView("AdmissionSuccessModelAttribute");
		//model.addObject("Title", "Welcome to the Spring MVC");
		model.addObject("msg", "Admission details provided by you");
		return model;
	}
	
	
	
	
	/*  Using @RequestParam for each Parameter */
	/*@RequestMapping(value="/submitAdmissionForm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentname", defaultValue="ABC") String name,
											@RequestParam("studentage") String age)
	{
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Admission details provided by you");
		model.addObject("msg1", "Name is"+name+"age is"+age);
		return model;
	}
	*/
	
	/* Using @RequestParam with Map to get all the Parameters in key-value pair */
	
	/*@RequestMapping(value="/submitAdmissionForm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> reqParam)
	{
		String name = reqParam.get("studentname");
		String age = reqParam.get("studentage");

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Admission details provided by you");
		model.addObject("msg1", "Name is"+name+"age is"+age);
		return model;
	}
	*/
	
	/* Without @ModelAttribute to bind the request parameters with the user defined object */ 
	
	/*@RequestMapping(value="/submitAdmissionForm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> reqParam)
	{
		String name = reqParam.get("studentname");
		String age = reqParam.get("studentage");
		
		StudentDetails student = new StudentDetails();
		student.setStudentname(name);
		student.setStudentage(age);
		
		ModelAndView model = new ModelAndView("AdmissionSuccessModelAttribute");
		model.addObject("msg", "Admission details provided by you");
		model.addObject("msg1", "Name is"+name+"age is"+age);
		model.addObject("student1", student);
		return model;
	}*/
	
		
}
