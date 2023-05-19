package com.crashcourse.L8.ProfileData.service;


import com.crashcourse.L8.ProfileData.Entity.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProfileService {

    @Value("${server.port}")
    private int port;



    public Profile createProfile(Profile profileRequest) {
        return profileRequest;
    }
}
