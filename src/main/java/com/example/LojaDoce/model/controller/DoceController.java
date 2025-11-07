package com.example.LojaDoce.model.controller;


import com.example.LojaDoce.model.model.Doce;
import com.example.LojaDoce.model.repository.DoceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doces")
public class DoceController {

    private final DoceRepository repo;

    public DoceController(DoceRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Doce> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doce> buscar(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Doce> criar(@RequestBody Doce doce) {
        Doce salvo = repo.save(doce);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doce> atualizar(@PathVariable Integer id, @RequestBody Doce doce) {
        return repo.findById(id).map(ex -> {
            ex.setNome(doce.getNome());
            ex.setQuantidade(doce.getQuantidade());
            ex.setValor(doce.getValor());
            repo.save(ex);
            return ResponseEntity.ok(ex);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return repo.findById(id).map(ex -> {
            repo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
