package com.travel.orders.dto.OrderDTO;

public class ResponseOrderData {
    private Integer totalDays;
    private String destination;
    private Integer totalPrice;
    private String endDate;
    private String startDate;
    private String totalPerson;

    public Integer getTotalDays() {
        return totalDays;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTotalPerson() {
        return totalPerson;
    }

    public void setTotalPerson(String totalPerson) {
        this.totalPerson = totalPerson;
    }
}
