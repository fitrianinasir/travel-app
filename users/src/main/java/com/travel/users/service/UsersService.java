package com.travel.users.service;

import com.travel.users.model.UsersModel;
import com.travel.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService{
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UsersModel> allUsers(){
        return usersRepository.findAllByOrderByLastName();
    }

    @Override
    public Object getUserByUsername(String username){
        return usersRepository.findByUsername(username);
    }

    @Override
    public Object getUser(Integer id){

        return usersRepository.findById(id);
    }


    @Override
    public void insert(UsersModel usersModel){
        usersRepository.save(usersModel);
    }

    @Override
    public void update(UsersModel usersModel){
        usersRepository.save(usersModel);
    }

    @Override
    public void delete(UsersModel usersModel){
        usersRepository.deleteById(usersModel.getId());
    }
}
