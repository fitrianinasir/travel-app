package com.travel.orders.service;

import com.travel.orders.dto.PaymentDTO.RequestPayment;
import com.travel.orders.dto.OrderDTO.ResponseOrder;
import com.travel.orders.dto.PaymentDTO.ResponsePayment;
import com.travel.orders.dto.ValidateUserDTO.ResponseValidateUser;
import com.travel.orders.model.OrdersModel;
import com.travel.orders.model.RequestCatalogCharging;
import com.travel.orders.repository.OrdersRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class RestService implements IRestService{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public String getAllCatalog(){
        String result = restTemplate.getForObject("http://localhost:8082/api/catalog", String.class);
        return result;
    }

    @Override
    public ResponseValidateUser validateUser(String username_app){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RequestCatalogCharging> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseValidateUser responseEntity = restTemplate.getForObject(
                "http://localhost:8081/api/user-validation/"+username_app,
                ResponseValidateUser.class
        );
        if(responseEntity == null){
            return null;
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<ResponseOrder> catalogCharging(
            RequestCatalogCharging requestCatalogCharging)
          {


        String username = "fitri";
        String password = "fitri";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<RequestCatalogCharging> httpEntity = new HttpEntity<>(requestCatalogCharging, httpHeaders);

        ResponseValidateUser validateUser = restTemplate.getForObject(
                "http://localhost:8080/validate-user/fitrianinasir",
                ResponseValidateUser.class
        );


        if(validateUser == null){
            return null;
        }

        ResponseOrder response = restTemplate.postForObject(
                "http://localhost:8082/api/catalog/booking",
                httpEntity,
                ResponseOrder.class );


        OrdersModel ordersModel = new OrdersModel();
        ordersModel.setIdUser(validateUser.getId());
        ordersModel.setId_notification(null);
        ordersModel.setId_notification(null);
        ordersModel.setNum_of_orders(Integer.parseInt(response.getData().getTotalPerson()));
        ordersModel.setStartOrderDate(response.getData().getStartDate());
        ordersModel.setEndOrderDate(response.getData().getEndDate());
        ordersModel.setDate(String.valueOf(LocalDate.now()));
        ordersRepository.save(ordersModel);

        RequestPayment requestPayment = new RequestPayment();
        requestPayment.setIdUser(validateUser.getId());
        requestPayment.setIdOrder(ordersModel.getId());
        requestPayment.setDestination(response.getData().getDestination());
        requestPayment.setStartDate(response.getData().getStartDate());
        requestPayment.setEndDate(response.getData().getEndDate());
        requestPayment.setTotalPerson(Integer.parseInt(response.getData().getTotalPerson()));
        requestPayment.setPaymentType("Debit BCA");
        requestPayment.setTotalPrice(response.getData().getTotalPrice());
        requestPayment.setPin(validateUser.getPin());

        HttpEntity<RequestPayment> httpEntityPayment = new HttpEntity<>(requestPayment, httpHeaders);

        ResponsePayment responsePayment = restTemplate.postForObject(
                "http://localhost:8083/api/payment",
                httpEntityPayment,
                ResponsePayment.class
        );


        return ResponseEntity.ok(response);

    }

    public void requestPayment(){

    }
}

