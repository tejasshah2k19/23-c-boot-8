package com.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;

@RestController
@RequestMapping("/api/v1/public")
public class RestSessionController {
	// /api/v1/public/login
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserBean userBean) {

		UserBean user = null; // db user
		if (userBean.getEmail().equals("admin@gmail.com") && userBean.getPassword().equals("admin")) {
			user = userBean;
			user.setToken("123456780");
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.badRequest().body(userBean);
		}

	}

	// /api/v1/public/signup 
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserBean userBean) {

		return ResponseEntity.ok(userBean);

	}

}
