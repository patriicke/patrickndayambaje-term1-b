package com.example.simplecalculator.controllers;


import static org.junit.Assert.assertEquals;

import com.example.simplecalculator.dtos.DoMathRequest;
import com.example.simplecalculator.utils.CalcResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerE2ETest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void doMathOperation_Success(){
        DoMathRequest dto = new DoMathRequest(2, 5, "+");

        ResponseEntity<CalcResponse> response = this.restTemplate.postForEntity("/api/v1/math/do-math",dto,CalcResponse.class);

        assertEquals(HttpStatus.OK
                , response.getStatusCode().value());
    }
}

