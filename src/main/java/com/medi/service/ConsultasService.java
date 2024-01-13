package com.medi.service;

import com.medi.entity.Consultas;
import com.medi.repository.ConsultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultasService {
    @Autowired
    private ConsultasRepository consultasRepository;

    public List<Consultas> buscarTodos() {
        return consultasRepository.findAll();
    }

    public Consultas inserir(Consultas consultas){
        consultas.setDataCriacao(LocalDateTime.now());
        Consultas consultasNew = consultasRepository.saveAndFlush(consultas);
        return consultasNew;
    }

    public Consultas alterar(Consultas consultas){
        consultas.setDataAtualizacao(LocalDateTime.now());
        return consultasRepository.saveAndFlush(consultas);
    }

    public void excluir(Long id) {
        Consultas consultas = consultasRepository.findById(id).orElse(null);
        if (consultas != null) {
            consultasRepository.delete(consultas);
        }
    }
}
