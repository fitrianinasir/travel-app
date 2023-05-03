package com.travel.orders.service;

import com.travel.orders.dto.OrderDTO.ResponseOrder;
import com.travel.orders.dto.ValidateUserDTO.ResponseValidateUser;
import com.travel.orders.model.OrdersModel;
import com.travel.orders.model.RequestCatalogCharging;
import org.springframework.http.ResponseEntity;

public interface IRestService {
    public String getAllCatalog();



    ResponseEntity<ResponseOrder> catalogCharging(RequestCatalogCharging requestCatalogCharging);

    ResponseValidateUser validateUser(String username_app);

    void update(OrdersModel ordersModel);
}
