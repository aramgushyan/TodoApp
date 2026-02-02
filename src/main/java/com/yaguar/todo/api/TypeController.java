package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.TypeAddRequest;
import com.yaguar.todo.api.dto.request.TypeUpdateRequest;
import com.yaguar.todo.api.dto.response.TypeResponse;
import com.yaguar.todo.service.TypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/types")
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<List<TypeResponse>> getAll(@PathVariable Long userId) {
        var types = typeService.findAllByUserId(userId);
        return ResponseEntity.ok().body(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeResponse> getById(@PathVariable Long userId, @PathVariable Long id) {
        var type = typeService.findByIdAndUserId(id,userId);
        return ResponseEntity.ok().body(type);
    }

    @PostMapping()
    public ResponseEntity<Long> createType(@PathVariable Long userId, @RequestBody @Valid TypeAddRequest typeAddRequest) {
        var id = typeService.addUserType(userId, typeAddRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long userId, @PathVariable  Long id) {
        typeService.deleteByIdAndUserId(id,userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateType(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody @Valid TypeUpdateRequest typeUpdateRequest) {
        typeService.updateUserType(id, userId, typeUpdateRequest);
        return ResponseEntity.noContent().build();
    }
}
