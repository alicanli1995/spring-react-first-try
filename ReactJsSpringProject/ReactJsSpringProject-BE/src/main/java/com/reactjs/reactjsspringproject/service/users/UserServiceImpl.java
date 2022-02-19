package com.reactjs.reactjsspringproject.service.users;

import com.reactjs.reactjsspringproject.repository.models.Users;
import com.reactjs.reactjsspringproject.repository.users.UsersDto;
import com.reactjs.reactjsspringproject.repository.users.UsersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UsersDto usersDto;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(Users users) {
        UsersEntity usersEntity =  users.convertToEntity();
        usersEntity.setPassword(passwordEncoder.encode(usersEntity.getPassword()));
        usersDto.save(usersEntity);
    }

    @Override
    public Optional<UsersEntity> findByUsername(String userName) {
        return usersDto.findByUsername(userName);
    }

}
