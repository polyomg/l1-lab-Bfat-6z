package com.java04.tv00001_lab6.dao;

import com.java04.tv00001_lab6.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDAO extends JpaRepository<Category, String> {
}
