package com.travel.users.service;

import com.travel.users.model.UsersModel;

import java.util.List;

public interface IUsersService {
    List<UsersModel> allUsers();

    Object getUser(Integer id);

    Object getUserByUsername(String username);

    void insert(UsersModel usersModel);
    void update(UsersModel usersModel);
    void delete(UsersModel usersModel);
}
