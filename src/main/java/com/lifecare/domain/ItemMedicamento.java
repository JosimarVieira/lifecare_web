package com.lifecare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemMedicamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore //não será serializado
	@EmbeddedId
	private ItemMedicamentoPK id = new ItemMedicamentoPK();
	
	private Integer qt;
	
	public ItemMedicamento() {
	}
	
	public ItemMedicamento(Medicamento m, Prontuario p, Integer qt) {
		super();
		id.setMedicamento(m);
		id.setProntuario(p);
		this.qt = qt;
	}
	
	public ItemMedicamentoPK getId() {
		return id;
	}

	public void setId(ItemMedicamentoPK id) {
		this.id = id;
	}

	public Integer getQt() {
		return qt;
	}

	public void setQt(Integer qt) {
		this.qt = qt;
	}

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
		ItemMedicamento other = (ItemMedicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}

	
