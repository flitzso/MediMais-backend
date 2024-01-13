package com.medi.service;

import com.medi.entity.User;
import com.medi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> buscarTodos() {
        return userRepository.findAll();
    }

    public User inserir(User user){
        user.setDataCriacao(LocalDateTime.now());
        User userNew = userRepository.saveAndFlush(user);
        return userNew;
    }

    public User alterar(User user){
        user.setDataAtualizacao(LocalDateTime.now());
        return userRepository.saveAndFlush(user);
    }

    public void excluir(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
