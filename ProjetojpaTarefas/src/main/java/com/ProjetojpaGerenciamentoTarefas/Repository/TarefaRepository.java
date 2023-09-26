package com.ProjetojpaGerenciamentoTarefas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaGerenciamentoTarefas.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}