package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.UserAddRequest;
import com.yaguar.todo.api.dto.request.UserUpdateRequest;
import com.yaguar.todo.api.dto.response.UserResponse;
import com.yaguar.todo.entity.UserEntity;
import com.yaguar.todo.mapper.UserMapper;
import com.yaguar.todo.repository.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse findById(Long id) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        UserResponse response = userMapper.toResponse(userEntity);
        return response;
    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<UserEntity> userEntityList = userEntityRepository.findAll();
        return userMapper.toResponseList(userEntityList);
    }

    @Override
    public void addUser(UserAddRequest userRequest) {
        UserEntity userEntity = userMapper.toEntity(userRequest);
        userEntityRepository.save(userEntity);
    }

    @Override
    public void removeUser(Long id) {
        boolean isExist = userEntityRepository.existsById(id);
        if (isExist) {
            userEntityRepository.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException("User not found");
        }
    }

    @Override
    public void updateUser(Long id,UserUpdateRequest userUpdateRequest) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        userMapper.updateEntityFromDto(userUpdateRequest, userEntity);

        userEntityRepository.save(userEntity);
    }
}
