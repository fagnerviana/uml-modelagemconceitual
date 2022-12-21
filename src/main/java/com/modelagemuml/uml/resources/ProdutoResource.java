package com.modelagemuml.uml.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.modelagemuml.uml.domain.Produto;
import com.modelagemuml.uml.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	@Autowired
	private ProdutoService produto;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
			Optional<Produto> obj = produto.buscar(id);
					
		return ResponseEntity.ok().body(obj);
	} 

}
