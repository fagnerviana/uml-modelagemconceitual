package com.modelagemuml.uml.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;




//Comentario informando que esta classe é uma entidade.
@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Esta anotação informa que o atributo ID , será uma pk e o @GeneratedValue - irá gerar os id automaticamente
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonBackReference
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();	
	
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
