package com.example.duongnl_selling.core.sell.rest;

import com.example.duongnl_selling.core.sell.dto.request.CartRequest;
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

    @GetMapping("/{id}")
    public List<BillResponse> findAll(@PathVariable("id") Long id) {
        return billService.findByAccount(id);
    }

    @PostMapping("/create")
    public ResponseObject create(@RequestBody CreateBillRequest request) {
        return new ResponseObject(billService.create(request));
    }

    @PostMapping("/pay")
    public ResponseObject pay(@RequestBody CartRequest request) {
        return new ResponseObject(billService.pay(request));
    }

    @GetMapping("/detail/{id}")
    public ResponseObject detailBill(@PathVariable("id") Long id) {
        return new ResponseObject(billService.findBillDetail(id));
    }
}
