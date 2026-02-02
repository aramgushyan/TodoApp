package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.ColumnAddRequest;
import com.yaguar.todo.api.dto.request.ColumnUpdateRequest;
import com.yaguar.todo.api.dto.response.ColumnResponse;
import com.yaguar.todo.service.ColumnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards/{boardId}/columns")
@RequiredArgsConstructor
public class ColumnController {
    private final ColumnService columnService;

    @GetMapping
    public ResponseEntity<List<ColumnResponse>> getAll(@PathVariable long boardId) {
        var columns = columnService.findAllByBoardId(boardId);
        return ResponseEntity.ok(columns);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColumnResponse> getById(@PathVariable long id, @PathVariable long boardId) {
        var column = columnService.findByIdAndBoardId(id, boardId);
        return ResponseEntity.ok(column);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColumn(@PathVariable long id, @PathVariable long boardId) {
        columnService.deleteByIdAndBoardId(id, boardId);
        return ResponseEntity.noContent().build();  
    }

    @PostMapping
    public ResponseEntity<Long> createColumn(
            @PathVariable Long boardId,
            @RequestBody @Valid ColumnAddRequest  columnAddRequest) {
        var id = columnService.addColumn(boardId, columnAddRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateColumn(
                                             @PathVariable long id,
                                             @PathVariable long boardId,
                                             @RequestBody @Valid ColumnUpdateRequest columnUpdateRequest) {
        columnService.updateColumn(id, boardId, columnUpdateRequest);
        return ResponseEntity.noContent().build();
    }
}
