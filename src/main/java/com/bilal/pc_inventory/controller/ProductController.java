package com.bilal.pc_inventory.controller;
import com.bilal.pc_inventory.entity.Product;
import com.bilal.pc_inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
