package com.travel.users.repository;

import com.travel.users.model.UsersModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
    List<UsersModel> findAllByOrderByLastName();

    UsersModel findByUsername(String username);

    UsersModel findUserById(Integer aInteger);



}
