package com.crashcourse.L8.ProfileData.config;

import com.crashcourse.L8.ProfileData.Entity.AuthRecord;
import com.crashcourse.L8.ProfileData.Entity.Profile;
import com.crashcourse.L8.ProfileData.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ProfileRunner implements ApplicationRunner {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Profile> profile = profileRepository.findById(1L);
        if (profile.isEmpty()) {
            log.info("creating system profile");
            AuthRecord authRecord = new AuthRecord();
            authRecord.setUsername("system@gmail.com");
            authRecord.setPassword("system@123");
            Profile systemProfile = new Profile(1L, "system", "system", "system@example.com", "(555)555-5555", "SYSTEM", authRecord);
            authRecord.setPersonId(systemProfile);
            profileRepository.save(systemProfile);

        }


    }
}
