package com.example.SystemManger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SystemManger.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
