package com.java04.tv00001_lab6.dao;

import com.java04.tv00001_lab6.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountDAO extends JpaRepository<Account, String> {
}
