package com.example.duongnl_selling.core.user.service.impl;

import com.example.duongnl_selling.core.user.dto.request.*;
import com.example.duongnl_selling.core.user.dto.response.AccountForgotResponse;
import com.example.duongnl_selling.infrastructure.constant.RoleAccount;
import com.example.duongnl_selling.core.user.dto.response.AccountResponse;
import com.example.duongnl_selling.repository.AccountRepository;
import com.example.duongnl_selling.core.user.service.AccountService;
import com.example.duongnl_selling.entity.Account;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private JavaMailSender mailSender;

    private int randomNumber = (int) (Math.random() * 1000000);

    @Override
    public List<AccountResponse> findAll() {
        List<Account> listAccount = accountRepository.findAll();
        TypeToken<List<AccountResponse>> typeToken = new TypeToken<>() {
        };

        List<AccountResponse> listAccountResponse = mapper.map(listAccount, typeToken.getType());
        return listAccountResponse;
    }

    @Override
    public Account save(CreateAccountRequest request) {
        Account account = new Account();
        if (request.getUsername() != null) {
            account.setUsername(request.getUsername());
        }
        if (request.getPassword() != null) {
            account.setPassword(request.getPassword());
        }
        if (request.getFullName() != null) {
            account.setFullName(request.getFullName());
        }
        if (request.getEmail() != null) {
            account.setEmail(request.getEmail());
        }
        if (request.getPhoneNumber() != null) {
            account.setPhoneNumber(request.getPhoneNumber());
        }
        account.setAvatar(request.getAvatar());
        account.setRole(RoleAccount.USER.getRole());

        return accountRepository.save(account);
    }

    @Override
    public Account update(UpdateAccountRequest request) {
        Account account = new Account();
        if (request.getId() != null) {
            account.setId(request.getId());
        }
        if (request.getUsername() != null) {
            account.setUsername(request.getUsername());
        }
        if (request.getPassword() != null) {
            account.setPassword(request.getPassword());
        }
        if (request.getFullName() != null) {
            account.setFullName(request.getFullName());
        }
        if (request.getEmail() != null) {
            account.setEmail(request.getEmail());
        }
        if (request.getPhoneNumber() != null) {
            account.setPhoneNumber(request.getPhoneNumber());
        }
        account.setAvatar(request.getAvatar());
        account.setRole(RoleAccount.USER.getRole());

        return accountRepository.save(account);
    }

    @Override
    public Account login(LoginAccountRequest request) {
        for (Account account : accountRepository.findAll()) {
            if (account.getUsername().equals(request.getUsername())
                    && account.getPassword().equals(request.getPassword())) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Account findById(Long id) {
        Account account = accountRepository.findById(id).get();
        return account;
    }

    @Override
    public AccountForgotResponse forgotPassword(String email) {
        boolean emailExsist = false;

        for (Account account : accountRepository.findAll()) {
            if (account.getEmail().equals(email)) {
                emailExsist = true;
            }
        }
        if (emailExsist) {
            Integer code = senderEmail(email);
            Account account = accountRepository.findAccountByEmail(email);
            AccountResponse accountResponse = mapper.map(account, AccountResponse.class);

            AccountForgotResponse accountForgot = new AccountForgotResponse();
            accountForgot.setCode(code);
            accountForgot.setAccount(accountResponse);
            return accountForgot;
        }
        return null;
    }


    private Integer senderEmail(String email) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nguyenleduong03@gmail.com");
        message.setTo(email);
        message.setText("Mã xác nhận của bạn là: " + randomNumber);

        System.out.println(randomNumber);

        message.setSubject("Có cái mật khẩu cũng quên !!!");
        mailSender.send(message);

        return randomNumber;
    }

}
