package com.medi.service;

import com.medi.entity.Medicos;
import com.medi.repository.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicosService {

    @Autowired
    private MedicosRepository medicosRepository;

    public List<Medicos> buscarTodos() {
        return medicosRepository.findAll();
    }

    public Medicos inserir(Medicos medicos){
        medicos.setDataCriacao(LocalDateTime.now());
        Medicos medicosNew = medicosRepository.saveAndFlush(medicos);
        return medicosNew;
    }

    public Medicos alterar(Medicos medicos){
        medicos.setDataAtualizacao(LocalDateTime.now());
        return medicosRepository.saveAndFlush(medicos);
    }

    public void excluir(Long id) {
        Medicos medicos = medicosRepository.findById(id).orElse(null);
        if (medicos != null) {
            medicosRepository.delete(medicos);
        }
    }
}
