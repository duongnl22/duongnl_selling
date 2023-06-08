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
}
