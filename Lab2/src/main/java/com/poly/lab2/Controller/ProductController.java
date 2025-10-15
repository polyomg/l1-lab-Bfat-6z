package com.poly.lab2.Controller;

import com.poly.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    // List "sống" lưu sản phẩm
    private List<Product> items = new ArrayList<>();

    public ProductController() {
        // Dữ liệu mặc định ban đầu
        items.addAll(Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0)
        ));
    }

    @ModelAttribute("p1")
    public Product setDefaultProduct() {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        return p; // Đặt p1 mặc định ở đây để luôn có sẵn
    }

    @RequestMapping("/form1")
    public String form(Model model) {
        model.addAttribute("p2", new Product()); // Khởi tạo p2 rỗng cho form
        return "product/form1";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        if (p.getName() == null || p.getName().trim().isEmpty() || p.getPrice() == null) {
            model.addAttribute("error", "Please fill all fields!");
            return "product/form1";
        }
        items.add(p); // Thêm vào list items
        model.addAttribute("p2", p); // Cập nhật p2 với dữ liệu vừa nhập
        return "product/form1"; // Render lại form với p2 mới
    }

    @ModelAttribute("p3")
    public List<Product> getItems() {
        return items;
    }
}