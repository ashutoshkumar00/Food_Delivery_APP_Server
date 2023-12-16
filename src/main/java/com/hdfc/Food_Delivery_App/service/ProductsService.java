package com.hdfc.Food_Delivery_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.Food_Delivery_App.exception.CustomMessage;
import com.hdfc.Food_Delivery_App.model.Products;
import com.hdfc.Food_Delivery_App.repo.ProductsRepo;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepo pdtrepo;
	
	public Products addProduct(Products pdt) {
		return pdtrepo.save(pdt);
	}

	public List<Products> getProducts() {
		return pdtrepo.findAll();
	}

	public void deleteProduct(int id) throws CustomMessage {
		
		Products pdt = pdtrepo.findById(id).orElse(null);
		
		if(pdt==null) throw new CustomMessage("Product not found.");
		
		pdtrepo.delete(pdt);
	}
	

}
