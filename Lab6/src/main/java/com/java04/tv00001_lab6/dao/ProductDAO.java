package com.java04.tv00001_lab6.dao;

import com.java04.tv00001_lab6.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDAO extends JpaRepository<Product, Integer> {
}
