package com.borsaistanbul.zz_01springapplicationcontext.service.impl;

import com.borsaistanbul.zz_01springapplicationcontext.service.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void printMessage() {
        System.out.println("Merhaba,Spring Boot");
    }
}
