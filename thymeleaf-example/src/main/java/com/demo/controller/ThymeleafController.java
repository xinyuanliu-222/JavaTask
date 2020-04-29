package com.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;

@Controller
public class ThymeleafController {

	@RequestMapping("/helloworld")
	public String hello() {
		return "home"; // Name of Thymeleaf template
	}

	@RequestMapping("/senddata")
	public ModelAndView sendDataToTemplate() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("sampletext", "This is a demo data to template");

		return mav;
	}

	@RequestMapping("/sendobject")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("John");
		student.setScore(99);
		mav.addObject("student", student);
		
		return mav;
	}

	@RequestMapping("/sendobjects")
	public ModelAndView sendObjects() {

		ModelAndView mav = new ModelAndView("students");

		Student student1 = new Student();
		student1.setName("Anna");
		student1.setScore(99);

		Student student2 = new Student();
		student2.setName("Bella");
		student2.setScore(92);

		List<Student> students = Arrays.asList(student1, student2);

		mav.addObject("students", students);
		return mav;

	}

	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String loadStudent(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String processStudent(@ModelAttribute Student student) {
		return "result";
	}
}
