package com.mphasis.springboot.model.services;

import com.mphasis.springboot.exceptions.ResourceNotFoundException;
import com.mphasis.springboot.model.entities.Product;
import com.mphasis.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id){
        Optional<Product> productFromTable = productRepository.findById(id);
        if(productFromTable.isPresent()){
            return productFromTable.get();
        }
        else{
            throw new ResourceNotFoundException("product not found with id "+id);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
