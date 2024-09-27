package org.example.springbootbasic.dto;

import lombok.Getter;
import org.example.springbootbasic.model.User;

@Getter
public class MemberCreateRequestDTO {
    private String name;
    private String email;
    private String userid;
    private String password;

    // 컨트롤러에 지져분하게 쓰지말고! dto에다가 빌더를 씁시다요~, 생성자(빌더)쓸거니까 User에 @Builder 어노테이션 추가해주고요~
    public User toUser(){
        return User.builder()
                .name(name)
                .email(email)
                .userid(userid)
                .password(password)
                .build();
    }
}
