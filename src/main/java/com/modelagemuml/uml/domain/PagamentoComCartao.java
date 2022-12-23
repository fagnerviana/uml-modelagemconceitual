package com.modelagemuml.uml.domain;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{
	private Integer numeroDeParcelas;
	
	

	public PagamentoComCartao() {
		
		// TODO Auto-generated constructor stub
	}
		

	public PagamentoComCartao(Integer id, Integer estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas=numeroDeParcelas;
		
	}


	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	

}
