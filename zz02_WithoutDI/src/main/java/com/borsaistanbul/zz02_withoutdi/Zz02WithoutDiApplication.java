package com.borsaistanbul.zz02_withoutdi;

import com.borsaistanbul.zz02_withoutdi.di.Araba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Zz02WithoutDiApplication {

    public static void main(String[] args) {

        //SpringApplication.run(Zz02WithoutDiApplication.class, args);
        Araba araba = new Araba();
        araba.baslat();

    }

}
