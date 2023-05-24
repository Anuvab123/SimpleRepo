package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping(value = "/saveTodo")
    public String saveTodo(@RequestBody Todo requestData) {

        todoService.saveTodo(requestData);
        return "saved";
    }


    @GetMapping(value = "/getTodos")
    public List<Todo> getAllTodos(@Nullable @RequestParam String lastDate,@Nullable @RequestParam String status)
    {

        return todoService.getTodo(lastDate,status);
    }


}
