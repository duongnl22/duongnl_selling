package com.example.duongnl_selling.core.sell.service.impl;

import com.example.duongnl_selling.core.sell.dto.request.CreateBillRequest;
import com.example.duongnl_selling.core.sell.dto.response.BillResponse;
import com.example.duongnl_selling.repository.AccountRepository;
import com.example.duongnl_selling.repository.BillRepository;
import com.example.duongnl_selling.core.sell.service.BillService;
import com.example.duongnl_selling.entity.Account;
import com.example.duongnl_selling.entity.Bill;
import com.example.duongnl_selling.infrastructure.constant.BillStatus;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper mapper;

    private String createCodeBill() {
        LocalDateTime now = LocalDateTime.now();
        String createDate = now.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
       int count = billRepository.findAll().size() + 1;
        String code = createDate + count;
        return code;
    }

    @Override
    public List<BillResponse> findAll() {
        List<Bill> listBill = billRepository.findAll();
        TypeToken<List<BillResponse>> typeToken = new TypeToken<>() {
        };
        List<BillResponse> listBillResponse = mapper.map(listBill, typeToken.getType());
        return listBillResponse;
    }

    @Override
    public Bill create(CreateBillRequest request) {
        Bill bill = new Bill();
        String code = createCodeBill();
        bill.setCode("HD" + code);
        bill.setCreateDate(LocalDateTime.now());
        bill.setStatus(BillStatus.PAYING.getBillStatus());
        Account account = accountRepository.findById(request.getIdAccount()).get();
        bill.setAccount(account);
        return billRepository.save(bill);
    }

}
