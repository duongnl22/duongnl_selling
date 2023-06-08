package com.example.duongnl_selling.core.sell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartSession {
    private Map<Long, Integer> products = new HashMap<>();


}
