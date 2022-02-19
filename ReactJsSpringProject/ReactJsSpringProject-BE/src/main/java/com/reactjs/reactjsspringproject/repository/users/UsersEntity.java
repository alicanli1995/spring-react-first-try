package com.reactjs.reactjsspringproject.repository.users;


import com.fasterxml.jackson.annotation.JsonView;
import com.reactjs.reactjsspringproject.controller.response.Views;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
public class UsersEntity implements UserDetails {

    private static final long serialVersionUID = 3203364416943033232L;

    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Base.class)
    private String username;

    @JsonView(Views.Base.class)
    private String displayName;


    private String password;

    @JsonView(Views.Base.class)
    private String image;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_USER");
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
