package com.modelagemuml.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modelagemuml.uml.domain.Pagamento;

//Esta interface irá realizar a tarefa de listar, deletar, buscar, entre outros 
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

		
}
