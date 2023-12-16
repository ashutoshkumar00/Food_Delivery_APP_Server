package com.hdfc.Food_Delivery_App.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.Food_Delivery_App.model.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer> {

}
