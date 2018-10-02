package com.lifecare.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Prontuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer score;
	
	@OneToMany(mappedBy="id.prontuario")
	private Set<ItemMedicamento> itens = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="prontuario")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name="risco_id")
	private Risco risco;
	
	@OneToMany(mappedBy="prontuario")
	private List<LinhaDeCuidado> linhasDeCuidado = new ArrayList<>();
	
	//Construtores
	
	public Prontuario() {
	}
	
	public Prontuario(Integer id, Integer score, Set<ItemMedicamento> itens, Paciente paciente, Risco risco,
			List<LinhaDeCuidado> linhasDeCuidado) {
		super();
		this.id = id;
		this.score = score;
		this.itens = itens;
		this.paciente = paciente;
		this.risco = risco;
		this.linhasDeCuidado = linhasDeCuidado;
	}


	//Getters e setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Set<ItemMedicamento> getItens() {
		return itens;
	}

	public void setItens(Set<ItemMedicamento> itens) {
		this.itens = itens;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Risco getRisco() {
		return risco;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

	public List<LinhaDeCuidado> getLinhasDeCuidado() {
		return linhasDeCuidado;
	}

	public void setLinhasDeCuidado(List<LinhaDeCuidado> linhasDeCuidado) {
		this.linhasDeCuidado = linhasDeCuidado;
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
		Prontuario other = (Prontuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
