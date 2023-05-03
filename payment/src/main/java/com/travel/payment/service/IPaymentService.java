package com.travel.payment.service;

import com.travel.payment.db.catalogdb.model.CatalogModel;
import com.travel.payment.dto.PaymentCreateDto;
import com.travel.payment.dto.PaymentReqDto;
import com.travel.payment.dto.PaymentUpdateDto;
import com.travel.payment.db.paymentdb.model.PaymentModel;
import com.travel.payment.db.userdb.model.UserModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IPaymentService {
//    public PaymentModel createPayment(PaymentCreateDto paymentCreateDto);
    public Boolean checkPin(PaymentReqDto paymentReqDto);
    public Map<String, Object> createPaymentSuccess(PaymentReqDto paymentReqDto) throws ParseException;
    public Map<String, Object> createPaymentFailed(PaymentReqDto paymentReqDto) throws ParseException;
    public Map<String, Object> createPayment(PaymentReqDto paymentReqDto) throws ParseException;
    public PaymentModel updatePayment(PaymentUpdateDto paymentUpdateDto, Integer id) throws ParseException;
    public Map<String, Object> deletePayment(Integer id);
    public PaymentModel getPayment(Integer id);
    public List<PaymentModel> getAllPayment();
    public List<UserModel> getAllUser();
    public List<CatalogModel> getAllCatalog();
}
