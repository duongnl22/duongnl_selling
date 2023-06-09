package com.example.duongnl_selling.core.product.dto.request;

import com.example.duongnl_selling.core.product.dto.response.CategoryResponse;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotBlank(message = "Name Product is required !!")
    @Length(max = 200 , message = "Name phải nhỏ hơn 200 kí tự!!")
    private String name;
    @NotNull(message = "Quantity is required!!")
    @Min(value = 1, message = "Quantity phải lớn hơn 0!")
    @Max(value = 100000 , message = "Quantity phải nhỏ hơn 100000 !!")
    private Integer quantity;
    @NotNull(message = "Price is required!!")
    @DecimalMin(value = "1000" , inclusive = false , message = "Price phải lớn hơn 1000!")
    @DecimalMax(value = "1000000000" , inclusive = true , message = "Price phải nhỏ hơn 1 tỉ")
    private BigDecimal price;
    private BigDecimal priceDiscount;
    @NotNull(message = "Resolution is required!!")
    @Min(value = 500, message = "Resolution phải lớn hơn 500!")
    @Max(value = 5000 , message = "Resolution phải nhỏ hơn 5000 !!")
    private Integer resolution;
    @NotNull(message = "Connect is required!!")
    private Boolean connect;
    private String image;
    private LocalDate createDate;
    private CategoryResponse category;
}
