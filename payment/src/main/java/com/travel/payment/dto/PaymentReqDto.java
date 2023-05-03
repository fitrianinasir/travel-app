package com.travel.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Data
@Builder
public class PaymentReqDto {

    @NotNull(message = "Invalid iduser: iduser is NULL")
    private Integer idUser;

    @NotNull(message = "Invalid iduser: iduser is NULL")
    private Integer idOrder;

    @NotBlank(message = "Invalid destination: Empty destination")
    @NotNull(message = "Invalid destination: destination is NULL")
    private String destination;

    @NotNull(message = "Invalid Start date: Start date is NULL")
    private Date startDate;

    @NotNull(message = "Invalid End date: End date is NULL")
    private Date endDate;

    @NotNull(message = "Invalid Total Person: Total Person is NULL")
    private Integer totalPerson;

    @NotBlank(message = "Invalid payment type: Empty payment type")
    @NotNull(message = "Invalid payment type: payment type is NULL")
    private String paymentType;

    @NotBlank(message = "Invalid total price: Empty total price")
    @NotNull(message = "Invalid total price: total price is NULL")
    private String totalPrice;

    @NotBlank(message = "Invalid pin: Empty pin")
    @NotNull(message = "Invalid pin: pin is NULL")
    private String pin;
}
