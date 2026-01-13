package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.UserAddRequest;
import com.yaguar.todo.api.dto.request.UserUpdateRequest;
import com.yaguar.todo.api.dto.response.UserResponse;
import com.yaguar.todo.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserEntityService userEntityService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserAddRequest user) {
        userEntityService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var users = userEntityService.findAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        var user = userEntityService.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userEntityService.removeUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserUpdateRequest user, @PathVariable Long id)
    {
        userEntityService.updateUser(id, user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
