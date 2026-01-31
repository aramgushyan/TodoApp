package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.TypeAddRequest;
import com.yaguar.todo.api.dto.request.TypeUpdateRequest;
import com.yaguar.todo.api.dto.response.TypeResponse;
import com.yaguar.todo.entity.TypeEntity;
import com.yaguar.todo.entity.UserEntity;
import com.yaguar.todo.mapper.TypeMapper;
import com.yaguar.todo.repository.TypeRepository;
import com.yaguar.todo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final UserRepository userRepository;
    private final TypeMapper typeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TypeResponse> findAllByUserId(Long userId) {
        var user =  findUserById(userId);

        var types = typeRepository.findAllByUser(user);

        return typeMapper.toResponseList(types);
    }

    @Override
    @Transactional(readOnly = true)
    public TypeResponse findByIdAndUserId(Long id, Long userId) {
        var user = findUserById(userId);

        var type = findTypeById(id, user);

        return typeMapper.toResponse(type);
    }

    @Override
    public Long addUserType(TypeAddRequest typeAddRequest) {
        var user =  findUserById(typeAddRequest.getUserId());

        var type = typeMapper.toEntity(typeAddRequest);

        typeRepository.save(type);

        return type.getId();
    }

    @Override
    public void deleteByIdAndUserId(Long id, Long userId) {
        var user =  findUserById(userId);

        var type = findTypeById(id, user);

        typeRepository.delete(type);
    }

    @Override
    public void updateUserType(Long id, Long userId, TypeUpdateRequest typeUpdateRequest) {
        var user =  findUserById(userId);

        var type = findTypeById(id, user);

        typeMapper.update(typeUpdateRequest, type);

        typeRepository.save(type);
    }

    private UserEntity findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow( () -> new EntityNotFoundException("User not found"));
    }
    
    private TypeEntity findTypeById(Long id, UserEntity user) {
        return typeRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new EntityNotFoundException("Type not found"));
    }
}
