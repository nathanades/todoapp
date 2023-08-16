package com.nathanades.todoapp.services;

import com.nathanades.todoapp.models.TodoItem;
import com.nathanades.todoapp.repositories.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    // Autowired is unnecessary with single constructors
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    // ??? Optional???
    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(LocalDateTime.now());
        }

        todoItem.setUpdatedAt(LocalDateTime.now());
        return todoItemRepository.save(todoItem);
    }

    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }
}
