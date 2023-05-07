package com.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;

@Controller
public class SessionController {

	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

//	@RequestMapping(value = "/saveprofile",method = RequestMethod.POST)
	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file, Model model) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		String masterPath = "E:\\Tejas Shah\\Dropbox\\boot\\23-c-boot-8\\src\\main\\resources\\static\\images\\";

		try {
			File f = new File(masterPath, file.getOriginalFilename());

			byte b[] = file.getBytes();
			FileOutputStream fos = new FileOutputStream(f);

			fos.write(b);
			fos.close();
			model.addAttribute("img", "images/" + file.getOriginalFilename());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ViewProfile";
	}

	@GetMapping("/viewprofile")
	public String viewProfile() {
		return "ViewProfile";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/authenticate")
	public String authenticate(UserBean user,Model model,HttpSession session) {

		if (user.getEmail().length() > 0 && user.getPassword().length() > 0) {
			session.setAttribute("user", user);
			return "Home";
		} else {
			model.addAttribute("error","Invalid Credentials");
			return "Login";
		}
	}



	@GetMapping("/logout")
	public String logout(Model model,HttpSession session) {
		session.invalidate();//destroy 
		model.addAttribute("msg","Logout successfully...");
		return "Login";
	}

}
