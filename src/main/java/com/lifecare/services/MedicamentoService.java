package com.lifecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lifecare.domain.Medicamento;
import com.lifecare.repositories.MedicamentoRepository;
import com.lifecare.services.exceptions.DataIntegrityException;
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
	
	public Medicamento insert(Medicamento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Medicamento update(Medicamento obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir pois há entidades associadas a este objeto");
		}		
	}
	
	public List<Medicamento> findAll() {
		return repo.findAll();
	}
	
	public Page<Medicamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
