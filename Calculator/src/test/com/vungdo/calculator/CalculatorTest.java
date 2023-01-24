package com.vungdo.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void canAddZeroPlusZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 0);
        assertEquals(0, result, "Was expecting sum of 0");
    }
    @Test
    public void canAddOnePlusOne() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 1);
        assertEquals(2, result);
    }
    @Test
    public void annuityExample() {
        Calculator calculator = new Calculator();
        String answer = calculator.calcAnnuity("22000", 7, "0.06", 1);
        assertEquals("$184,664.43", answer);
    }

    @Test
    public void annuityPractice2() {
        Calculator calculator = new Calculator();
        String answer = calculator.calcAnnuity("1200", 10, "0.08", 4);
        assertEquals("$72,482.38", answer);
    }

}
