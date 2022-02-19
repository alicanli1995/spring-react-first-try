package com.reactjs.reactjsspringproject.service.users;

import com.reactjs.reactjsspringproject.repository.models.Users;
import com.reactjs.reactjsspringproject.repository.users.UsersEntity;

import java.util.Optional;


public interface UserService {
    void save(Users users);
    Optional<UsersEntity> findByUsername(String userName);
}
