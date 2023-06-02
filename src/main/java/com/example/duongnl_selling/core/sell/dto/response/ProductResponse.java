package com.example.duongnl_selling.core.sell.dto.response;

import com.example.duongnl_selling.entity.Product;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponse {
    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal priceDiscount;
    private Integer resolution;
    private String connect;
    private String image;
    private Boolean isDeleted;
    private CategoryResponse category;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProductResponse product = (ProductResponse) object;
        return Objects.equals(id, product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
