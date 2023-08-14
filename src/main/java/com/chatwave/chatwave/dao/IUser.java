package com.chatwave.chatwave.dao;

import com.chatwave.chatwave.models.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUser extends CrudRepository<UserModel, Integer> {

    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);

}
