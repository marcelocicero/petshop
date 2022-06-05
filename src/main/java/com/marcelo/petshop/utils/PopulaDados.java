package com.marcelo.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcelo.petshop.domain.Categoria;
import com.marcelo.petshop.domain.Produto;
import com.marcelo.petshop.repository.CategoriaRepository;
import com.marcelo.petshop.repository.ProdutoRepository;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@Component
public class PopulaDados {

	@Autowired 
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void cadastrar() {
		Categoria cat1=new Categoria(null, "Alimentos");
		Categoria cat2=new Categoria(null, "Remédio");
		Categoria cat3=new Categoria(null, "Cosmético");
		
		Produto p1=new Produto(null,"Ração",100.00);
		Produto p2=new Produto(null,"Sache",80.00);
		Produto p3=new Produto(null,"Shampoo",50.00);
		Produto p4=new Produto(null,"Vermifugo",20.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		cat2.getProdutos().addAll(Arrays.asList(p4,p3));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2,cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
	}
}
