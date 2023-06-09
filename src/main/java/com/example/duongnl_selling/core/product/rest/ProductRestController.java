package com.example.duongnl_selling.core.product.rest;

import com.example.duongnl_selling.core.product.dto.request.CreateProductRequest;
import com.example.duongnl_selling.core.product.dto.request.UpdateProductRequest;
import com.example.duongnl_selling.core.product.service.ProductService;
import com.example.duongnl_selling.infrastructure.config.ResponseObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;
    @GetMapping("/{isDeleted}")
    public ResponseObject findProduct(@PathVariable("isDeleted") boolean isDeleted) {
        return new ResponseObject(productService.findProduct(isDeleted));
    }

    @PostMapping("/create")
    public ResponseObject create(@RequestBody @Valid CreateProductRequest request) {
        return new ResponseObject(productService.save(request));
    }

    @PutMapping("/update")
    public ResponseObject update(@RequestBody UpdateProductRequest request) {
        return new ResponseObject(productService.update(request));
    }

    @PutMapping("/delete/{id}")
    public ResponseObject delete(@PathVariable("id") Long id) {
        return new ResponseObject(productService.delete(id));
    }

    @GetMapping("/detail/{id}")
    public ResponseObject findById(@PathVariable("id") Long id) {
        return new ResponseObject(productService.findById(id));
    }

    @GetMapping("/{isDeleted}/{currentPage}/{pageSize}")
    public ResponseObject paging(@PathVariable("isDeleted") boolean isDeleted,
                                 @PathVariable("currentPage") int currentPage,
                                 @PathVariable("pageSize") int pageSize) {
        return new ResponseObject(productService.paging(isDeleted, currentPage, pageSize));
    }

    @GetMapping("/price/{min}/{max}")
    public ResponseObject searchPrice(@PathVariable("min") BigDecimal min, @PathVariable("max") BigDecimal max) {
        return new ResponseObject(productService.searchPrice(min, max));
    }

    @GetMapping("/search/{name}")
    public ResponseObject seachName(@PathVariable("name") String name){
        return  new ResponseObject(productService.searchName(name));
    }
}
