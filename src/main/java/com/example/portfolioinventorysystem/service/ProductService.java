package com.example.portfolioinventorysystem.service;

import com.example.portfolioinventorysystem.model.Product;
import com.example.portfolioinventorysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product searchProductId(Integer idProduct) {
        return this.productRepository.findById(idProduct).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProductId(Integer idProduct) {
        this.productRepository.deleteById(idProduct);
    }
}
