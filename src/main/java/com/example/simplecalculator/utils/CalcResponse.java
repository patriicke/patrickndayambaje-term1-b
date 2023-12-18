package com.example.simplecalculator.utils;

public class CalcResponse {
    private Double result;
    private String error;

    // Constructor for successful response
    public CalcResponse(Double result) {
        this.result = result;
    }

    // Constructor for error response
    public CalcResponse(String error) {
        this.error = error;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
