package com.example.duongnl_selling.core.sell.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryResponse {

    private Long id;
    private String name;
    private Boolean isDeleted;
}
