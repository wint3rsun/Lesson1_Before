package com.crashcourse.L8.ProfileData.controller;

import com.crashcourse.L8.ProfileData.Entity.Profile;
import com.crashcourse.L8.ProfileData.service.ProfileService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;


    @PostMapping
    private ResponseEntity<Profile> createProfile(@Parameter(name = "PersonRequest",required = true) @RequestBody Profile profileRequest) {

        return new ResponseEntity<>(profileService.createProfile(profileRequest), HttpStatus.OK);

    }
}
