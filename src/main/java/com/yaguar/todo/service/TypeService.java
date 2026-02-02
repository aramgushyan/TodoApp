package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.TypeAddRequest;
import com.yaguar.todo.api.dto.request.TypeUpdateRequest;
import com.yaguar.todo.api.dto.response.TypeResponse;

import java.util.List;

public interface TypeService {
    List<TypeResponse> findAllByUserId(Long userId);

    TypeResponse findByIdAndUserId(Long id, Long userId);

    Long addUserType(Long userId, TypeAddRequest typeAddRequest);

    void deleteByIdAndUserId(Long id, Long userId);

    void updateUserType(Long id, Long userId, TypeUpdateRequest typeUpdateRequest);
}
