package com.reactjs.reactjsspringproject.repository.models;

import com.reactjs.reactjsspringproject.repository.users.UsersEntity;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Users {

    private Long id;
    private String userName;
    private String displayName;
    private String password;

    public UsersEntity convertToEntity(){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername(getUserName());
        usersEntity.setDisplayName(getDisplayName());
        usersEntity.setId(getId());
        usersEntity.setPassword(getPassword());
        return usersEntity;
    }

    public static Users convertFromEntity(UsersEntity userEntity)
    {
        return Users.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUsername())
                .displayName(userEntity.getDisplayName())
                .password(userEntity.getPassword())
                .build();
    }

}
