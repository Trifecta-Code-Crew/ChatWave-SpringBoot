package com.chatwave.chatwave.dao;

import com.chatwave.chatwave.models.UserModel;

import java.util.List;

public interface IUser {
    public List<UserModel> getAllUsers();
    public UserModel getUserById(int id);
    public UserModel getUserByUsername(String username);
    public UserModel getUserByEmail(String email);
    public void createUser(UserModel user);
    public void updateUser(UserModel user);
    public void deleteUser(int id);
    public void validateUser(UserModel user);
}
