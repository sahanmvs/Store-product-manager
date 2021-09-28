package com.example.SystemManger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SystemManger.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
