package com.example.duongnl_selling.core.user.rest;

import com.example.duongnl_selling.core.user.dto.request.CreateAccountRequest;
import com.example.duongnl_selling.core.user.dto.request.ForgotPasswordRequest;
import com.example.duongnl_selling.core.user.dto.request.LoginAccountRequest;
import com.example.duongnl_selling.core.user.dto.request.UpdateAccountRequest;
import com.example.duongnl_selling.core.user.service.AccountService;
import com.example.duongnl_selling.infrastructure.config.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseObject findAll() {
        return new ResponseObject(accountService.findAll());
    }

    @PostMapping("/create")
    public ResponseObject create(@RequestBody CreateAccountRequest request) {
        return new ResponseObject(accountService.save(request));
    }

    @PutMapping("/update")
    public ResponseObject update(@RequestBody UpdateAccountRequest request) {
        return new ResponseObject(accountService.update(request));
    }

    @PostMapping("/login")
    public ResponseObject login(@RequestBody LoginAccountRequest request) {
        return new ResponseObject(accountService.login(request));
    }

    @GetMapping("/{id}")
    public ResponseObject findById(@PathVariable("id") Long id) {
        return new ResponseObject(accountService.findById(id));
    }

    @PostMapping("/forgot-password/{email}")
    public ResponseObject forgotPassword(@PathVariable("email") String email) {
        return new ResponseObject(accountService.forgotPassword(email));
    }

}
