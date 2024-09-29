package org.example.springbootbasic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.springbootbasic.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    void insertUser(User user);
    User findById(Long id);
    void updateUser(User user);
    boolean checkValidation(Long id, String password);
    void deleteUser(User user);
}
