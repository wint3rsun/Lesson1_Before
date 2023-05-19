package com.crashcourse.L8.ProfileData;

import com.crashcourse.L8.ProfileData.Entity.AuthRecord;
import com.crashcourse.L8.ProfileData.Entity.Profile;
import com.crashcourse.L8.ProfileData.service.ProfileService;
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
class ProfileDataApplicationTests {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private ProfileService profileService = new ProfileService();

	@Test
	void contextLoads() {
		Profile profile1 = new Profile(0l, "BigBird", "Sesame Street", "bigbird@example.com", "(555)555-1234", "USER", new AuthRecord());
		Mockito.when(restTemplate.getForEntity("", Profile.class)).thenReturn(new ResponseEntity(profile1, HttpStatus.OK));

		Profile profile2 = profileService.createProfile(profile1);
		Assertions.assertEquals(profile1, profile2);
		System.out.println("Mockito Test Successful!");
	}

}
