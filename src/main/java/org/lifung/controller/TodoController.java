package org.lifung.controller;

import org.lifung.payload.TodoDto;
import org.lifung.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(this.todoService.addTodo(todoDto));
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    public ResponseEntity<List<TodoDto>> getTodoByAssignee(@RequestParam("assignee") Integer assignee,
                                                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                           @RequestParam(name = "limit", defaultValue = "100") Integer limit) {
        return ResponseEntity.ok(this.todoService.findByAssignee(assignee, page, limit));
    }
}
