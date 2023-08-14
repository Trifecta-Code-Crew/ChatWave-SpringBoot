package com.chatwave.chatwave.controllers;

import com.chatwave.chatwave.dao.UserDaoImp;
import com.chatwave.chatwave.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserDaoImp userDaoImp;

    @RequestMapping("/getUser")
    public List <UserModel> getUser() {
       return userDaoImp.getAllUsers();
    }

    @RequestMapping("/getUserById/{id}")
    public UserModel getUserById(@PathVariable int id) { return userDaoImp.getUserById(id); }

    @RequestMapping("/getUserByUsername/{username}")
    public UserModel getUserByUsername(@PathVariable String username) { return userDaoImp.getUserByUsername(username); }
}
