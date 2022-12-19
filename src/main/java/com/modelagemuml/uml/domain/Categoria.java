package com.modelagemuml.uml.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Comentario informando que esta classe é uma entidade.
@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Esta anotação informa que o atributo ID , será uma pk e o @GeneratedValue - irá gerar os id automaticamente
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	//Contrutores
	public Categoria() {
		
	}
	
	public Categoria(Integer id,String nome) {
		this.id=id;
		this.nome=nome;
	}
	
	//Equals e hascode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	//Getter e Setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
