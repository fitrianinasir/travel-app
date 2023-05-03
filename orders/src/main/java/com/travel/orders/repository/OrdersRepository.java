package com.travel.orders.repository;

import com.travel.orders.model.OrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersModel, Integer> {
    List<OrdersModel> findAll();


}
