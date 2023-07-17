package com.crashcourse.SpringBootTraining.AccountData;

import com.crashcourse.SpringBootTraining.AccountData.Entity.AuthRecord;
import com.crashcourse.SpringBootTraining.AccountData.Entity.Account;
import com.crashcourse.SpringBootTraining.AccountData.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AccountDataApplicationTests {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private AccountService accountService = new AccountService();

	@Test
	void contextLoads() {
		Account account1 = new Account(0l, "BigBird", "Sesame Street", "bigbird@example.com", "(555)555-1234", "USER", new AuthRecord());
		Mockito.when(restTemplate.getForEntity("", Account.class)).thenReturn(new ResponseEntity(account1, HttpStatus.OK));

		Account account2 = accountService.createAccount(account1);
		Assertions.assertEquals(account1, account2);
		System.out.println("Mockito Test Successful!");
	}

}
