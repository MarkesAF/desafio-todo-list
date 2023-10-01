package com.augustomarques.controller;


import com.augustomarques.entity.Todo;
import com.augustomarques.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public ResponseEntity<List<Todo>>findAll(){
        List<Todo>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping("{inserir}")
    public ResponseEntity<List<Todo>>create(@RequestBody Todo todo){
        List<Todo>list = service.create(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).body(list);
    }
    @PutMapping("{update}")
    public ResponseEntity<List<Todo>>update(Todo todo){
        List<Todo>list = service.update(todo);
        return ResponseEntity.ok().body(list);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<List<Todo>>delete(@RequestBody Long id){
        List<Todo>list = service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
