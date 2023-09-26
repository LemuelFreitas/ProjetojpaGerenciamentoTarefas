package com.ProjetojpaGerenciamentoTarefas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ItemExecucao")
public class ItemExecucao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column
	private double percentualIscricao;
	
	@NotNull(message = "Name cannot be null")
	@Column
	private String Inscricao;
	


	@NotNull(message = "Name cannot be null")
	@Column
	private String dataExecucao;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public String getDataExecucao() {
		return dataExecucao;
	}

	public String getInscricao() {
		return Inscricao;
	}

	public void setInscricao(String inscricao) {
		this.Inscricao = inscricao;
	}
	
	public void setPercentualIscricao(double percentualIscricao) {
		this.percentualIscricao = percentualIscricao;
	}

	public double getPercentualIscricao() {
		return percentualIscricao;
	}

}
