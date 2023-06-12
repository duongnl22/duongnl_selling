package com.example.duongnl_selling.core.statistical.rest;

import com.example.duongnl_selling.core.statistical.dto.response.CartResponse;
import com.example.duongnl_selling.core.statistical.service.BestsellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/bestseller")
public class BestSellerRestController {

    @Autowired
    private BestsellerService bestsellerService;

    @GetMapping("/{date}")
    public List<CartResponse> getBestSeller(@PathVariable("date") String date) {
        return bestsellerService.getBestSeller(date);
    }

    @GetMapping
    public List<CartResponse> getTop10() {
        return bestsellerService.getTop10();
    }

}
