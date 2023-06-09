package com.example.duongnl_selling.repository;

import com.example.duongnl_selling.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.isDeleted =:isDeleted")
    Page<Product> findProduct(@Param("isDeleted") boolean isDeleted, PageRequest page);

    @Query("SELECT p FROM Product p WHERE p.isDeleted =:isDeleted")
    List<Product> findProductDelete(@Param("isDeleted") boolean isDeleted);

    @Query("SELECT p FROM Product p WHERE p.isDeleted =:isDeleted AND p.price BETWEEN :min AND :max")
    List<Product> searchPrice(@Param("isDeleted") boolean isDeleted, @Param("min") BigDecimal min, @Param("max") BigDecimal max);

//    List<Product> findByNameAndCategoryAndAndConnectAndAndResolution(String category, String name, String connect, String resolution);

    List<Product> findByNameContains(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.quantity = :quantity WHERE p.id = :id")
    void updateQuantity(@Param("quantity") Integer quantity, @Param("id") Long id);


    @Query(value = "SELECT `product`.`id`," +
            "    `product`.`product_name`,\n" +
            "    `product`.`quantity`,\n" +
            "    `product`.`price`,\n" +
            "    `product`.`price_after_discount`,\n" +
            "    `product`.`resolution`,\n" +
            "    `product`.`connect`,\n" +
            "    `product`.`create_date`,\n" +
            "    `product`.`image`,\n" +
            "    `product`.`is_deleted`,\n" +
            "    `product`.`category_id`\n" +
            " FROM `duongnl_sale_phone`.`product`\n" +
            " WHERE `id` NOT IN (SELECT `id` FROM `duongnl_sale_phone`.`cart` )\n" +
            " ORDER BY `quantity` DESC\n" +
            " LIMIT 10;", nativeQuery = true)
    List<Product> getTop10NotBestSeller();
}

