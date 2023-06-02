package com.example.duongnl_selling.core.sell.rest;

import com.example.duongnl_selling.core.sell.dto.request.CreateBillRequest;
import com.example.duongnl_selling.core.sell.dto.response.BillResponse;
import com.example.duongnl_selling.core.sell.service.BillService;
import com.example.duongnl_selling.infrastructure.config.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bill")
public class BillRestController {

    @Autowired
    private BillService billService;

    @GetMapping
    public List<BillResponse> findAll() {
        return billService.findAll();
    }

    @PostMapping("/create")
    public ResponseObject create(@RequestBody CreateBillRequest request) {
        return new ResponseObject(billService.create(request));
    }
}
