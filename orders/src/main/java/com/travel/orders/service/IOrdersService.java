package com.travel.orders.service;


import com.travel.orders.model.OrdersModel;

import java.util.List;

public interface IOrdersService {
    List<OrdersModel> allOrders();
}
