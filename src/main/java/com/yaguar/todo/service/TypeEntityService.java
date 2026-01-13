package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.TypeAddRequest;
import com.yaguar.todo.api.dto.request.TypeUpdateRequest;
import com.yaguar.todo.api.dto.response.TypeResponse;
import com.yaguar.todo.entity.TypeEntity;

import java.util.List;

public interface TypeEntityService {
    List<TypeResponse> findAllTypesById(Long userId);
    TypeResponse findById(Long id, Long userId);
    void addType(TypeAddRequest typeAddRequest);
    void removeType(Long id);
    void updateType(Long id, Long userId,TypeUpdateRequest typeUpdateRequest);
}
