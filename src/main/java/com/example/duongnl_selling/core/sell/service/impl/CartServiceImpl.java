package com.example.duongnl_selling.core.sell.service.impl;

import com.example.duongnl_selling.core.sell.dto.request.CartSessionRequest;
import com.example.duongnl_selling.core.sell.dto.response.CartSessionResponse;
import com.example.duongnl_selling.core.sell.dto.response.CartSession;
import com.example.duongnl_selling.core.sell.dto.response.ProductCartResponse;
import com.example.duongnl_selling.core.sell.repository.CartSessionRepository;
import com.example.duongnl_selling.core.sell.service.CartService;
import com.example.duongnl_selling.entity.Product;
import com.example.duongnl_selling.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartSessionRepository cartSessionRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CartSessionResponse getCart() {
        CartSession cartSession = cartSessionRepository.getCart();
        Map<Long, Integer> listProduct = cartSession.getProducts();
        CartSessionResponse cartSessionResponse = new CartSessionResponse();
        List<BigDecimal> totalPrices = new ArrayList<>();
        for (Map.Entry<Long, Integer> product : listProduct.entrySet()) {
            Long id = product.getKey();
            Integer quantity = product.getValue();

            ProductCartResponse productResponse = getProductCart(id, quantity);
            cartSessionResponse.getListProduct().add(productResponse);

            totalPrices.add(productResponse.getTotalPrice());
        }
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (BigDecimal price : totalPrices) {
            totalPrice = totalPrice.add(price);
        }
        cartSessionResponse.setIntoMoney(totalPrice);

        return cartSessionResponse;
    }

    @Override
    public String addToCart(CartSessionRequest cartSessionRequest) {
        if (cartSessionRepository.existsKey(cartSessionRequest.getId())) {
            Integer currentQuantity = cartSessionRepository.getQuantity(cartSessionRequest.getId());
            cartSessionRepository.addToCart(cartSessionRequest.getId(),
                    cartSessionRequest.getQuantity() + currentQuantity);
        } else {
            cartSessionRepository.addToCart(cartSessionRequest.getId(), cartSessionRequest.getQuantity());
        }
        return "Add To CartSession Successfully";
    }

    @Override
    public String reduceProduct(CartSessionRequest cartSessionRequest) {
        if (cartSessionRepository.existsKey(cartSessionRequest.getId())) {
            Integer currentQuantity = cartSessionRepository.getQuantity(cartSessionRequest.getId());
            cartSessionRepository.changeQuantity(cartSessionRequest.getId(),
                    currentQuantity + cartSessionRequest.getQuantity());
        }
        return "No products found in the cart";
    }

    @Override
    public String deleteProduct(Long id) {
        if(cartSessionRepository.existsKey(id)){
            cartSessionRepository.deleteProduct(id);
        }
        return "No products found in the cart";
    }

    @Override
    public String deleteAllProduct() {
        cartSessionRepository.deleteAllProduct();
        return "Empty product list";
    }

    private ProductCartResponse getProductCart(Long id, Integer quantity) {
        Product product = productRepository.findById(id).get();
        ProductCartResponse productCart = new ProductCartResponse();
        productCart.setId(product.getId());
        productCart.setName(product.getName());
        productCart.setQuantity(quantity);
        productCart.setImage(product.getImage());
        productCart.setPrice(product.getPrice());
        productCart.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        return productCart;
    }


}
