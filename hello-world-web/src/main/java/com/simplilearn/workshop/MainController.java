package com.simplilearn.workshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/showMessage.html")
public class MainController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView helloWorld(){
		ModelAndView model = new ModelAndView("showMessage"); // logical view name
		model.addObject("message","Spring MVC Web App With Annotations"); // model object
		return model; // logic view name + model	
	}

}
