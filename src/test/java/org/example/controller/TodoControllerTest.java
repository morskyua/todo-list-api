package org.example.controller;

import org.example.entity.TodoItem;
import org.example.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    void testGetTodoById() throws Exception {
        TodoItem mockTodo = new TodoItem();
        mockTodo.setId(1L);
        mockTodo.setTitle("Test Todo");
        mockTodo.setDescription("This is a todo description");

        Mockito.when(todoService.getTodoById(1L)).thenReturn(mockTodo);

        mockMvc.perform(get("/api/todos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Todo"))
                .andExpect(jsonPath("$.description").value("This is a todo description"));
    }
}

