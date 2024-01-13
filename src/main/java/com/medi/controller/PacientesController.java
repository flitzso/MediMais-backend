package com.medi.controller;

import com.medi.entity.Pacientes;
import com.medi.service.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@CrossOrigin
public class PacientesController {
    @Autowired
    private PacientesService pacientesService;

    @GetMapping("/pacientes")
    public List<Pacientes> buscarTodos() {
        return pacientesService.buscarTodos();
    }

    @PostMapping
    public Pacientes inserir(@RequestBody Pacientes pacientes) {
        return pacientesService.inserir(pacientes);
    }

    @PutMapping
    public Pacientes alterar(@RequestBody Pacientes pacientes){
        return pacientesService.alterar(pacientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        pacientesService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
