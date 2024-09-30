package org.example.springbootbasic.dto;

import lombok.Getter;
import org.example.springbootbasic.model.User;

@Getter
public class MemberDeleteRequestDTO {
    private Long id;
    private String userid;
    private String password;

    public User toUser(Long id){
        return User.builder()
                .id(id)
                .userid(userid)
                .password(password)
                .build();
    }

}
