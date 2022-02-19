package com.reactjs.reactjsspringproject;

import com.reactjs.reactjsspringproject.repository.models.Users;
import com.reactjs.reactjsspringproject.service.users.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactJsSpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactJsSpringProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitUsers(UserService userService){
        return (args) -> {
            Users user = new Users();
            user.setUserName("admin");
            user.setDisplayName("userrr");
            user.setPassword("admin");
            userService.save(user);
        };
    }

}
