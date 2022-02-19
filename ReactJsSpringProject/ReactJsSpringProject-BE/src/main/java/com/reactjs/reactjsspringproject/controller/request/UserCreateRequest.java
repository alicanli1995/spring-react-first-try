package com.reactjs.reactjsspringproject.controller.request;


import com.reactjs.reactjsspringproject.repository.models.Annotation.UniqueUsername;
import com.reactjs.reactjsspringproject.repository.models.Users;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserCreateRequest {

    @NotNull(message = "{myproject.constraint.constraints.NotNull.message}")
    @Size(min = 4, max = 16)
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min = 4, max = 16)
    private String displayName;

    @NotNull()
    @Size(min = 6, max = 30)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$" , message = "{myproject.constraint.constraints.Pattern.message}")
    private String password;

    public Users convertToUsers() {
        return Users.builder()
                .userName(username)
                .displayName(displayName)
                .password(password)
                .build();
    }
}
