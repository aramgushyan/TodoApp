package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.ColumnAddRequest;
import com.yaguar.todo.api.dto.request.ColumnUpdateRequest;
import com.yaguar.todo.api.dto.response.ColumnResponse;
import com.yaguar.todo.service.ColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/columns")
@RequiredArgsConstructor
public class ColumnController {
    private final ColumnService columnService;

    @GetMapping("/allBoardColumns/{boardId}")
    public ResponseEntity<List<ColumnResponse>> findAllByBoard(@PathVariable long boardId) {
        var columns = columnService.findAllByBoardId(boardId);

        return ResponseEntity.ok(columns);
    }

    @GetMapping("/{boardId}/{id}")
    public ResponseEntity<ColumnResponse> findByIdAndBoard(@PathVariable long id, @PathVariable long boardId) {
        var column = columnService.findByIdAndBoardId(id, boardId);

        return ResponseEntity.ok(column);
    }

    @DeleteMapping("/{boardId}/{id}")
    public ResponseEntity<ColumnResponse> deleteByIdAndBoard(@PathVariable long id, @PathVariable long boardId) {
        columnService.deleteByIdAndBoardId(id, boardId);

        return ResponseEntity.noContent().build();  
    }

    @PostMapping()
    public ResponseEntity<Long> addUserColumn(@RequestBody ColumnAddRequest  columnAddRequest) {
        var id = columnService.addColumn(columnAddRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{boardId}/{id}")
    public ResponseEntity<Void> updateColumn(@PathVariable long id,
                                             @PathVariable long boardId,
                                             @RequestBody ColumnUpdateRequest columnUpdateRequest) {
        columnService.updateColumn(id, boardId, columnUpdateRequest);

        return ResponseEntity.noContent().build();
    }
}
