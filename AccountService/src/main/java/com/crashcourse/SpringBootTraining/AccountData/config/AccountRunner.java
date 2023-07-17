package com.crashcourse.SpringBootTraining.AccountData.config;

import com.crashcourse.SpringBootTraining.AccountData.Entity.AuthRecord;
import com.crashcourse.SpringBootTraining.AccountData.Entity.Account;
import com.crashcourse.SpringBootTraining.AccountData.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class AccountRunner implements ApplicationRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Account> account = accountRepository.findById(1L);
        if (account.isEmpty()) {
            log.info("creating system account");
            AuthRecord authRecord = new AuthRecord();
            authRecord.setUsername("system@gmail.com");
            authRecord.setPassword("system@123");
            Account systemAccount = new Account(1L, "system", "system", "system@example.com", "(555)555-5555", "SYSTEM", authRecord);
            authRecord.setPersonId(systemAccount);
            accountRepository.save(systemAccount);

        }


    }
}
