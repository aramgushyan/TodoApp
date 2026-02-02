package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.BoardAddRequest;
import com.yaguar.todo.api.dto.request.BoardUpdateRequest;
import com.yaguar.todo.api.dto.response.BoardResponse;
import com.yaguar.todo.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardResponse>>  getAll(@PathVariable Long userId) {
        var boards = boardService.findAllByUserId(userId);
        return ResponseEntity.ok().body(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse>  getBoard(@PathVariable Long userId, @PathVariable Long id) {
        var board = boardService.findByIdAndUserId(id, userId);
        return ResponseEntity.ok().body(board);
    }

    @PostMapping
    public ResponseEntity<Long> addBoard(
            @PathVariable Long userId,
            @RequestBody @Valid BoardAddRequest boardAddRequest) {
        var id = boardService.addBoard(userId, boardAddRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long userId, @PathVariable Long id) {
        boardService.deleteByIdAndUserId(id, userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBoard(
             @PathVariable Long userId,
             @PathVariable Long id,
             @RequestBody @Valid BoardUpdateRequest boardUpdateRequest) {
        boardService.updateBoard(boardUpdateRequest, userId, id);
        return ResponseEntity.noContent().build();
    }

}
