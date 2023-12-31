package com.chatwave.chatwave.service.impl;

import com.chatwave.chatwave.dao.IUser;
import com.chatwave.chatwave.error.UserNotFoundException;
import com.chatwave.chatwave.models.UserModel;
import com.chatwave.chatwave.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return Optional.ofNullable(repository.findById(id)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Optional<UserModel> getUserByUsername(String username) {
        return Optional.ofNullable(repository.findByUsername(username)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return Optional.ofNullable(repository.findByEmail(email)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        repository.save(userModel);
        return userModel;
    }

    @Override
    public UserModel updateUser(Integer id, UserModel updatedUserModel) {
        Optional<UserModel> oUserModel = repository.findById(id);

        if (!oUserModel.isPresent())
            throw new UserNotFoundException();

        UserModel userModel = oUserModel.get();
        userModel.setUsername(updatedUserModel.getUsername());
        userModel.setPassword(updatedUserModel.getPassword());
        userModel.setEmail(updatedUserModel.getEmail());
        userModel.setName(updatedUserModel.getName());
        userModel.setProfilePic(updatedUserModel.getProfilePic());
        userModel.setBio(updatedUserModel.getBio());

        repository.save(userModel);
        return userModel;
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void validateUser(UserModel user) {

    }
}
