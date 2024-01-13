package com.medi.service;

import com.medi.entity.Pacientes;
import com.medi.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    public List<Pacientes> buscarTodos() {
        return pacientesRepository.findAll();
    }

    public Pacientes inserir(Pacientes pacientes){
        pacientes.setDataCriacao(LocalDateTime.now());
        Pacientes pacientesNew = pacientesRepository.saveAndFlush(pacientes);
        return pacientesNew;
    }

    public Pacientes alterar(Pacientes pacientes){
        pacientes.setDataAtualizacao(LocalDateTime.now());
        return pacientesRepository.saveAndFlush(pacientes);
    }

    public void excluir(Long id) {
        Pacientes pacientes = pacientesRepository.findById(id).orElse(null);
        if (pacientes != null) {
            pacientesRepository.delete(pacientes);
        }
    }
}
