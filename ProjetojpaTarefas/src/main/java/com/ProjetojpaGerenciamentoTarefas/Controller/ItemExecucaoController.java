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

import com.ProjetojpaGerenciamentoTarefas.Services.ItemExecucaoServices;
import com.ProjetojpaGerenciamentoTarefas.entities.ItemExecucao;

@RestController
@RequestMapping("/ItemExecucao")
public class ItemExecucaoController {
	private final ItemExecucaoServices ItemExecucaoServices;

	@Autowired
	public ItemExecucaoController(ItemExecucaoServices ItemExecucaoServices) {
		this.ItemExecucaoServices = ItemExecucaoServices;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemExecucao> buscaItemExecucaoControlId(@PathVariable long id) {
		ItemExecucao itemExecucao = ItemExecucaoServices.buscaItemExecucaoId(id);
		if (itemExecucao != null)
			return ResponseEntity.ok(itemExecucao);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<ItemExecucao>> buscaTodosItemExecucaoControl() {
		List<ItemExecucao> ItemExecucao = ItemExecucaoServices.buscaTodosItemExecucao();
		return ResponseEntity.ok(ItemExecucao);
	}

	@PostMapping("/")
	public ResponseEntity<ItemExecucao> salvaItemExecucaoControl(@RequestBody ItemExecucao itemExecucao) {
		ItemExecucao salvaItemExecucao = ItemExecucaoServices.salvaItemExecucao(itemExecucao);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemExecucao);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemExecucao> alteraItemExecucaoControl(@PathVariable long id, @RequestBody ItemExecucao itemExecucao) {
		ItemExecucao alteraItemExecucao = ItemExecucaoServices.alterarItemExecucao(id, itemExecucao);
		if (alteraItemExecucao != null) {
			return ResponseEntity.ok(itemExecucao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaItemExecucaoControl(@PathVariable long id) {
		boolean apagar = ItemExecucaoServices.apagarItemExecucao(id);
		if (apagar) {
			return ResponseEntity.ok().body("o ItemExecucao foi excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}
