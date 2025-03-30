package org.example.repository;

import org.example.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}
