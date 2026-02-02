package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.TaskAddRequest;
import com.yaguar.todo.api.dto.request.TaskUpdateRequest;
import com.yaguar.todo.api.dto.response.TaskResponse;
import com.yaguar.todo.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    ResponseEntity<List<TaskResponse>> findAll() {
        var tasks = taskService.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskResponse> findById(@PathVariable Long id) {
        var task = taskService.findById(id);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    ResponseEntity<Long> createTask(@RequestBody @Valid TaskAddRequest taskAddRequest) {
        var id = taskService.addTask(taskAddRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateTask(
            @PathVariable Long id,
            @RequestBody @Valid TaskUpdateRequest taskUpdateRequest) {
        taskService.updateTask(taskUpdateRequest, id);
        return ResponseEntity.noContent().build();
    }
}
