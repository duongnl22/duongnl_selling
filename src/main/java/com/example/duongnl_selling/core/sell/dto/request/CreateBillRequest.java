package com.example.duongnl_selling.core.sell.dto.request;

import com.example.duongnl_selling.core.sell.dto.response.AccountResponse;
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
public class CreateBillRequest {


    private String code;

    private LocalDateTime createDate;

    private Integer status;

    private Long idAccount;
}
