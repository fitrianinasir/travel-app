package com.travel.payment.db.paymentdb.repository;

import com.travel.payment.db.paymentdb.model.UserAuthModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuthModel, Integer> {
    UserAuthModel findByUsername(String username);
}
