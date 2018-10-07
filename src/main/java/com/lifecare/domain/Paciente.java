package com.lifecare.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Paciente extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Medico medico;
	
	@JsonIgnore
	@OneToOne(mappedBy="paciente")
	private Prontuario prontuario;
	
	@JsonIgnore
	@OneToOne(mappedBy="paciente")
	private Chat chat;
	
	//Construtores
	
	public Paciente() {
	}

	public Paciente(Integer id, String nome, Integer idade, String email, String senha, Medico medico, Prontuario prontuario, Chat chat) {
		super(id, nome, idade, email, senha);
		this.medico = medico;
		this.prontuario = prontuario;
		this.chat = chat;
	}
	
	
	//Getters e setters

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

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}
