package org.example.springbootbasic.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootbasic.dto.MemberResponseDTO;
import org.example.springbootbasic.mapper.UserMapper;
import org.example.springbootbasic.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public List<MemberResponseDTO> findAll() {
        List<User> users = userMapper.findAll();

        // 방법.1
//        List<MemberListResponseDTO> members = new ArrayList<>();
//        for (User user : users) {
//            members.add(user.toMemberListResponseDTO());
//        }
//        return members;

        // 방법2 : Java Stream & Lambda
        return users.stream()
                .map(User::toMemberResponseDTO)
                .collect(Collectors.toList());
    }

    public MemberResponseDTO findById(Long id) {
        return userMapper.findById(id)
                .toMemberResponseDTO();
    }

    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(Long id, User user) {

    }

    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }

    public boolean checkValidation(String userid, String password) {
        User user = userMapper.findByUserid(userid);
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
