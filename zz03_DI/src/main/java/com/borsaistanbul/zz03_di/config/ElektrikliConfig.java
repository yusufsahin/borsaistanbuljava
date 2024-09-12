package com.borsaistanbul.zz03_di.config;

import com.borsaistanbul.zz03_di.di.Motor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("elektrikli")
public class ElektrikliConfig {
    @Bean
    public Motor motor() {
        return new Motor("Elektrikli");
    }
}
