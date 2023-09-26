package com.ProjetojpaGerenciamentoTarefas.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name cannot be null")
	@Column
	private String nome;
	
	@NotNull(message = "Name cannot be null")
	@Column
	private String statusTarefa;
	
	@NotNull(message = "Name cannot be null")
	@Column
	private String detalhesTarefa;

	@NotNull(message = "Name cannot be null")
	@Column
	private String dataLimiteExecucao;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataLimiteExecucao(String dataLimiteExecucao) {
		this.dataLimiteExecucao = dataLimiteExecucao;
	}

	public String getDataLimiteExecucao() {
		return dataLimiteExecucao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDetalhesTarefa(String detalhesTarefa) {
		this.detalhesTarefa = detalhesTarefa;
	}

	public String getDetalhesTarefa() {
		return detalhesTarefa;
	}
	
	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}

}