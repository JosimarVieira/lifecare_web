package com.lifecare.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifecare.domain.Medicamento;
import com.lifecare.services.MedicamentoService;

@RestController
@RequestMapping(value="/medicamentos")
public class MedicamentoResource {
	
	@Autowired 
	private MedicamentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Medicamento> find(@PathVariable Integer id){
		Medicamento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
