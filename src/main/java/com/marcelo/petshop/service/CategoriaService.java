package com.marcelo.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.petshop.domain.Categoria;
import com.marcelo.petshop.repository.CategoriaRepository;

@Service

public class CategoriaService {

	@Autowired 
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
