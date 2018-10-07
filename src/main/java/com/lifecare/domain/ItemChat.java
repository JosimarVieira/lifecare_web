package com.lifecare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemChat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String conversa;
	private int estado; //mensagem enviada, lido
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="chat_id")
	private Chat chat;
	
	
	//Construtores
	
	public ItemChat() {
	}

	public ItemChat(Integer id, String conversa, int estado, Medico medico, Chat chat) {
		super();
		this.id = id;
		this.conversa = conversa;
		this.estado = estado;
		this.medico = medico;
		this.chat = chat;
	}

	
	//Getters e setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConversa() {
		return conversa;
	}

	public void setConversa(String conversa) {
		this.conversa = conversa;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
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
		ItemChat other = (ItemChat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
