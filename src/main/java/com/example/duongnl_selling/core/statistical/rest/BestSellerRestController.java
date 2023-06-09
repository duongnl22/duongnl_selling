package com.example.duongnl_selling.core.statistical.rest;

import com.example.duongnl_selling.core.statistical.dto.response.CartResponse;
import com.example.duongnl_selling.core.statistical.service.BestsellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/bestseller")
public class BestSellerRestController {

    @Autowired
    private BestsellerService bestsellerService;

    @GetMapping
    public List<CartResponse> getBestSeller(){
        return bestsellerService.getBestSeller();
    }

}
