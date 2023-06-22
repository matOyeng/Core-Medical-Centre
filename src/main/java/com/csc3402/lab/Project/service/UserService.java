package com.csc3402.lab.Project.service;

import com.csc3402.lab.Project.dto.UserDto;
import com.csc3402.lab.Project.model.User;

public interface UserService {
    void  saveUser(UserDto userDto);
    User findUserByEmail(String email);
}
