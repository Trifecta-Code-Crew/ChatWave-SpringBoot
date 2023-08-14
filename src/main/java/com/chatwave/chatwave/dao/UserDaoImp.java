package com.chatwave.chatwave.dao;

import com.chatwave.chatwave.models.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
@Transactional
public class UserDaoImp implements IUser{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<UserModel> getAllUsers() {
        String query = "FROM UserModel";
        return (List<UserModel>) entityManager.createQuery(query).getResultList();

    }

    @Override
    public UserModel getUserById(int id) {
        String query = "FROM UserModel WHERE id = :id";
        return (UserModel) entityManager.createQuery(query).setParameter("id", id).getSingleResult();
    }

    @Override
    public UserModel getUserByUsername(String username) {
        String query = "FROM UserModel WHERE username = :username";
        return (UserModel) entityManager.createQuery(query).setParameter("username", username).getSingleResult();
    }

    @Override
    public UserModel getUserByEmail(String email) {
        return null;
    }

    @Override
    public void createUser(UserModel user) {

    }

    @Override
    public void updateUser(UserModel user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void validateUser(UserModel user) {

    }
}
