package com.lifecare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Prontuario;
import com.lifecare.repositories.ProntuarioRepository;
import com.lifecare.services.exceptions.ObjectNotFoundException;

@Service
public class ProntuarioService {

	@Autowired
	private ProntuarioRepository repo;
	
	public Prontuario find(Integer id) {
		Prontuario obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + " Tipo: " + Prontuario.class.getName());
		}
		return obj;
	}
	
}
