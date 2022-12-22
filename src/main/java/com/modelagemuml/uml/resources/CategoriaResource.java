package com.modelagemuml.uml.resources;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.modelagemuml.uml.domain.Categoria;
import com.modelagemuml.uml.services.CategoriaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value= "Categoria")
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@ApiOperation(value="Pesquisa a categoria pelo numero do ID")
	@JsonManagedReference
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
			Optional<Categoria> obj = service.buscar(id);
					
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
