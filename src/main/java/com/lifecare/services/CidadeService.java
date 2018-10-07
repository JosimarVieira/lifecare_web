package com.lifecare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Cidade;
import com.lifecare.repositories.CidadeRepository;
import com.lifecare.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public Cidade find(Integer id) {
		Cidade obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + " Tipo: " + Cidade.class.getName());
		}
		return obj;
	}
	
}
