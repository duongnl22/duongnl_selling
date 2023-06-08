package com.example.duongnl_selling.core.sell.repository;

import com.example.duongnl_selling.core.sell.dto.response.CartSession;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CartSessionRepository {

    private CartSession cartSession = new CartSession();

    public CartSession getCart() {
        return cartSession;
    }

    public void addToCart(Long id, Integer quantity) {
        Map<Long, Integer> productInCart = cartSession.getProducts();
        productInCart.put(id, quantity);
    }

    public void changeQuantity(Long id, Integer quantity) {
        Map<Long, Integer> productInCart = cartSession.getProducts();
        productInCart.put(id, quantity);
    }

    public void deleteProduct(Long id) {
        Map<Long, Integer> productInCart = cartSession.getProducts();
        productInCart.remove(id);
    }
    public void deleteAllProduct(){
        Map<Long,Integer> productInCart = cartSession.getProducts();
        productInCart.clear();
    }

    public Integer getQuantity(Long id) {
        return cartSession.getProducts().get(id);
    }

    public boolean existsKey(Long id) {
        return cartSession.getProducts().containsKey(id);
    }

}
