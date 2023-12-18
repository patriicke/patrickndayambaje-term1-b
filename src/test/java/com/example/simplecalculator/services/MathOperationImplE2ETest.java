package com.example.simplecalculator.services;

import com.example.simplecalculator.controllers.MathController;
import com.example.simplecalculator.dtos.DoMathRequest;
import com.example.simplecalculator.exceptions.InvalidOperationException;
import com.example.simplecalculator.services.impl.MathOperationImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@SpringBootTest
@WebMvcTest(MathController.class)
class MathOperationImplE2ETest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathOperationImpl mathOperation;

    @Test
    void testDoMath_Successful() throws Exception {
        DoMathRequest request = new DoMathRequest(2, 3, "+");
        when(mathOperation.doMath(2, 3, "+")).thenReturn(5.0);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/math/do-math")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\": 2, \"operand2\": 3, \"operation\": \"+\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(5.0));
    }

    @Test
    void testDoMath_InvalidOperation() throws Exception {
        // Arrange
        DoMathRequest request = new DoMathRequest(2, 3, "#");
        when(mathOperation.doMath(2, 3, "#")).thenThrow(new InvalidOperationException("Invalid operation"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/math/do-math")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\": 2, \"operand2\": 3, \"operation\": \"#\"}"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Invalid operation"));
    }
}
