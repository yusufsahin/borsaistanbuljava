package com.borsaistanbul.zz03_di;

import com.borsaistanbul.zz03_di.di.Araba;
import com.borsaistanbul.zz03_di.di.Motor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArabaTest {

    @Test
    public void baslatTest() {
        Motor mockMotor= new Motor("Benzinli");

        Araba araba= new Araba(mockMotor);

        assertNotNull(araba);
    }
}
