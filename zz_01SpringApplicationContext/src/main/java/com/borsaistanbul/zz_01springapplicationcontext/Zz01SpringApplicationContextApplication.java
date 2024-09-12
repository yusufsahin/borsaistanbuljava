package com.borsaistanbul.zz_01springapplicationcontext;

import com.borsaistanbul.zz_01springapplicationcontext.service.impl.MyServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zz01SpringApplicationContextApplication {

    public static void main(String[] args) {
       // SpringApplication.run(Zz01SpringApplicationContextApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(Zz01SpringApplicationContextApplication.class, args);
        MyServiceImpl myService = context.getBean(MyServiceImpl.class);
        myService.printMessage();
    }

}
