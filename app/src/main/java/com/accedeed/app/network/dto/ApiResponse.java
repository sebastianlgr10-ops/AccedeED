package com.accedeed.app.network.dto;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private int statusCode;

    public ApiResponse() {}

    public ApiResponse(boolean success, String message, T data, int statusCode) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }

    // Getters
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }
    public int getStatusCode() { return statusCode; }

    // Setters
    public void setSuccess(boolean success) { this.success = success; }
    public void setMessage(String message) { this.message = message; }
    public void setData(T data) { this.data = data; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
}
