package com.enzolatanza.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzolatanza.course.entities.Product;
import com.enzolatanza.course.repositories.ProductRepository;

//Registrando um componente com @Component
@Service
public class ProductService {
	//@Autowired faz com que o Spring faça a injeção de dependência de forma automática
	@Autowired
	private ProductRepository repository;
	/*
	 * Fazemos uma operação na camada de serviços que é o findAll() que repassa a chamada para o repository findAll
	 * */
	public List<Product> findAll(){
		return repository.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
