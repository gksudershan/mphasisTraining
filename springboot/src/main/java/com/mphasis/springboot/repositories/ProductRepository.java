package com.mphasis.springboot.repositories;

import com.mphasis.springboot.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
