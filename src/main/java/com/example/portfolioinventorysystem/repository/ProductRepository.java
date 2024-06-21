package com.example.portfolioinventorysystem.repository;

import com.example.portfolioinventorysystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

}
