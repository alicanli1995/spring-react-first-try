package com.reactjs.reactjsspringproject.controller;

import com.reactjs.reactjsspringproject.controller.request.UserCreateRequest;
import com.reactjs.reactjsspringproject.controller.response.GenericResponse;
import com.reactjs.reactjsspringproject.service.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/api/1.0/users")
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createUser(@RequestBody @Valid UserCreateRequest userCreateRequest){
        userService.save(userCreateRequest.convertToUsers());
        log.warn(userCreateRequest.toString());
        return GenericResponse.builder().message("User created...").build();
    }

}
