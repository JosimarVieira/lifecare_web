package com.lifecare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Paciente;
import com.lifecare.repositories.PacienteRepository;
import com.lifecare.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	public Paciente buscar(Integer id) {
		Paciente obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + " Tipo: " + Paciente.class.getName());
		}
		return obj;
	}
	
}
