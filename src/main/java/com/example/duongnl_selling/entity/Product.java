package com.example.duongnl_selling.entity;

import com.example.duongnl_selling.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product extends PrimaryEntity {
    @Column(name = "product_name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "price_after_discount")
    private BigDecimal priceDiscount;

    @Column(name = "resolution")
    private Integer resolution;

    @Column(name = "connect")
    private Boolean connect;

    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "image")
    private String image;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


}
