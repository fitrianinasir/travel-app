package com.travel.orders.dto.OrderDTO;

public class SaveOrder {
    private Integer id_user;
    private Integer id_package;
    private Integer id_payment;
    private Integer id_notification;
    private Integer num_of_orders;
    private String start_order_date;
    private String end_order_date;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_package() {
        return id_package;
    }

    public void setId_package(Integer id_package) {
        this.id_package = id_package;
    }

    public Integer getId_payment() {
        return id_payment;
    }

    public void setId_payment(Integer id_payment) {
        this.id_payment = id_payment;
    }

    public Integer getId_notification() {
        return id_notification;
    }

    public void setId_notification(Integer id_notification) {
        this.id_notification = id_notification;
    }

    public Integer getNum_of_orders() {
        return num_of_orders;
    }

    public void setNum_of_orders(Integer num_of_orders) {
        this.num_of_orders = num_of_orders;
    }

    public String getStart_order_date() {
        return start_order_date;
    }

    public void setStart_order_date(String start_order_date) {
        this.start_order_date = start_order_date;
    }

    public String getEnd_order_date() {
        return end_order_date;
    }

    public void setEnd_order_date(String end_order_date) {
        this.end_order_date = end_order_date;
    }
}
