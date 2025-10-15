package com.java04.tv00001_lab7.controller;

import com.java04.tv00001_lab7.dao.Product1DAO;
import com.java04.tv00001_lab7.dao.Product2DAO;
import com.java04.tv00001_lab7.Entity.Product;
import com.java04.tv00001_lab7.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private Product1DAO product1Dao;

    @Autowired
    private Product2DAO product2Dao;

    @Autowired
    private SessionService session;

    // Bài 1: Tìm theo giá (JPQL)
    @RequestMapping("/product/search1")
    public String search1(Model model,
                          @RequestParam("min") Optional<Double> min,
                          @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = product1Dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search1";
    }

    // Bài 2: Tìm theo tên + phân trang (JPQL)
    @RequestMapping("/product/search-and-page1")
    public String searchAndPage1(Model model,
                                 @RequestParam("keywords") Optional<String> kw,
                                 @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = product1Dao.findByKeywords("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page1";
    }

    // Bài 4: Tìm theo giá (DSL)
    @RequestMapping("/product/search2")
    public String search2(Model model,
                          @RequestParam("min") Optional<Double> min,
                          @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = product2Dao.findByPriceBetween(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search2";
    }

    // Bài 5: Tìm theo tên + phân trang (DSL)
    @RequestMapping("/product/search-and-page2")
    public String searchAndPage2(Model model,
                                 @RequestParam("keywords") Optional<String> kw,
                                 @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = product2Dao.findAllByNameLike("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page2";
    }

    // Bài 6: Sắp xếp (DSL)
    @RequestMapping("/product/sort")
    public String sort(Model model) {
        List<Product> items = product2Dao.findAllByOrderByPriceDesc();
        model.addAttribute("items", items);
        return "product/sort";
    }
}