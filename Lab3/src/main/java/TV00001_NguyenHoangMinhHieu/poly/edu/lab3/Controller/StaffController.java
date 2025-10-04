package TV00001_NguyenHoangMinhHieu.poly.edu.lab3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import TV00001_NguyenHoangMinhHieu.poly.edu.lab3.Entity.Staff;

import java.util.Date;
import java.util.List;

@Controller
public class StaffController {

    private List<Staff> getStaffList() {
        return List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").photo("photo.jpg").gender(true).birthday(new Date()).salary(150.50).level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").photo("photo.jpg").gender(false).birthday(new Date()).salary(200.75).level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").photo("photo.jpg").gender(true).birthday(new Date()).salary(300.00).level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").photo("photo.jpg").gender(false).birthday(new Date()).salary(250.25).level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").photo("photo.jpg").gender(true).birthday(new Date()).salary(180.90).level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").photo("photo.jpg").gender(false).birthday(new Date()).salary(120.30).level(0).build()
        );
    }

    @RequestMapping("/staff/details")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .photo("photo.jpg")
                .gender(true)
                .birthday(new Date())
                .salary(200.00)
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "demo/staff-details";
    }

    @RequestMapping("/staff/list")
    public String list(Model model) {
        model.addAttribute("list", getStaffList());
        return "demo/staff-list";
    }

    @RequestMapping("/staff/list-status")
    public String listStatus(Model model) {
        model.addAttribute("list", getStaffList());
        return "demo/list-status";
    }

    @RequestMapping("/staff/list-controller")
    public String listControls(Model model) {
        model.addAttribute("list", getStaffList());
        return "demo/list-controller";
    }
}