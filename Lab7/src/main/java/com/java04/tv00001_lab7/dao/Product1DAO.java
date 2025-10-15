package com.java04.tv00001_lab7.dao;

import com.java04.tv00001_lab7.Entity.Product;
import com.java04.tv00001_lab7.Entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Product1DAO extends JpaRepository<Product, Integer> {
    // Bài 1: JPQL tìm theo khoảng giá
    @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    // Bài 2: JPQL tìm theo tên + phân trang
    @Query("FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable); // Sửa để hỗ trợ Pageable

    // Bài 3: JPQL tổng hợp tồn kho
    @Query("SELECT o.category AS group, SUM(o.price) AS sum, COUNT(o) AS count " +
            "FROM Product o " +
            "GROUP BY o.category " +
            "ORDER BY SUM(o.price) DESC")
    List<Report> getInventoryByCategory();
}