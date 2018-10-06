package com.lifecare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Cidade;
import com.lifecare.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public Cidade buscar(Integer id) {
		Cidade obj = repo.findOne(id);
		return obj;
	}
	
}
