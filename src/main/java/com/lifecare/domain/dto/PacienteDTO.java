package com.lifecare.domain.dto;

import java.io.Serializable;

import com.lifecare.domain.Paciente;

public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer idade;
	private String email;
	
	public PacienteDTO() {
	}
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		nome = obj.getNome();
		idade = obj.getIdade();
		email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
