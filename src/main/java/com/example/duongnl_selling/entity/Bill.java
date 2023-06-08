package com.example.duongnl_selling.entity;

import com.example.duongnl_selling.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class Bill extends PrimaryEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_payment")
    private LocalDateTime createPayment;

    @Column(name = "into_money")
    private BigDecimal intoMoney;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;



}
