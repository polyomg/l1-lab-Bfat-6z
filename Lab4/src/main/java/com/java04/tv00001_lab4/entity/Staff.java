package com.java04.tv00001_lab4.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staff {
    @NotBlank(message = "Chưa nhập email!")
    @Email(message = "Email không đúng định dạng!")
    private String id;

    @NotBlank(message = "Chưa nhập họ và tên!")
    private String fullname;

    @Builder.Default
    private String photo = "photo.jpg";

    @Builder.Default
    @NotNull(message = "Chưa chọn giới tính!")
    private Boolean gender = true;

    @NotNull(message = "Chưa nhập ngày sinh!")
    @Past(message = "Ngày sinh không hợp lệ!")
    @Builder.Default
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday = new Date();

    @Min(value = 1000, message = "Lương tối thiểu phải là 1000!")
    @NotNull(message = "Chưa nhập lương!")
    @Builder.Default
    private double salary = 12345.6789;

    @Builder.Default
    private Integer level = 0;

}
