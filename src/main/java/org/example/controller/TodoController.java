package org.example.controller;

import org.example.entity.TodoItem;
import org.example.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoItem getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem todo) {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodo(@PathVariable Long id, @RequestBody TodoItem todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }
}

