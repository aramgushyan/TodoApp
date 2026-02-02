package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.UserAddRequest;
import com.yaguar.todo.api.dto.request.UserUpdateRequest;
import com.yaguar.todo.api.dto.response.UserResponse;
import com.yaguar.todo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody @Valid UserAddRequest user) {
        var id = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        var users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        var user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserUpdateRequest user, @PathVariable @Valid Long id) {
        userService.updateUser(id, user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
