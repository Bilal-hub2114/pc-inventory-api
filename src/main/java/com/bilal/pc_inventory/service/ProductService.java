package com.bilal.pc_inventory.service;

import com.bilal.pc_inventory.repository.ProductRepository;
import com.bilal.pc_inventory.entity.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository= productRepository;
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);

    }
    public Product updateProduct(int id,Product updatedProduct){
        return productRepository.findById(id).map(existingProduct ->{

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
            return productRepository.save(existingProduct);

        }).orElse(null);
    }
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return id + " numarali urun Moonİnventory stoklarindan basariyla silindi!" ;
    }

}
