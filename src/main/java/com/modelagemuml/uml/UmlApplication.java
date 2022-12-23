package com.modelagemuml.uml;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.modelagemuml.uml.domain.Categoria;
import com.modelagemuml.uml.domain.Cidade;
import com.modelagemuml.uml.domain.Cliente;
import com.modelagemuml.uml.domain.Endereco;
import com.modelagemuml.uml.domain.Estado;
import com.modelagemuml.uml.domain.Produto;
import com.modelagemuml.uml.domain.enums.TipoCliente;
import com.modelagemuml.uml.repositories.CategoriaRepository;
import com.modelagemuml.uml.repositories.CidadeRepository;
import com.modelagemuml.uml.repositories.ClienteRepository;
import com.modelagemuml.uml.repositories.EnderecoRepository;
import com.modelagemuml.uml.repositories.EstadoRepository;
import com.modelagemuml.uml.repositories.ProdutoRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UmlApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository<?> cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1= new Categoria(null,"Informatica");
		Categoria cat2= new Categoria(null,"Escritorio");
		
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));		
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Bahia");
		Estado est2 = new Estado(null,"Minas Gerais");
		Estado est3 = new Estado(null,"Rio de Jneiro");
		
		Cidade cid1 = new Cidade(null,"Salvador",est1);
		Cidade cid2 = new Cidade(null,"Lauro de Freitas",est1);
		Cidade cid3 = new Cidade(null,"Uberlandia",est2);
		Cidade cid4 = new Cidade(null,"Niteroi",est3);
		
		
		est1.getCidades().addAll(Arrays.asList(cid1,cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		est3.getCidades().addAll(Arrays.asList(cid4));
		
	  estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
	  cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3,cid4));
	  
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@email.com", "12345678910", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("71986191047", "71987334311"));
		
		Endereco e1 = new Endereco(null, "Rua Esperança de viver ", "12E", "Proximo escoal Cidade Nova", "Cidade Nova",
				"40313440", cli1, cid1);

		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid4);

		//cli1.getEndereco().addAll(Arrays.asList(e1, e2));
				
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		

	}
	
	
	

}
