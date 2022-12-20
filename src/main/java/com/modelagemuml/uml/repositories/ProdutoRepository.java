package com.modelagemuml.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelagemuml.uml.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	
}
