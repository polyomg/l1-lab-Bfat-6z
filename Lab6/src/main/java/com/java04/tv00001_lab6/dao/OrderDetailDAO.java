package com.java04.tv00001_lab6.dao;

import com.java04.tv00001_lab6.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
}
