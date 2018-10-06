package com.lifecare.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer qtDias;
	private String nome;
	private String tipo;
	private Boolean continuo;
	private String admDeUso;
	
	@ManyToMany(mappedBy="medicamentos")
	private List<Prontuario> prontuarios = new ArrayList<>();
	
	//Construtores
	
	public Medicamento() {
	}	
	
	public Medicamento(Integer id, Integer qtDias, String nome, String tipo, Boolean continuo, String admDeUso) {
		super();
		this.id = id;
		this.qtDias = qtDias;
		this.nome = nome;
		this.tipo = tipo;
		this.continuo = continuo;
		this.admDeUso = admDeUso;
	}

	
	//Getters e setters
	
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

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}


	//hashCode e equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
