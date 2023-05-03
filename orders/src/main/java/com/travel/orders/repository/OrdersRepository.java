package com.travel.orders.repository;

import com.travel.orders.model.OrdersModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersModel, Integer> {
    List<OrdersModel> findAll();


    @Transactional
    @Modifying
    @Query(value="UPDATE tbl_orders set id_notification = :idNotification where id = :idOrder", nativeQuery = true)
    void updateNotification(@Param("idOrder") Integer idOrder, @Param("idNotification") Integer idNotification);


}
