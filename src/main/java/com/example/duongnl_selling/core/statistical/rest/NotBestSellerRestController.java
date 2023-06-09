package com.example.duongnl_selling.core.statistical.rest;

import com.example.duongnl_selling.core.statistical.service.NotBestSellerService;
import com.example.duongnl_selling.infrastructure.config.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/NOTbestseller")
public class NotBestSellerRestController {

    @Autowired
    private NotBestSellerService notBestSellerService;

    @GetMapping
    public ResponseObject getNotBestSeller() {
        return new ResponseObject(notBestSellerService.getNotBestSeller());
    }
}
