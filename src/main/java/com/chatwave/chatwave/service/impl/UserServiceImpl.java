package com.chatwave.chatwave.service.impl;

import com.chatwave.chatwave.dao.IUser;
import com.chatwave.chatwave.models.UserModel;
import com.chatwave.chatwave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUser repository;

    @Override
    public Iterable<UserModel> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<UserModel> getUserById(Integer id) {
        return Optional.ofNullable(repository.findById(id)).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<UserModel> getUserByUsername(String username) {
        return Optional.ofNullable(repository.findByUsername(username)).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return Optional.ofNullable(repository.findByEmail(email)).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        repository.save(userModel);
        return userModel;
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void validateUser(UserModel user) {

    }
}
