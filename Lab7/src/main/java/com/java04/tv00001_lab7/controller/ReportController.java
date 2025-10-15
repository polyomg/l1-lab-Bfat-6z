package com.java04.tv00001_lab7.controller;

import com.java04.tv00001_lab7.dao.Product1DAO; // Sử dụng Product1DAO cho nhất quán
import com.java04.tv00001_lab7.Entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private Product1DAO dao; // Sử dụng Product1DAO cho Bài 3

    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}