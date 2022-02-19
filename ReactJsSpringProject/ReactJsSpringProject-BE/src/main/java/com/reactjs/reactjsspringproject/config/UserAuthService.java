package com.reactjs.reactjsspringproject.config;

import com.reactjs.reactjsspringproject.repository.users.UsersDto;
import com.reactjs.reactjsspringproject.repository.users.UsersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

    private final UsersDto usersDto;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersEntity> inDb = usersDto.findByUsername(username);
        if(inDb.isPresent()){
            return (inDb.get());
        }
        else
            throw new UsernameNotFoundException("Username not in database");
    }
}
