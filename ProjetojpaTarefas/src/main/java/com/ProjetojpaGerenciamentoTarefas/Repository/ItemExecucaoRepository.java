package com.ProjetojpaGerenciamentoTarefas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaGerenciamentoTarefas.entities.ItemExecucao;

public interface ItemExecucaoRepository extends JpaRepository<ItemExecucao, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}