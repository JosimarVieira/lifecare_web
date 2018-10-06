package com.lifecare.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifecare.domain.Prontuario;
import com.lifecare.services.ProntuarioService;

@RestController
@RequestMapping(value="/prontuarios")
public class ProntuarioResource {
	
	@Autowired 
	private ProntuarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Prontuario obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
