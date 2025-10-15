package com.poly.lab2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")  // Để match /ctrl/ok
public class OkController {

    @PostMapping("/ok")  // Map POST /ctrl/ok (không param x) → OK 1
    public String m1(Model model) {
        model.addAttribute("method", "m1");
        return "ok";
    }

    @GetMapping("/ok")  // Map GET /ctrl/ok → OK 2
    public String m2(Model model) {
        model.addAttribute("method", "m2");
        return "ok";
    }

    @RequestMapping(value = "/ok", params = "x")  // Map POST /ctrl/ok?x → OK 3 (có param x)
    public String m3(Model model) {
        model.addAttribute("method", "m3");
        return "ok";
    }

    // Xóa hoặc comment method ok() gốc vì không cần nữa
}