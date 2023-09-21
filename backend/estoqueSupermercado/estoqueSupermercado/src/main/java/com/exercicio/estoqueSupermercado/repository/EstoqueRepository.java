package com.exercicio.estoqueSupermercado.repository;

import com.exercicio.estoqueSupermercado.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {
}
