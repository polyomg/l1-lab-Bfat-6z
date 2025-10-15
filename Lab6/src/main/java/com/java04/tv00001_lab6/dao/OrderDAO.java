package com.java04.tv00001_lab6.dao;

import com.java04.tv00001_lab6.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDAO extends JpaRepository<Order, Long> {
}
