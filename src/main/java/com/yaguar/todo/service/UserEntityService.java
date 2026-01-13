package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.UserAddRequest;
import com.yaguar.todo.api.dto.request.UserUpdateRequest;
import com.yaguar.todo.api.dto.response.UserResponse;

import java.util.List;

public interface UserEntityService {
    UserResponse findById(Long id);
    List<UserResponse> findAllUsers();
    void addUser(UserAddRequest userRequest);
    void removeUser(Long id);
    void updateUser(Long id,UserUpdateRequest userUpdateRequest);
}
