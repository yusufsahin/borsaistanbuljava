package com.borsaistanbul.zz03_di;

import com.borsaistanbul.zz03_di.di.Araba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zz03DiApplication {

    public static void main(String[] args) {

        //SpringApplication.run(Zz03DiApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(Zz03DiApplication.class, args);
        Araba araba = context.getBean(Araba.class);
        araba.baslat();
    }

}
