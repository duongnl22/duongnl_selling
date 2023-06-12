package com.example.duongnl_selling.repository;

import com.example.duongnl_selling.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c  FROM Cart c WHERE c.bill.id = :id")
    List<Cart> findBillDetail(@Param("id") Long id);

    @Query(value = "SELECT\n" +
            "    `product`.`product_name`,\n" +
            "    count(`cart`.`product_id`) AS `num_sold`\n" +
            "FROM\n" +
            "    `duongnl_sale_phone`.`cart`\n" +
            "JOIN\n" +
            "    `duongnl_sale_phone`.`bill` ON `cart`.`bill_id` = `bill`.`id`\n" +
            "JOIN\n" +
            "\t`duongnl_sale_phone`.`product` ON `cart`.product_id = `product`.id\n" +
            "WHERE\n" +
            "     `bill`.`create_payment`like %:date% \n" +
            "GROUP BY\n" +
            "     `product`.`product_name`\n" +
            "ORDER BY\n" +
            "    `num_sold` DESC\n" +
            "LIMIT 10;\n", nativeQuery = true)
    List<Object[]> getBestSellerForDate(@Param("date") String date);

    @Query(value = "SELECT\n" +
            "    `product`.`product_name`,\n" +
            "    count(`cart`.`product_id`) AS `num_sold`\n" +
            "FROM\n" +
            "    `duongnl_sale_phone`.`cart`\n" +
            "JOIN\n" +
            "    `duongnl_sale_phone`.`bill` ON `cart`.`bill_id` = `bill`.`id`\n" +
            "JOIN\n" +
            "\t`duongnl_sale_phone`.`product` ON `cart`.product_id = `product`.id\n" +
            "GROUP BY\n" +
            "     `product`.`product_name`\n" +
            "ORDER BY\n" +
            "    `num_sold` DESC\n" +
            "LIMIT 10;\n", nativeQuery = true)
    List<Object[]> getBestSeller();
}
