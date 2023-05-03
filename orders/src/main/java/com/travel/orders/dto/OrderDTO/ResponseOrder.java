package com.travel.orders.dto.OrderDTO;

public class ResponseOrder {
    private Integer status;
    private String message;
    private ResponseOrderData data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseOrderData getData() {
        return data;
    }

    public void setData(ResponseOrderData data) {
        this.data = data;
    }
}
