package com.lifecare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Medicamento;
import com.lifecare.repositories.MedicamentoRepository;
import com.lifecare.services.exceptions.ObjectNotFoundException;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository repo;
	
	public Medicamento find(Integer id) {
		Medicamento obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + " Tipo: " + Medicamento.class.getName());
		}
		return obj;
	}
	
}
