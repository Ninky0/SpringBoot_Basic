package org.example.springbootbasic.dto;

import lombok.Getter;
import org.example.springbootbasic.model.User;

@Getter
public class MemberUpdateRequestDTO {
    private Long id;
    private String userid;
    private String name;
    private String email;

    public User toUser(){
        return User.builder()
                .id(id)
                .userid(userid)
                .name(name)
                .email(email)
                .build();
    }
}
