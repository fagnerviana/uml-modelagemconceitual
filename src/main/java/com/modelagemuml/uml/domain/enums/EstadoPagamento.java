package com.modelagemuml.uml.domain.enums;

public enum EstadoPagamento {
	// melhor fazer o controle manual das numerações e informar a descrição
		PENDENTE(1, "Pendente"), 
		QUITADO(2, "Quitado"),
		CANCELADO(3,"Cancelado");

		private int cod;
		private String descricao;

		private EstadoPagamento(int i, String string) {
			this.cod=cod;
			this.descricao=descricao;
		}
		
		public static EstadoPagamento toEnum(Integer cod) {

			if (cod == null) {
				return null;
			}

			for (EstadoPagamento x : EstadoPagamento.values()) {
				if (cod.equals(x.getCod())) {
					return x;
				}
			}
			throw new IllegalArgumentException("Id inválido: " + cod);
		}

		public int getCod() {
			return cod;
		}

		
		public String getDescricao() {
			return descricao;
		}

		
		

		
}
