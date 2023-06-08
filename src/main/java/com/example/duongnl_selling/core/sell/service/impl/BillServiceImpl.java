package com.example.duongnl_selling.core.sell.service.impl;

import com.example.duongnl_selling.core.sell.dto.request.CartRequest;
import com.example.duongnl_selling.core.sell.dto.request.CreateBillRequest;
import com.example.duongnl_selling.core.sell.dto.response.BillResponse;
import com.example.duongnl_selling.core.sell.dto.response.CartResponse;
import com.example.duongnl_selling.core.sell.dto.response.ProductCartResponse;
import com.example.duongnl_selling.entity.Cart;
import com.example.duongnl_selling.entity.Product;
import com.example.duongnl_selling.repository.AccountRepository;
import com.example.duongnl_selling.repository.BillRepository;
import com.example.duongnl_selling.core.sell.service.BillService;
import com.example.duongnl_selling.entity.Account;
import com.example.duongnl_selling.entity.Bill;
import com.example.duongnl_selling.infrastructure.constant.BillStatus;
import com.example.duongnl_selling.repository.CartRepository;
import com.example.duongnl_selling.repository.ProductRepository;
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
    private CartRepository cartRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<BillResponse> findByAccount(Long id) {
        List<Bill> listBill = billRepository.findByAccount(id);
        TypeToken<List<BillResponse>> typeToken = new TypeToken<>() {
        };
        List<BillResponse> listBillResponse = mapper.map(listBill, typeToken.getType());
        return listBillResponse;
    }

    @Override
    public Bill create(CreateBillRequest request) {
        Account account = accountRepository.findById(request.getIdAccount()).get();

        Bill bill = new Bill();
        String code = createCodeBill();
        bill.setCode("HD" + code);
        bill.setCreateDate(LocalDateTime.now());
        bill.setStatus(BillStatus.PAYING.getBillStatus());
        bill.setAccount(account);

        return billRepository.save(bill);
    }

    @Override
    public String pay(CartRequest request) {
        List<ProductCartResponse> listProduct = request.getProduct();
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = productRepository.findById(listProduct.get(i).getId()).get();
            Integer remainQuantity = product.getQuantity() - listProduct.get(i).getQuantity();
            changeQuantityProduct(listProduct.get(i).getId(), remainQuantity);
        }


        createCart(request);

        updateBill(request.getBill());
        return "Pay successfull !!";
    }

    @Override
    public List<CartResponse> findBillDetail(Long id) {
        List<Cart> listCart = cartRepository.findBillDetail(id);
        TypeToken<List<CartResponse>> typeToken = new TypeToken<>() {
        };

        return mapper.map(listCart, typeToken.getType());
    }

    private Bill updateBill(BillResponse request) {
        Account account = mapper.map(request.getAccount(), Account.class);
        Bill bill = new Bill();
        bill.setId(request.getId());
        bill.setCode(request.getCode());
        bill.setCreateDate(request.getCreateDate());
        bill.setCreatePayment(LocalDateTime.now());
        bill.setIntoMoney(request.getIntoMoney());
        bill.setNote(request.getNote());
        bill.setStatus(BillStatus.PAID.getBillStatus());
        bill.setAccount(account);
        return billRepository.save(bill);
    }

    private void createCart(CartRequest request) {
        Bill bill = billRepository.findById(request.getBill().getId()).get();
        List<ProductCartResponse> listProduct = request.getProduct();
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = productRepository.findById(listProduct.get(i).getId()).get();
            Cart cart = new Cart();
            cart.setQuantity(listProduct.get(i).getQuantity());
            cart.setBill(bill);
            cart.setProduct(product);
            cartRepository.save(cart);
        }
    }

    private void changeQuantityProduct(Long id, Integer quantity) {
        productRepository.updateQuantity(quantity, id);
    }

    private String createCodeBill() {
        LocalDateTime now = LocalDateTime.now();
        String createDate = now.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        int count = billRepository.findAll().size() + 1;
        String code = createDate + count;
        return code;
    }
}
