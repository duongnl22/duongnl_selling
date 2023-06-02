package com.example.duongnl_selling.core.sell.service;

import com.example.duongnl_selling.core.sell.dto.request.CreateBillRequest;
import com.example.duongnl_selling.core.sell.dto.response.BillResponse;
import com.example.duongnl_selling.entity.Bill;

import java.util.List;

public interface BillService {

    List<BillResponse> findAll();
    Bill create(CreateBillRequest request);

}
