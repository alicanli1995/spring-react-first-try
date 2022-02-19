package com.reactjs.reactjsspringproject.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.reactjs.reactjsspringproject.controller.response.Views;
import com.reactjs.reactjsspringproject.repository.models.Annotation.CurrentUser;
import com.reactjs.reactjsspringproject.repository.users.UsersEntity;
import com.reactjs.reactjsspringproject.service.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/api/1.0/auth")
    @JsonView(Views.Base.class)
    public ResponseEntity<?> handleAuth(@CurrentUser UsersEntity usersEntity){
        return ResponseEntity.ok(usersEntity);
    }

}
