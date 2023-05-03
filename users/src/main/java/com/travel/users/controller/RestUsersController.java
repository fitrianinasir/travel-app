package com.travel.users.controller;

import com.travel.users.model.UsersModel;
import com.travel.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class RestUsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<UsersModel> findAll(){
        return usersRepository.findAll();
    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsersModel findUserById(@PathVariable("id") Integer id){
        return usersRepository.findUserById(id);
    }

    @GetMapping("user-validation/{username}")
    public @ResponseBody Object getUserByUsername(@PathVariable("username") String username){
        return usersRepository.findByUsername(username);
    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.OK)
    public UsersModel addUser(@RequestBody UsersModel usersModel){
        return usersRepository.save(usersModel);
    }

    @PutMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsersModel updateEmployee(@RequestBody UsersModel usersModel,
                                        @PathVariable("id") Integer id){
        usersModel.setId(id);
        return usersRepository.save(usersModel);
    }
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUserById(@PathVariable("id") Integer id){
        usersRepository.deleteById(id);
        return "Successfully deleted id " + id;
    }



}
