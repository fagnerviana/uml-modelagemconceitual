package com.modelagemuml.uml.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelagemuml.uml.domain.Cliente;
import com.modelagemuml.uml.repositories.ClienteRepository;
import com.modelagemuml.uml.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository clientepository;
	
	public Optional<Cliente> buscar(Integer id) {
		Optional<Cliente> obj = clientepository.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: "+id
					+ ", Tipo: "+ Cliente.class.getName());
		}
		
		//return Optional.ofNullable(obj.orElseThrow());
		return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
	}
	

}
