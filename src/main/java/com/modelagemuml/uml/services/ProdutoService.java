package com.modelagemuml.uml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelagemuml.uml.domain.Produto;
import com.modelagemuml.uml.repositories.ProdutoRepository;
import com.modelagemuml.uml.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	
	public Optional<Produto> buscar(Integer id) {
		Optional<Produto> obj = produtorepository.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: "+id
					+ ", Tipo: "+ Produto.class.getName());
		}
		//return Optional.ofNullable(obj.orElseThrow());
				return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName())));
		
		
	}

}


