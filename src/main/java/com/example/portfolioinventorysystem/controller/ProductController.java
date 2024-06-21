package com.example.portfolioinventorysystem.controller;

import com.example.portfolioinventorysystem.model.Product;
import com.example.portfolioinventorysystem.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventory-app/v1")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/product/list")
    public List<Product> getProduct(){
        List<Product> products = productService.listProduct();
        logger.info("getProduct");
        products.forEach(product -> logger.info(product.toString()));
        return products;
    }

    @PostMapping("/product/save")
    public Product saveproduct(@RequestBody Product product){
        logger.info("saveProduct" + product);
         return this.productService.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> searchProduct(@PathVariable int id){
            Product product = this.productService.searchProductId(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el producto con el ID: " + id);
        }
        return ResponseEntity.ok(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product upProduct){
        Product product = this.productService.searchProductId(id);
        product.setDescription(upProduct.getDescription());
        product.setPrice(upProduct.getPrice());
        product.setAmount(upProduct.getAmount());
        this.productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int id){
        Product product = this.productService.searchProductId(id);
        this.productService.deleteProductId(product.getIdProduct());
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
