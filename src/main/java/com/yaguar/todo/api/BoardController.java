package com.yaguar.todo.api;

import com.yaguar.todo.api.dto.request.BoardAddRequest;
import com.yaguar.todo.api.dto.request.BoardUpdateRequest;
import com.yaguar.todo.api.dto.response.BoardResponse;
import com.yaguar.todo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/allBoards/{id}")
    public ResponseEntity<List<BoardResponse>>  getAllUserBoards(@PathVariable Long id) {
        var boards = boardService.findAllByUserId(id);
        return ResponseEntity.ok().body(boards);
    }

    @GetMapping("/{userId}/{id}")
    public ResponseEntity<BoardResponse>  getAllUserBoard
            (@PathVariable Long userId,
             @PathVariable Long id) {
        var board = boardService.findByIdAndUserId(id, userId);
        return ResponseEntity.ok().body(board);
    }

    @PostMapping()
    public ResponseEntity<Long> addUserBoard(BoardAddRequest boardAddRequest) {
        var id = boardService.addBoard(boardAddRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{userId}/{id}")
    public ResponseEntity<Void> deleteUserBoard(@PathVariable Long userId, @PathVariable Long id) {
        boardService.deleteByIdAndUserId(id, userId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/{id}")
    public ResponseEntity<Void> updateUserBoard
            (@PathVariable Long userId,
             @PathVariable Long id,
             @RequestBody BoardUpdateRequest boardUpdateRequest)
    {
        boardService.updateBoard(boardUpdateRequest, userId, id);
        return ResponseEntity.noContent().build();
    }

}
