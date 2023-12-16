package com.hdfc.Food_Delivery_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.Food_Delivery_App.exception.CustomMessage;
import com.hdfc.Food_Delivery_App.model.Products;
import com.hdfc.Food_Delivery_App.service.ProductsService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductsController {
	
	@Autowired
	private ProductsService pdtserv;
	
	@PostMapping("/addproduct")
	public Products addProduct(@RequestBody Products pdt) {
		return pdtserv.addProduct(pdt);
	}
	
	@GetMapping("/getproducts")
	public List<Products> getProducts(){
		return pdtserv.getProducts();
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) throws CustomMessage {
		pdtserv.deleteProduct(id);
		return "Product with "+id+" has been deleted";
	}
	

}
