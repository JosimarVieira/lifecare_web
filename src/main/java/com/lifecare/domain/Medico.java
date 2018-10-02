package com.lifecare.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Medico extends Pessoa{	

	private static final long serialVersionUID = 1L;
	
	
	//Atributos
	
	@OneToMany
	@JoinColumn(name="especialidade_id")
	private List<Especialidade> especialidades = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name="paciente_id")
	private List<Paciente> pacientes = new ArrayList<>();
	
	
	//Construtores
	
	public Medico() {
	}
	
	public Medico(Integer id, String nome, Integer idade, String email, String senha) {
		super(id, nome, idade, email, senha);
	}

	//Getters e setters
	
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
