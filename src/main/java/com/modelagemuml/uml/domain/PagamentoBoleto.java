package com.modelagemuml.uml.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;


@Entity
public class PagamentoBoleto extends Pagamento{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	
	public PagamentoBoleto() {
		super();
		// TODO Auto-generated constructor stub
	}
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	public PagamentoBoleto(Integer id, Integer estado, Pedido pedido,Date datavencimento,Date datapagamento) {
		super(id, estado, pedido);
		this.dataVencimento=datavencimento;
		this.dataPagamento = datapagamento;
	}
	
	
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	

}
