package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.TypeAddRequest;
import com.yaguar.todo.api.dto.request.TypeUpdateRequest;
import com.yaguar.todo.api.dto.response.TypeResponse;
import com.yaguar.todo.mapper.TypeMapper;
import com.yaguar.todo.repository.TypeEntityRepository;
import com.yaguar.todo.repository.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeEntityServiceImpl implements TypeEntityService {
    private final TypeEntityRepository typeEntityRepository;
    private final UserEntityRepository userEntityRepository;
    private final TypeMapper typeMapper;


    @Override
    public List<TypeResponse> findAllTypesById(Long userId) {
        var user =  userEntityRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        var entities = typeEntityRepository.findAllByUser(user);

        return typeMapper.toResponseList(entities);
    }

    @Override
    public TypeResponse findById(Long id, Long userId) {
        var user =  userEntityRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        var entity = typeEntityRepository.findByIdAndUser(id,user)
                .orElseThrow(() -> new EntityNotFoundException("Type not found"));

        return typeMapper.toResponse(entity);
    }

    @Override
    public void addType(TypeAddRequest typeAddRequest) {
        var type = typeMapper.toEntity(typeAddRequest);

        typeEntityRepository.save(type);
    }

    @Override
    public void removeType(Long id) {
        var type = typeEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Type not found"));

        typeEntityRepository.delete(type);
    }

    @Override
    public void updateType(Long id, Long userId,TypeUpdateRequest typeUpdateRequest) {
        var user =  userEntityRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        var type = typeEntityRepository.findByIdAndUser(id,user)
                .orElseThrow(() -> new EntityNotFoundException("Type not found"));

        typeMapper.update(typeUpdateRequest, type);

        typeEntityRepository.save(type);
    }
}
