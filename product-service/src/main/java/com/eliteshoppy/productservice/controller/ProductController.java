package com.eliteshoppy.productservice.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliteshoppy.productservice.httpresponse.HttpResponse;
import com.eliteshoppy.productservice.httpresponse.SuccessResponse;
import com.eliteshoppy.productservice.model.Product;
import com.eliteshoppy.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		return new ResponseEntity<>(productService.get(productId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpResponse> createProduct(@NotNull Product product) {
		productService.create(product);
		return new ResponseEntity<>(new SuccessResponse("Product has been created."), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<HttpResponse> updateProduct(@NotNull Product product) {
		productService.update(product);
		return new ResponseEntity<>(new SuccessResponse("Product has been updated."), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<HttpResponse> deleteProduct(int productId) {
		productService.delete(productId);
		return new ResponseEntity<>(new SuccessResponse("Product has been updated."), HttpStatus.OK);
	}
}
