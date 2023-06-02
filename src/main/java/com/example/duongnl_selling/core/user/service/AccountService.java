package com.example.duongnl_selling.core.user.service;


import com.example.duongnl_selling.core.user.dto.request.*;
import com.example.duongnl_selling.core.user.dto.response.AccountForgotResponse;
import com.example.duongnl_selling.core.user.dto.response.AccountResponse;
import com.example.duongnl_selling.entity.Account;

import java.util.List;

public interface AccountService {

    List<AccountResponse> findAll();

    Account save(CreateAccountRequest request);

    Account update(UpdateAccountRequest request);

    Account login(LoginAccountRequest request);

    Account findById(Long id);

    AccountForgotResponse forgotPassword(String email);

}
