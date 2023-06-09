package com.example.duongnl_selling.repository;

import com.example.duongnl_selling.core.statistical.dto.response.CartResponse;
import com.example.duongnl_selling.entity.Cart;
import com.example.duongnl_selling.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c  FROM Cart c WHERE c.bill.id = :id")
    List<Cart> findBillDetail(@Param("id") Long id);

    @Query(value = "SELECT `cart`.`product_id`,COUNT(`cart`.`product_id`)\n" +
            "FROM `duongnl_sale_phone`.`cart`\n" +
            "GROUP BY `cart`.`product_id`\n" +
            "ORDER BY COUNT(`cart`.`product_id`) DESC\n" +
            "LIMIT 10", nativeQuery = true)
    List<Object[]> getTop10BestSeller();
}
