package com.travel.orders.controller;

import com.travel.orders.model.OrdersModel;
import com.travel.orders.repository.OrdersRepository;
import com.travel.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<OrdersModel> findAll(){
        return ordersRepository.findAll();
    }
}
