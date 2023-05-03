package com.travel.orders.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.travel.orders.dto.OrderDTO.ResponseOrder;
import com.travel.orders.dto.ValidateUserDTO.ResponseValidateUser;
import com.travel.orders.model.RequestCatalogCharging;
import com.travel.orders.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrdersClientController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private RestService restService;



@PutMapping("/booking")
public ResponseEntity<ResponseOrder> requestCatalogCharging(@RequestBody RequestCatalogCharging requestCatalogCharging) {
    ResponseEntity<ResponseOrder> responseEntity = restService.catalogCharging(requestCatalogCharging);
    return responseEntity;
}

@GetMapping("/validate-user/{username_app}")
public ResponseValidateUser validateUser(@PathVariable("username_app") String username_app) throws JsonProcessingException {
    ResponseValidateUser responseEntity = restService.validateUser(username_app);
    if(responseEntity == null){
        return null;
    }
    return responseEntity;
}
}
