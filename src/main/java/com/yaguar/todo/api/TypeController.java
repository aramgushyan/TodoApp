package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.TypeAddRequest;
import com.yaguar.todo.api.dto.request.TypeUpdateRequest;
import com.yaguar.todo.api.dto.response.TypeResponse;
import com.yaguar.todo.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/types")
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @GetMapping("allUserTypes/{userId}")
    public ResponseEntity<List<TypeResponse>> getAllUserTypes(@PathVariable Long userId) {
        var types = typeService.findAllByUserId(userId);

        return ResponseEntity.ok().body(types);
    }

    @GetMapping("/{userId}/{id}")
    public ResponseEntity<TypeResponse> getUserType(@PathVariable Long userId, @PathVariable Long id) {
        var type = typeService.findByIdAndUserId(id,userId);
        return ResponseEntity.ok().body(type);
    }

    @PostMapping()
    public ResponseEntity<Long> addUserType(@RequestBody TypeAddRequest typeAddRequest) {
        var id = typeService.addUserType(typeAddRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{userId}/{id}")
    public ResponseEntity<Void> deleteUserType(@PathVariable Long userId, @PathVariable Long id) {
        typeService.deleteByIdAndUserId(id,userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/{id}")
    public ResponseEntity<Void> updateUserType(
            @RequestBody TypeUpdateRequest typeUpdateRequest,
            @PathVariable Long userId,
            @PathVariable Long id) {
        typeService.updateUserType(id, userId, typeUpdateRequest);

        return ResponseEntity.noContent().build();
    }
}
