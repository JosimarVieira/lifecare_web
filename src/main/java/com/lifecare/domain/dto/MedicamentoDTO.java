package com.lifecare.domain.dto;

import java.io.Serializable;

import com.lifecare.domain.Medicamento;

public class MedicamentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer qtDias;
	private String nome;
	private String tipo;
	private Boolean continuo;
	private String admDeUso;
	
	public MedicamentoDTO() {
	}
	
	public MedicamentoDTO(Medicamento obj) {
		id = obj.getId();
		qtDias = obj.getQtDias();
		nome = obj.getNome();
		tipo = obj.getTipo();
		continuo = obj.getContinuo();
		admDeUso = obj.getAdmDeUso();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtDias() {
		return qtDias;
	}

	public void setQtDias(Integer qtDias) {
		this.qtDias = qtDias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getContinuo() {
		return continuo;
	}

	public void setContinuo(Boolean continuo) {
		this.continuo = continuo;
	}

	public String getAdmDeUso() {
		return admDeUso;
	}

	public void setAdmDeUso(String admDeUso) {
		this.admDeUso = admDeUso;
	}
}
