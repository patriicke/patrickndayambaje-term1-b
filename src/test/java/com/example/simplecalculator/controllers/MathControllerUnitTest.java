package com.example.simplecalculator.controllers;

import com.example.simplecalculator.dtos.DoMathRequest;
import com.example.simplecalculator.exceptions.InvalidOperationException;
import com.example.simplecalculator.services.impl.MathOperationImpl;
import com.example.simplecalculator.utils.CalcResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathControllerUnitTest {

    @InjectMocks
    private MathController mathController;

    @Mock
    private MathOperationImpl mathOperation;

    @Test
    public void testDoMathSuccess() throws InvalidOperationException {
        // Stub the math operation to return 10.0 for any input
        when(mathOperation.doMath(any(), any(), any())).thenReturn(10.0);

        // Make a request to the controller
        ResponseEntity<CalcResponse> response = mathController.doMath(new DoMathRequest(5, 5, "+"));

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10.0, response.getBody().getResult(), 0.001);
    }
}
