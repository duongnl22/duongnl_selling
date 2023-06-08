package com.example.duongnl_selling.core.sell.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBillRequest {

    private Long id;

    private String code;

    private LocalDateTime createDate;

    private LocalDateTime createPayment;

    private BigDecimal intoMoney;

    private String note;

    private Integer status;

    private Long idAccount;

}
