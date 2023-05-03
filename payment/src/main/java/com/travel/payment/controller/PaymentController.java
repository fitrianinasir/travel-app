package com.travel.payment.controller;

import com.travel.payment.dto.PaymentCreateDto;
import com.travel.payment.dto.PaymentReqDto;
import com.travel.payment.dto.PaymentUpdateDto;
import com.travel.payment.handler.RespHandler;
import com.travel.payment.service.imple.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("api")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

//    @PostMapping("/payment")
//    public ResponseEntity<Object> createCatalogDetails(@RequestBody @Valid PaymentCreateDto paymentCreateDto){
//        return RespHandler.responseBuilder("sukses, data payment telah berhasil di-simpan",HttpStatus.OK, paymentService.createPayment(paymentCreateDto));
//    }
    @PostMapping("/payment")
    public ResponseEntity<Object> createCatalogDetails(@RequestBody @Valid PaymentReqDto paymentReqDto) throws ParseException {
        if(paymentService.checkPin(paymentReqDto).equals(true)){
            return RespHandler.responseBuilder("sukses, data payment telah berhasil di-simpan",HttpStatus.OK, paymentService.createPaymentSuccess(paymentReqDto));
        }else {
            return RespHandler.responseBuilder("Payment Gagal",HttpStatus.BAD_REQUEST, paymentService.createPaymentFailed(paymentReqDto));
        }
    }

    @PutMapping("/payment/{id}")
    public ResponseEntity<Object> updatePaymentDetails(@RequestBody @Valid PaymentUpdateDto paymentUpdateDto, @PathVariable Integer id){
        return RespHandler.responseBuilder("sukses, data payment telah berhasil di-update",HttpStatus.OK, paymentService.updatePayment(paymentUpdateDto, id));
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Object> getPaymentDetails(@PathVariable Integer id){
        return RespHandler.responseBuilder("sukses, berikut detail data payment",HttpStatus.OK, paymentService.getPayment(id));
    }

    @GetMapping("/payment")
    public ResponseEntity<Object> listPaymentDetails(){
        return RespHandler.responseBuilder("sukses, berikut list semua data payment",HttpStatus.OK, paymentService.getAllPayment());
    }

    @DeleteMapping("/payment/{id}")
    public ResponseEntity<Object> deletePaymentDetails(@PathVariable Integer id) {
        return RespHandler.responseBuilder("sukses, data payment telah berhasil di-delete",HttpStatus.OK, paymentService.deletePayment(id));
    }

    @GetMapping("/users")
    public ResponseEntity<Object> listUserDetails(){
        return RespHandler.responseBuilder("sukses, berikut list semua data users",HttpStatus.OK, paymentService.getAllUser());
    }

    @GetMapping("/catalog")
    public ResponseEntity<Object> listCatalogDetails(){
        return RespHandler.responseBuilder("sukses, berikut list semua data catalog",HttpStatus.OK, paymentService.getAllCatalog());
    }

//    @GetMapping("/payment/{id}")
//    public ResponseEntity<PaymentModel> get(@PathVariable Integer id){
//        try {
//            PaymentModel paymentModel = paymentService.get(id);
//            return new ResponseEntity<PaymentModel>(paymentModel, HttpStatus.OK);
//        } catch (NoSuchElementException e){
//            return new ResponseEntity<PaymentModel>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/payment")
//    public void add(@RequestBody PaymentModel catalogModel){
//        paymentService.save(catalogModel);
//    }
//
//    @PutMapping("/payment/{id}")
//    public ResponseEntity<?> update(@RequestBody PaymentModel catalogModel, @PathVariable Integer id){
//        try {
//            PaymentModel existPayment = paymentService.get(id);
//            paymentService.save(catalogModel);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/payment/{id}")
//    public void delete(@PathVariable Integer id) {
//        paymentService.delete(id);
//    }
}
