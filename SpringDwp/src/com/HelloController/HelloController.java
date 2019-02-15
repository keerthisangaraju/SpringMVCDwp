package com.HelloController;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
{
  /* @RequestMapping("/hello/{name}/{country}")
   public ModelAndView printHello(@PathVariable("name") String name, @PathVariable("country") String country ) 
   {
	   ModelAndView model = new ModelAndView("hellopage");
	   model.addObject("message", "Hello Spring MVC Framework! "+name+" You are from "+country);
      return model;
   }*/
   
   @RequestMapping("/welcome/{username}/{countryname}/{agenum}")
   public ModelAndView printwelcome(@PathVariable Map<String,String> pathVars) 
   {
	   
	   String name = pathVars.get("username");
	   String country = pathVars.get("countryname");
	   String age = pathVars.get("agenum");
	   ModelAndView model = new ModelAndView("hellopage");
	   model.addObject("message", "Welcome Spring MVC Framework! "+name+" From "+country+" age "+age);
       return model;
   }
   
}

