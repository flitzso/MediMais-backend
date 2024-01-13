package com.medi.controller;

import com.medi.entity.Consultas;
import com.medi.service.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@CrossOrigin
public class ConsultasController {
    @Autowired
    private ConsultasService consultasService;

    @GetMapping("/consultas")
    public List<Consultas> buscarTodos() {
        return consultasService.buscarTodos();
    }

    @PostMapping
    public Consultas inserir(@RequestBody Consultas consultas) {
        return consultasService.inserir(consultas);
    }

    @PutMapping
    public Consultas alterar(@RequestBody Consultas consultas){
        return consultasService.alterar(consultas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        consultasService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
