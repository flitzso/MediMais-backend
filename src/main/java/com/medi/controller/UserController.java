package com.medi.controller;

import com.medi.entity.User;
import com.medi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> buscarTodos() {
        return userService.buscarTodos();
    }

    @PostMapping
    public User inserir(@RequestBody User user) {
        return userService.inserir(user);
    }

    @PutMapping
    public User alterar(@RequestBody User user){
        return userService.alterar(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        userService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
