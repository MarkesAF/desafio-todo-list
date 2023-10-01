package com.augustomarques.service;

import com.augustomarques.entity.Todo;
import com.augustomarques.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository rep;

    public List<Todo> findAll(){
        return rep.findAll();
    }
    public List<Todo> create(Todo todo){
        rep.save(todo);
        return findAll();
    }
    public List<Todo> update(Todo todo){
        rep.save(todo);
        return findAll();
    }
    public List<Todo> delete(Long id){
       rep.deleteById(id);
       return findAll();
    }
}
