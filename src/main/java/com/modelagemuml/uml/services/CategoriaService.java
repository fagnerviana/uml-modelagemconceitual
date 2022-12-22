package com.modelagemuml.uml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modelagemuml.uml.domain.Categoria;
import com.modelagemuml.uml.repositories.CategoriaRepository;
import com.modelagemuml.uml.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categrepository;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = categrepository.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: "+id
					+ ", Tipo: "+ Categoria.class.getName());
		}
		
		//return Optional.ofNullable(obj.orElseThrow());
		return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())));
	}

}
