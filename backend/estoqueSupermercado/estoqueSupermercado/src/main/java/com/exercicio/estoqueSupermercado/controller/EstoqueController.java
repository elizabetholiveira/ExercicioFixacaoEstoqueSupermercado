package com.exercicio.estoqueSupermercado.controller;

import com.exercicio.estoqueSupermercado.model.EstoqueModel;
import com.exercicio.estoqueSupermercado.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoque")
@CrossOrigin(origins = "http://127.0.0.1.5500/")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    //Ver tudo
    @GetMapping
    public ResponseEntity<List<EstoqueModel>> verTudo() { return ResponseEntity.ok(estoqueService.verTudo());}

    //Ver por ID
    @GetMapping(path = "/{id}")
    public Optional<EstoqueModel> verPorId(@PathVariable Long id) {
        return estoqueService.verPorId(id);
    }

    //Adicionar item
    @PostMapping
    public ResponseEntity<EstoqueModel> adicionar(@RequestBody EstoqueModel estoqueModel){
        EstoqueModel novoItem = estoqueService.adicionar(estoqueModel);
        return new ResponseEntity<>(novoItem, HttpStatus.CREATED);
    }
}
