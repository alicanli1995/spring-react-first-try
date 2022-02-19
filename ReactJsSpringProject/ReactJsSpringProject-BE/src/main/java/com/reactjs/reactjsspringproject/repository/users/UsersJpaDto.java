package com.reactjs.reactjsspringproject.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaDto extends JpaRepository<UsersEntity,Long> {
    UsersEntity findByUsername (String userName);
}

