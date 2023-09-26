package com.ProjetojpaGerenciamentoTarefas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetojpaGerenciamentoTarefas.Services.TarefasServices;
import com.ProjetojpaGerenciamentoTarefas.entities.Tarefa;


@RestController
@RequestMapping("/Tarefa")
public class TarefaController {
	private final TarefasServices TarefasServices;

	@Autowired
	public TarefaController(TarefasServices tarefasServices) {
		this.TarefasServices = tarefasServices;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscaTarefaControlId(@PathVariable long id) {
		Tarefa tarefa = TarefasServices.buscaTarefaId(id);
		if (tarefa != null)
			return ResponseEntity.ok(tarefa);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Tarefa>> buscaTodosTarefaControl() {
		List<Tarefa> Tarefa = TarefasServices.buscaTodosTarefa();
		return ResponseEntity.ok(Tarefa);
	}

	@PostMapping("/")
	public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody Tarefa tarefa) {
		Tarefa salvaTarefa = TarefasServices.salvaTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable long id, @RequestBody Tarefa tarefa) {
		Tarefa alteraTarefa = TarefasServices.alterarTarefa(id, tarefa);
		if (alteraTarefa != null) {
			return ResponseEntity.ok(tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaTarefaControl(@PathVariable long id) {
		boolean apagar = TarefasServices.apagarTarefa(id);
		if (apagar) {
			return ResponseEntity.ok().body("a Tarefa foi excluida com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}
