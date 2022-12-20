package com.modelagemuml.uml.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelagemuml.uml.domain.Categoria;
import com.modelagemuml.uml.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categrepository;
	
	public Optional<Categoria> find(Integer id) {
		Optional<Categoria> obj = categrepository.findById(id);
		
		return obj;
		
	}

}
