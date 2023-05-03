package com.travel.orders.service;

import com.travel.orders.model.OrdersModel;
import com.travel.orders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrdersService implements IOrdersService{

    private static RestTemplate restTemplate = null;
    private static HttpHeaders httpHeaders;
    @Autowired
    OrdersRepository ordersRepository;

    public OrdersService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Autowired
    public List<OrdersModel> allOrders(){
        return ordersRepository.findAll();
    }

    public static Object getUserService(){
        String url = "http://localhost:8081/api/all";
        HttpEntity entity = new HttpEntity("", httpHeaders);
        Object res = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        return res;

    }
}
