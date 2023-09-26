package com.ProjetojpaGerenciamentoTarefas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaGerenciamentoTarefas.Repository.TarefaRepository;
import com.ProjetojpaGerenciamentoTarefas.entities.Tarefa;

@Service
public class TarefasServices {
	private final TarefaRepository TarefaRepository;
	
	@Autowired
	public TarefasServices(TarefaRepository TarefaRepository) {
		this.TarefaRepository = TarefaRepository;
	}

	public List<Tarefa> buscaTodosTarefa() {
		return TarefaRepository.findAll();
	}

	public Tarefa buscaTarefaId(long id) {
		Optional<Tarefa> tarefa = TarefaRepository.findById(id);
		return tarefa.orElse(null);
	}

	
	public Tarefa salvaTarefa(Tarefa tarefa) {
		return TarefaRepository.save(tarefa);
	}

	public Tarefa alterarTarefa(long id, Tarefa alterarTaref) {
		Optional<Tarefa> existeTarefa = TarefaRepository.findById(id);
		if (existeTarefa.isPresent()) {
			alterarTaref.setId(id);
			return TarefaRepository.save(alterarTaref);

		}
		return null;
	}
	public boolean apagarTarefa(long id) {
		Optional<Tarefa> existeTarefa = TarefaRepository.findById(id);
		if (existeTarefa.isPresent() ) {
			TarefaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}