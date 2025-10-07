package TV00001_NguyenHoangMinhHieu.poly.edu.lab3.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {
    private String id;
    private String fullname;
    @Builder.Default private String photo = "photo.jpg";
    @Builder.Default private Boolean gender = true;
    @Builder.Default private Date birthday = new Date();
    @Builder.Default private double salary = 100;
    @Builder.Default private Integer level = 0;
}