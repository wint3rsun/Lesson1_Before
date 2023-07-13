package com.crashcourse.L8.AccountData.controller;

import com.crashcourse.L8.AccountData.Entity.Account;
import com.crashcourse.L8.AccountData.service.AccountService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/account")
public class AccountController {
    @Autowired
    AccountService accountService;


    @PostMapping
    private ResponseEntity<Account> createAccount(@Parameter(name = "PersonRequest",required = true) @RequestBody Account accountRequest) {

        return new ResponseEntity<>(accountService.createAccount(accountRequest), HttpStatus.OK);

    }
}
