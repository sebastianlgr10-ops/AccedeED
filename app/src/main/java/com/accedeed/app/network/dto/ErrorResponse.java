package com.accedeed.app.network.dto;

public class ErrorResponse {
    private String message;
    private int statusCode;
    private String errorCode;

    public ErrorResponse() {}

    public ErrorResponse(String message, int statusCode, String errorCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    // Getters
    public String getMessage() { return message; }
    public int getStatusCode() { return statusCode; }
    public String getErrorCode() { return errorCode; }

    // Setters
    public void setMessage(String message) { this.message = message; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }
}
