package com.lifecare.domain;

import javax.persistence.Entity;

@Entity
public class Gestor extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	public Gestor() {
	}

	public Gestor(Integer id, String nome, Integer idade, String email, String senha) {
		super(id, nome, idade, email, senha);
	}
	
}
