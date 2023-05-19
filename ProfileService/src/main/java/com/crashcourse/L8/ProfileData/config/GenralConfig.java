package com.crashcourse.L8.ProfileData.config;


import com.crashcourse.L8.ProfileData.dto.ProfileResponseDto;
import io.swagger.v3.oas.models.OpenAPI;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GenralConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public List<ProfileResponseDto> getList(){
        return new ArrayList<ProfileResponseDto>();
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI();
    }
}
