package com.borsaistanbul.zz03_di.di;

import org.springframework.stereotype.Component;

@Component
public class Motor {
    private String tip;

    public Motor(String tip) {
        this.tip = tip;
    }

    public String tipGetir() {
        return this.tip;
    }
}
