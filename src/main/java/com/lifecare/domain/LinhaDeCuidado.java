package com.lifecare.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LinhaDeCuidado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String acoes;
	private String titulo;
	
	@OneToMany(mappedBy="linhaDeCuidado")
	private List<Site> sites = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="prontuario_id")
	private Prontuario prontuario;
	
	//Construtores
	
	public LinhaDeCuidado() {
	}
	
	public LinhaDeCuidado(Integer id, String acoes, String titulo, List<Site> sites, Prontuario prontuario) {
		super();
		this.id = id;
		this.acoes = acoes;
		this.titulo = titulo;
		this.sites = sites;
		this.prontuario = prontuario;
	}

	
	//Getters e setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAcoes() {
		return acoes;
	}

	public void setAcoes(String acoes) {
		this.acoes = acoes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
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
		LinhaDeCuidado other = (LinhaDeCuidado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
