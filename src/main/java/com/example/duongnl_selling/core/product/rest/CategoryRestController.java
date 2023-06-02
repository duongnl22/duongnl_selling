package com.example.duongnl_selling.core.product.rest;

import com.example.duongnl_selling.core.product.service.CategoryService;
import com.example.duongnl_selling.infrastructure.config.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseObject findAll() {
        return new ResponseObject(categoryService.findAll());
    }
}
