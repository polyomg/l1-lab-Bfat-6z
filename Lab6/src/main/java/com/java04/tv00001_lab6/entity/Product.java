package com.java04.tv00001_lab6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private double price;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createdate = new Date();
    Boolean available;
    @ManyToOne @JoinColumn(name = "Categoryid")
    private Category category;
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

}
