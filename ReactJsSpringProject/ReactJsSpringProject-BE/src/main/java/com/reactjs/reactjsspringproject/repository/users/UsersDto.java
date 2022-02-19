package com.reactjs.reactjsspringproject.repository.users;

import java.util.Optional;

public interface UsersDto {
    void save(UsersEntity usersEntity);

    Optional<UsersEntity> findByUsername(String userName);
}
