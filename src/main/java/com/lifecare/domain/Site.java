package com.lifecare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Site implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String url;
	
	@ManyToOne
	@JoinColumn(name="linha_de_cuidado_id")
	private LinhaDeCuidado linhaDeCuidado;
	
	
	//Construtores
	
	public Site() {
	}
		
	public Site(Integer id, String url, LinhaDeCuidado linhaDeCuidado) {
		super();
		this.id = id;
		this.url = url;
		this.linhaDeCuidado = linhaDeCuidado;
	}


	//Getters e setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LinhaDeCuidado getLinhaDeCuidado() {
		return linhaDeCuidado;
	}

	public void setLinhaDeCuidado(LinhaDeCuidado linhaDeCuidado) {
		this.linhaDeCuidado = linhaDeCuidado;
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
		Site other = (Site) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
