package com.ProjetojpaGerenciamentoTarefas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaGerenciamentoTarefas.Repository.ItemExecucaoRepository;
import com.ProjetojpaGerenciamentoTarefas.entities.ItemExecucao;
	

@Service
public class ItemExecucaoServices {
	private final ItemExecucaoRepository ItemExecucaoRepository;
	
	@Autowired
	public ItemExecucaoServices(ItemExecucaoRepository ItemExecucaoRepository) {
		this.ItemExecucaoRepository = ItemExecucaoRepository;
	}

	public List<ItemExecucao> buscaTodosItemExecucao() {
		return ItemExecucaoRepository.findAll();
	}

	public ItemExecucao buscaItemExecucaoId(long id) {
		Optional<ItemExecucao> itemExecucao = ItemExecucaoRepository.findById(id);
		return itemExecucao.orElse(null);
	}

	
	public ItemExecucao salvaItemExecucao(ItemExecucao itemExecucao) {
		return ItemExecucaoRepository.save(itemExecucao);
	}

	public ItemExecucao alterarItemExecucao(long id, ItemExecucao alterarItem) {
		Optional<ItemExecucao> existeItemExecucao = ItemExecucaoRepository.findById(id);
		if (existeItemExecucao.isPresent()) {
			alterarItem.setId(id);
			return ItemExecucaoRepository.save(alterarItem);

		}
		return null;
	}
	public boolean apagarItemExecucao(long id) {
		Optional<ItemExecucao> existeItemExecucao = ItemExecucaoRepository.findById(id);
		if (existeItemExecucao.isPresent() ) {
			ItemExecucaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}