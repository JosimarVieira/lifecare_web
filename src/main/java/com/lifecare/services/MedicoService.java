package com.lifecare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Medico;
import com.lifecare.repositories.MedicoRepository;
import com.lifecare.services.exceptions.ObjectNotFoundException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repo;
	
	public Medico buscar(Integer id) {
		Medico obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + " Tipo: " + Medico.class.getName());
		}
		return obj;
	}
	
}
