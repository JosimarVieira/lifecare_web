package com.lifecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Medico;
import com.lifecare.repositories.MedicoRepository;
import com.lifecare.services.exceptions.DataIntegrityException;
import com.lifecare.services.exceptions.ObjectNotFoundException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repo;
	
	public Medico find(Integer id) {
		Medico obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + " Tipo: " + Medico.class.getName());
		}
		return obj;
	}

	public Medico insert(Medico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Medico update(Medico obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um médico que possui pacientes");
		}		
	}
	
	public List<Medico> findAll() {
		return repo.findAll();
	}
	
	public Page<Medico> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
