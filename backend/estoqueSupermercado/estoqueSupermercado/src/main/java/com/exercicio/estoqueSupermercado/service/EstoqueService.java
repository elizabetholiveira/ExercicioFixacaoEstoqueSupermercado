package com.exercicio.estoqueSupermercado.service;

import com.exercicio.estoqueSupermercado.model.EstoqueModel;
import com.exercicio.estoqueSupermercado.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    //Ver tudo
    public List<EstoqueModel> verTudo() {return repository.findAll();}

    //Ver por ID
    public Optional<EstoqueModel> verPorId(Long id) {return repository.findById(id);}

    //Adicionar item
    public EstoqueModel adicionar(EstoqueModel estoqueModel) {return repository.save(estoqueModel);}

}
