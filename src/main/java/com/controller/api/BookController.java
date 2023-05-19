package com.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.BookBean;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@PostMapping("/book")
	public ResponseEntity<?> addBook(@RequestBody BookBean book, HttpServletRequest request) {

		String token = request.getHeader("token");
System.out.println("token => "+token); 

 //chkToknDb
		if (token == null || token.trim().length() == 0) {

			return new ResponseEntity(book, HttpStatus.FORBIDDEN);
		} else {
			System.out.println(book.getBookName());
			return ResponseEntity.ok(book);
		}
	}
}
