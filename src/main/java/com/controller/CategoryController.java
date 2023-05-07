package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category")
@Controller
public class CategoryController {

	// http://localhost:9999/category
	@GetMapping("/new")
	public String newCategory(HttpSession session, Model model) {

		// if login ? then go ahead
		// else login
		return "NewCategory";
	}

	// http://localhost:9999/category/all
	@GetMapping("/all")
	public String getAllCategory(Model model, HttpSession session) {
		// if login ? then go ahead
		// else login
		return "ListCategory";

	}
}
