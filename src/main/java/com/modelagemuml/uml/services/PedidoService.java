package com.modelagemuml.uml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modelagemuml.uml.domain.Pedido;
import com.modelagemuml.uml.repositories.PedidoRepository;
import com.modelagemuml.uml.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidopository;
	
	public Optional<Pedido> buscar(Integer id) {
		Optional<Pedido> obj = pedidopository.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: "+id
					+ ", Tipo: "+ Pedido.class.getName());
		}
		
		//return Optional.ofNullable(obj.orElseThrow());
		return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())));
	}

}
