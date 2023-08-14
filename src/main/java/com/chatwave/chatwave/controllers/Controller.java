package com.chatwave.chatwave.controllers;

import com.chatwave.chatwave.error.UserNotFoundException;
import com.chatwave.chatwave.models.UserModel;
import com.chatwave.chatwave.service.UserService;
import org.apache.catalina.User;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "chatWave/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List <UserModel> getUsers(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "username", required = false) String username
    ) {
        List<UserModel> userModels = new ArrayList<>();
        Optional<UserModel> userModel = null;

       if (email != null)
           userModel = userService.getUserByEmail(email);

       if (username != null)
           userModel = userService.getUserByUsername(username);

       if (username == null && email == null)
           return (List<UserModel>) userService.getAllUsers();

       if (!userModel.isPresent())
           throw new UserNotFoundException();

       userModels.add(userModel.get());
       return userModels;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserModel createUser(
            @RequestBody UserModel userModel) {

        userService.createUser(userModel);
        UserModel userModel1 = userModel;
        return userModel1;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteUser(
            @PathVariable(value = "id") Integer id) {

        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserModel getUserById(
            @PathVariable(value = "id") Integer id
    ) {
        Optional<UserModel> userModel = userService.getUserById(id);

        if (!userModel.isPresent())
            throw new UserNotFoundException();

        return userModel.get();
    }

}
