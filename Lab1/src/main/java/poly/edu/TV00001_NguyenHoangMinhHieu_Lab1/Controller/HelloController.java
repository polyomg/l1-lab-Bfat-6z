package poly.edu.TV00001_NguyenHoangMinhHieu_Lab1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/poly/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "Hello World!");
        return "poly/hello";
    }
}
