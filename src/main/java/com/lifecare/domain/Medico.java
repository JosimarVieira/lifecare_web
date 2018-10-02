package com.lifecare.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Medico extends Pessoa{	

	private static final long serialVersionUID = 1L;
	
	
	//Atributos
	
	@ElementCollection
	@CollectionTable(name="ESPECIALIDADE")
	private Set<String> especialidades = new HashSet<>(); //não deixa repetir
	
	@OneToMany(mappedBy="medico")
	private List<Paciente> pacientes = new ArrayList<>();
	
	@OneToMany(mappedBy="medico")
	private List<ItemChat> itensChat = new ArrayList<>();
	
	
	//Construtores
	
	public Medico() {
	}
	
	public Medico(Integer id, String nome, Integer idade, String email, String senha) {
		super(id, nome, idade, email, senha);
	}
	
	
	//Getters e setters

	public Set<String> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<String> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<ItemChat> getItensChat() {
		return itensChat;
	}

	public void setItensChat(List<ItemChat> itensChat) {
		this.itensChat = itensChat;
	}


}
