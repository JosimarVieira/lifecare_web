package com.lifecare.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lifecare.domain.Medico;
import com.lifecare.domain.dto.MedicoDTO;
import com.lifecare.services.MedicoService;

@RestController
@RequestMapping(value="/medicos")
public class MedicoResource {
	
	@Autowired 
	private MedicoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Medico> find(@PathVariable Integer id){
		Medico obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Medico obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri(); // pega a URI do novo recurso inserido
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Medico obj, @PathVariable Integer id){
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
	public ResponseEntity<List<MedicoDTO>> findAll(){
		List<Medico> list = service.findAll();
		List<MedicoDTO> listDto = list.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList()); //percorre o list e cria um objeto MedicoDTO
		return ResponseEntity.ok().body(listDto);
	}
	
}
