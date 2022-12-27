package com.modelagemuml.uml;

import java.text.SimpleDateFormat;
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
import com.modelagemuml.uml.domain.ItemPedido;
import com.modelagemuml.uml.domain.Pagamento;

import com.modelagemuml.uml.domain.PagamentoComCartao;
import com.modelagemuml.uml.domain.Pedido;
import com.modelagemuml.uml.domain.Produto;
import com.modelagemuml.uml.domain.enums.EstadoPagamento;
import com.modelagemuml.uml.domain.enums.TipoCliente;
import com.modelagemuml.uml.repositories.CategoriaRepository;
import com.modelagemuml.uml.repositories.CidadeRepository;
import com.modelagemuml.uml.repositories.ClienteRepository;
import com.modelagemuml.uml.repositories.EnderecoRepository;
import com.modelagemuml.uml.repositories.EstadoRepository;
import com.modelagemuml.uml.repositories.ItemPedidoRepository;
import com.modelagemuml.uml.repositories.PagamentoRepository;
import com.modelagemuml.uml.repositories.PedidoRepository;
import com.modelagemuml.uml.repositories.ProdutoRepository;


@SpringBootApplication
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
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

		cli1.getEndereco().addAll(Arrays.asList(e1, e2));
				
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido pedi1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido pedi2 = new Pedido(null, sdf.parse("10/09/2017 10:32"),cli1,e1);
		
		//Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,pedi1,6);
		Pagamento pagto1 = new PagamentoComCartao(null,2, pedi1, 6);
		pedi1.setPagamento(pagto1);
		//Pagamento pagto2 = new PagamentoBoleto(null,2, pedi2, sdf.parse("20/10/2022 18:30"), null);
		//pedi2.setPagamento(pagto2);
		cli1.getPedidos().addAll(Arrays.asList(pedi1,pedi2));
		
		pedidoRepository.saveAll(Arrays.asList(pedi1,pedi2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1));
		
		ItemPedido ip1= new ItemPedido(pedi1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(pedi1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(pedi2,p2,100.00,1,800.00);
		
		pedi1.getItens().addAll(Arrays.asList(ip1,ip2));
		pedi2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p1.getItens().addAll(Arrays.asList(ip1));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

	}
	
	
	

}
