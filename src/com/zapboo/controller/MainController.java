package com.zapboo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zapboo.service.IZapBooService;

@Controller
public class MainController {

	@Autowired
	private IZapBooService objZapBooService;
	
	@RequestMapping(value="SearchBooks", method={RequestMethod.GET, RequestMethod.POST})
	public String searchBooks(Model model,HttpServletRequest request){
		
		ArrayList booksList = new ArrayList();
		
		model.addAttribute("booksList", booksList);
		
		return "home";
	}
	
}
