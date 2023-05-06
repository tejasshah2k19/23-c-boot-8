package com.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SessionController {

	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

//	@RequestMapping(value = "/saveprofile",method = RequestMethod.POST)
	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file,Model model) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		String masterPath = "E:\\Tejas Shah\\Dropbox\\boot\\23-c-boot-8\\src\\main\\resources\\static\\images\\";

		try {
			File f = new File(masterPath, file.getOriginalFilename());

			byte b[] = file.getBytes();
			FileOutputStream fos  = new FileOutputStream(f);
			
			fos.write(b);
			fos.close();
			model.addAttribute("img","images/"+file.getOriginalFilename());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ViewProfile";
	}
	
	
	@GetMapping("/viewprofile")
	public String viewProfile() {
		return "ViewProfile";
	}
}
