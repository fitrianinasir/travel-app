package com.travel.payment.db.paymentdb.repository;

import com.travel.payment.db.paymentdb.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {
}
