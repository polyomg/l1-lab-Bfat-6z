package com.java04.tv00001_lab7.dao;

import com.java04.tv00001_lab7.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product2DAO extends JpaRepository<Product, Integer> {
    // Bài 4: DSL tìm theo khoảng giá
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Bài 5: DSL tìm theo tên + phân trang
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    // Bài 6: DSL sắp xếp theo giá giảm dần
    List<Product> findAllByOrderByPriceDesc();
}