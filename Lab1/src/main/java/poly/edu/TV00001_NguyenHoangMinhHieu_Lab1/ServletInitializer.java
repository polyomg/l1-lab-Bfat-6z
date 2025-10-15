package poly.edu.TV00001_NguyenHoangMinhHieu_Lab1;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Tv00001NguyenHoangMinhHieuLab1Application.class);
    }

}
