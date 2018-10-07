package com.lifecare.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifecare.domain.Paciente;
import com.lifecare.domain.dto.PacienteDTO;
import com.lifecare.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@Autowired 
	private PacienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Paciente> find(@PathVariable Integer id){
		Paciente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Paciente obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAll(){
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList()); //percorre o list e cria um objeto PacienteDTO
		return ResponseEntity.ok().body(listDto);
	}

}
