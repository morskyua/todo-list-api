package org.example.service;

import org.example.entity.TodoItem;
import org.example.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.example.exception.TodoNotFoundException;


@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    public TodoItem getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo with id " + id + " not found"));
    }

    public TodoItem createTodo(TodoItem todo) {
        return todoRepository.save(todo);
    }

    public TodoItem updateTodo(Long id, TodoItem updatedTodo) {
        TodoItem existingTodo = getTodoById(id);
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());
        return todoRepository.save(existingTodo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}

