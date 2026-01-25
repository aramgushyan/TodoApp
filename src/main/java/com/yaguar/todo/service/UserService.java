package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.UserAddRequest;
import com.yaguar.todo.api.dto.request.UserUpdateRequest;
import com.yaguar.todo.api.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse findUserById(Long id);
    List<UserResponse> findAllUsers();
    Long addUser(UserAddRequest userRequest);
    void deleteUser(Long id);
    void updateUser(Long id, UserUpdateRequest userUpdateRequest);
}
