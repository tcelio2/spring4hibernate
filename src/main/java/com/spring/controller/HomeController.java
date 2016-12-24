package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Aluno;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String index(){
		
		return "index";
		
	}
	@RequestMapping(value="/salvarAluno")
	public ModelAndView formulario(Aluno aluno){
		ModelAndView modelAndView = new ModelAndView("form");
		return modelAndView;
	}
}
