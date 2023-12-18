package com.example.simplecalculator.services;

import com.example.simplecalculator.exceptions.InvalidOperationException;
import com.example.simplecalculator.services.impl.MathOperationImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathOperationImplUnitTest {

    @Test
    void testDoMath_Addition() throws InvalidOperationException {
        MathOperationImpl mathOperation = new MathOperationImpl();
        double result = mathOperation.doMath(2, 3, "+");
        assertEquals(5, result, 0.001);
    }

    @Test
    void testDoMath_Subtraction() throws InvalidOperationException {
        MathOperationImpl mathOperation = new MathOperationImpl();
        double result = mathOperation.doMath(5, 3, "-");
        assertEquals(2, result, 0.001);
    }

    @Test
    void testDoMath_Multiplication() throws InvalidOperationException {
        MathOperationImpl mathOperation = new MathOperationImpl();
        double result = mathOperation.doMath(2, 3, "*");
        assertEquals(6, result, 0.001);
    }

    @Test
    void testDoMath_Division() throws InvalidOperationException {
        MathOperationImpl mathOperation = new MathOperationImpl();
        double result = mathOperation.doMath(6, 3, "/");
        assertEquals(2, result, 0.001);
    }

    @Test
    void testDoMath_DivideByZero() {
        MathOperationImpl mathOperation = new MathOperationImpl();
        assertThrows(InvalidOperationException.class, () -> mathOperation.doMath(6, 0, "/"));
    }

    @Test
    void testDoMath_UnknownOperation() {
        MathOperationImpl mathOperation = new MathOperationImpl();
        assertThrows(RuntimeException.class, () -> mathOperation.doMath(2, 3, "#"));
    }
}
