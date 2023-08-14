package com.chatwave.chatwave.controllers;

import com.chatwave.chatwave.error.UserNotFoundException;
import com.chatwave.chatwave.models.UserModel;
import com.chatwave.chatwave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<UserModel> userModel = Optional.empty();

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
        return userModel;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserModel updateUser(
            @PathVariable(value = "id") Integer id,
            @RequestBody UserModel userModel
    ) {
        /*
        IMPORTANTE PASAR TODO EL OBJETO PARA EVITAR UN 500, EJEMPLO:
        {
            "username": "usuario4",
            "password": "hashed_password1",
            "email": "usuario4@example.com",
            "name": "Usuario Cuatro",
            "profilePic": "https://example.com/foto4.jpg",
            "bio": "Buenas tardes, soy Usuario Cuatro"
        }
         */
        return userService.updateUser(id, userModel);
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
