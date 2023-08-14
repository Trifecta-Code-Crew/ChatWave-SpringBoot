package com.chatwave.chatwave.service;

import com.chatwave.chatwave.models.UserModel;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Iterable<UserModel> getAllUsers();

    Optional<UserModel> getUserById(Integer id);

    Optional<UserModel> getUserByUsername(String username);

    Optional<UserModel> getUserByEmail(String email);

    UserModel createUser(UserModel userModel);

    UserModel updateUser(UserModel userModel);

    void deleteUser(Integer id);

    public void validateUser(UserModel user);
}
