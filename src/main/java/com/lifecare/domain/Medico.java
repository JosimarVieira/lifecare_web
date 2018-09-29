package com.lifecare.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Medico extends Pessoa{	

	private static final long serialVersionUID = 1L;
	
	
	//Atributos
	
	private Especialidade especialidade;
	private List<Paciente> pacientes = new ArrayList<>();
	
	
	//Construtores
	
	public Medico() {
	}
	
	public Medico(Integer id, String nome, Integer idade, String email, String senha, Especialidade especialidade) {
		super(id, nome, idade, email, senha);
		this.especialidade = especialidade;
	}
	
	
	//Getters e setters

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
}
