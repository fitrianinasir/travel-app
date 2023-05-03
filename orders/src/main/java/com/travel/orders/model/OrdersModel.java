package com.travel.orders.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_orders")
public class OrdersModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="id_user")
    private Integer idUser;

    @Column(name="id_payment")
    private Integer id_payment;

    @Column(name="id_notification")
    private Integer id_notification;

    @Column(name="num_of_orders")
    private Integer num_of_orders;

    @Column(name="start_order_date")
    private String startOrderDate;

    @Column(name="end_order_date")
    private String endOrderDate;

    @Column(name="date")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getStartOrderDate() {
        return startOrderDate;
    }

    public void setStartOrderDate(String startOrderDate) {
        this.startOrderDate = startOrderDate;
    }

    public String getEndOrderDate() {
        return endOrderDate;
    }

    public void setEndOrderDate(String endOrderDate) {
        this.endOrderDate = endOrderDate;
    }

}
