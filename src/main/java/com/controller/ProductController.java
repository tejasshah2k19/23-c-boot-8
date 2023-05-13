package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.bean.ResponseBean;

@RestController
public class ProductController {

//	@PostMapping("/product")
//	public ResponseEntity<?> addProduct(@RequestBody ProductBean product) {
//		System.out.println(product.getName());
//		System.out.println(product.getPrice());
//
//		if (product.getPrice() < 0) {
//			return ResponseEntity.badRequest().body(product);
//		} else {
//
//			ResponseEntity r = new ResponseEntity(product, HttpStatus.OK);
//
////			return ResponseEntity.ok(product);// json
//			return r;
//
//		}
//	}

	@PostMapping("/product")
	public ResponseEntity<ResponseBean<ProductBean>> addProduct(@RequestBody ProductBean product) {
		System.out.println(product.getName());
		System.out.println(product.getPrice());

		ResponseBean<ProductBean> res = new ResponseBean<>();
		res.setData(product);
		if (product.getPrice() < 0) {
			res.setMsg("Invalid Price");

			return ResponseEntity.badRequest().body(res);
		} else {

 
//			return ResponseEntity.ok(product);// json
			res.setMsg("Product added");
			return ResponseEntity.ok(res);

		}
	}

	@PostMapping("/product2")
	public ResponseEntity<ResponseBean<ProductBean>> saveProduct(ProductBean product) {
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getProductImage().getOriginalFilename());
		
		ResponseBean<ProductBean> res = new ResponseBean<>();
		res.setData(product);
		if (product.getPrice() < 0) {
			res.setMsg("Invalid Price");

			return ResponseEntity.badRequest().body(res);
		} else {

 
//			return ResponseEntity.ok(product);// json
			res.setMsg("Product added");
			return ResponseEntity.ok(res);

		}
	}


}
//REST client -> api 