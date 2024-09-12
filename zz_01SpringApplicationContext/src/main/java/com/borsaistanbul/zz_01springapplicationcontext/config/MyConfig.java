package com.borsaistanbul.zz_01springapplicationcontext.config;

import com.borsaistanbul.zz_01springapplicationcontext.service.impl.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyServiceImpl myService()
    {

        return new MyServiceImpl();
    }
}
