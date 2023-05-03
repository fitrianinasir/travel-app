package com.travel.users.controller;

import com.travel.users.model.UsersModel;
import com.travel.users.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    @Qualifier("usersService")
    private IUsersService usersService;

    @GetMapping("/all")
    public @ResponseBody List<UsersModel> findAll(){
        return usersService.allUsers();
    }

    @GetMapping("user")
    public @ResponseBody Object getUser(@RequestParam("id") Integer id){
        return usersService.getUser(id);
    }

    @GetMapping("/add")
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("username") String username){
        UsersModel model = new UsersModel();
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setUsername(username);
        usersService.insert(model);
        return "redirect:/users/all";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") Integer id,
                            @RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("username") String username){
        UsersModel model = new UsersModel();
        model.setId(id);
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setUsername(username);
        usersService.update(model);
        return "redirect:/users/all";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id){
        UsersModel usersModel = new UsersModel();
        usersModel.setId(id);
        usersService.delete(usersModel);
        return "redirect:/users/all";
    }


}
