package com.modelagemuml.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modelagemuml.uml.domain.Cidade;

@Repository
public interface CidadeRepository<T> extends JpaRepository<Cidade, Integer> {

}
