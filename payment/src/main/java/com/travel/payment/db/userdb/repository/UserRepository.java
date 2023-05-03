package com.travel.payment.db.userdb.repository;

import com.travel.payment.db.userdb.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
