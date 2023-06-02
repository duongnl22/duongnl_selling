package com.example.duongnl_selling.entity;

import com.example.duongnl_selling.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart extends PrimaryEntity {

    @Column(name = "cart_quantity")
    private Integer cartQuantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private  Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id" , referencedColumnName = "id")
    private  Bill bill;


}
