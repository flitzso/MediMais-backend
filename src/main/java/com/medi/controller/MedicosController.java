package com.medi.controller;

import com.medi.entity.Medicos;
import com.medi.service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@CrossOrigin
public class MedicosController {
    @Autowired
    private MedicosService medicosService;

    @GetMapping("/medicos")
    public List<Medicos> buscarTodos() {
        return medicosService.buscarTodos();
    }

    @PostMapping
    public Medicos inserir(@RequestBody Medicos medicos) {
        return medicosService.inserir(medicos);
    }

    @PutMapping
    public Medicos alterar(@RequestBody Medicos medicos){
        return medicosService.alterar(medicos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        medicosService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
