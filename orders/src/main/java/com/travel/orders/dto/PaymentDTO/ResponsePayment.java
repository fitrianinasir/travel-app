package com.travel.orders.dto.PaymentDTO;

public class ResponsePayment {
    private Integer status;
    private String message;
    private ResponsePaymentData data;

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

    public ResponsePaymentData getData() {
        return data;
    }

    public void setData(ResponsePaymentData data) {
        this.data = data;
    }
}
