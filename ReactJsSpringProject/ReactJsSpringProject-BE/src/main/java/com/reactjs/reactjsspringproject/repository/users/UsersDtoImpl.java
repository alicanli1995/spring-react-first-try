package com.reactjs.reactjsspringproject.repository.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersDtoImpl implements UsersDto{

    private final UsersJpaDto usersJpaDto;

    @Override
    public void save(UsersEntity usersEntity) {
        usersJpaDto.save(usersEntity);
    }

    @Override
    public Optional<UsersEntity> findByUsername(String userName) {
        return Optional.ofNullable(usersJpaDto.findByUsername(userName));
    }

}
