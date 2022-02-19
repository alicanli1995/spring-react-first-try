package com.reactjs.reactjsspringproject.repository.models.Annotation;

import com.reactjs.reactjsspringproject.repository.users.UsersEntity;
import com.reactjs.reactjsspringproject.repository.users.UsersJpaDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UsersJpaDto usersJpaDto;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        UsersEntity user = usersJpaDto.findByUsername(userName);
        return user == null;
    }
}
