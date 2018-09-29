package com.lifecare.domain;

import javax.persistence.Entity;

@Entity
public class Paciente extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	
	private Medico medico;
	private Prontuario prontuario;

	//Construtores
	
	public Paciente() {
	}
	
	public Paciente(Medico medico, Prontuario prontuario, Integer id, String nome, Integer idade, String email, String senha) {
		super(id, nome, idade, email, senha);
		this.medico = medico;
		this.prontuario = prontuario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

}
