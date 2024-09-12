package com.borsaistanbul.zz03_di;

import com.borsaistanbul.zz03_di.di.Motor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotorTest {

    @Test
    public void tipGetirTest(){
        Motor motor = new Motor("Benzinli");
        assertEquals("Benzinli",motor.tipGetir());

        Motor motor2 = new Motor("Elektirikli");
        assertEquals("Elektirikli",motor2.tipGetir());
    }
}
