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
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productRepository.findById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id){
        productRepository.deleteById(id);
        return id + " numarali urun Moonİnventory stoklarindan basariyla silindi";
    }
}
