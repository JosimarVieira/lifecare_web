package com.lifecare.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@OneToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@ManyToMany
	@JoinTable(name="PRONTUARIO_RISCO",
			joinColumns = @JoinColumn(name="risco_id"),
			inverseJoinColumns = @JoinColumn(name="prontuario_id")
	)
	private List<Risco> riscos = new ArrayList<>();
	
	@OneToMany(mappedBy="prontuario")
	private List<LinhaDeCuidado> linhasDeCuidado = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="PRONTUARIO_MEDICAMENTO",
			joinColumns = @JoinColumn(name="medicamento_id"),
			inverseJoinColumns = @JoinColumn(name="prontuario_id")
	)
	private List<Medicamento> medicamentos = new ArrayList<>();
	
	//Construtores
	
	public Prontuario() {
	}
	
	public Prontuario(Integer id, Integer score, Paciente paciente) {
		super();
		this.id = id;
		this.score = score;
		this.paciente = paciente;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Risco> getRiscos() {
		return riscos;
	}

	public void setRiscos(List<Risco> riscos) {
		this.riscos = riscos;
	}

	public List<LinhaDeCuidado> getLinhasDeCuidado() {
		return linhasDeCuidado;
	}

	public void setLinhasDeCuidado(List<LinhaDeCuidado> linhasDeCuidado) {
		this.linhasDeCuidado = linhasDeCuidado;
	}
	
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
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
