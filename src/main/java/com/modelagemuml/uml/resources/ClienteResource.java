package com.modelagemuml.uml.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.modelagemuml.uml.domain.Cliente;
import com.modelagemuml.uml.services.ClienteService;


//@Api(value= "Cliente")
@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
			Optional<Cliente> obj = clienteService.buscar(id);
					
		return ResponseEntity.ok().body(obj);
	}
	
}
