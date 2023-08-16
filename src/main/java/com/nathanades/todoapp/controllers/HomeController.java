package com.nathanades.todoapp.controllers;

import com.nathanades.todoapp.services.TodoItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // not RestController due to thymeleaf
public class HomeController {
    private final TodoItemService todoItemService;

    public HomeController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        // look for index in the templates folder
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }
}
