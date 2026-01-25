package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.UserAddRequest;
import com.yaguar.todo.api.dto.request.UserUpdateRequest;
import com.yaguar.todo.api.dto.response.UserResponse;
import com.yaguar.todo.entity.UserEntity;
import com.yaguar.todo.mapper.UserMapper;
import com.yaguar.todo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toResponse(userEntity);
    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userMapper.toResponseList(userEntityList);
    }

    @Override
    public Long addUser(UserAddRequest userRequest) {
        UserEntity userEntity = userMapper.toEntity(userRequest);
        userRepository.save(userEntity);

        return  userEntity.getId();
    }

    @Override
    public void deleteUser(Long id) {
        boolean isExist = userRepository.existsById(id);

        if (isExist) {
            userRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("User not found");
        }
    }

    @Override
    public void updateUser(Long id,UserUpdateRequest userUpdateRequest) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        userMapper.updateEntityFromDto(userUpdateRequest, userEntity);

        userRepository.save(userEntity);
    }
}
