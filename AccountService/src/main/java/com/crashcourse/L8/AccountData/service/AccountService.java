package com.crashcourse.L8.AccountData.service;


import com.crashcourse.L8.AccountData.Entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    @Value("${server.port}")
    private int port;



    public Account createAccount(Account accountRequest) {
        return accountRequest;
    }
}
