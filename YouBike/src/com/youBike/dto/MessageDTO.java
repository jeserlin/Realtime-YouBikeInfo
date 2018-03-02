package com.youBike.dto;

public class MessageDTO<T> {

	// execute result
    private boolean success;
    // execute message
    private String message;
    // Other DTO Object
    private T data;
    
    public MessageDTO() {}
    
    public MessageDTO(boolean success, String message) {
        this(success, message, null);
    }

    public MessageDTO(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageDTO[success=" + this.success + ", message=" + this.message + ", data=" + this.data + "]";
    }
}
