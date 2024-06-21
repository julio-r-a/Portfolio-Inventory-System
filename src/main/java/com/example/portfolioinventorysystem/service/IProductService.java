package com.example.portfolioinventorysystem.service;

import com.example.portfolioinventorysystem.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> listProduct();

    public Product searchProductId(Integer idProduct);

    public Product saveProduct(Product product);

    public void deleteProductId(Integer idProduct);
}
