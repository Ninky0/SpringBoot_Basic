package org.example.springbootbasic.dto;

import lombok.Getter;
import org.example.springbootbasic.model.User;

@Getter
public class MemberDeleteRequestDTO {
    private String userid;
    private String password;

    public User toUser(){
        return User.builder()
                .userid(userid)
                .password(password)
                .build();
    }

}
