package com.enzolatanza.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzolatanza.course.entities.Category;
import com.enzolatanza.course.repositories.CategoryRepository;

//Registrando um componente com @Component
@Service
public class CategoryService {
	//@Autowired faz com que o Spring faça a injeção de dependência de forma automática
	@Autowired
	private CategoryRepository repository;
	/*
	 * Fazemos uma operação na camada de serviços que é o findAll() que repassa a chamada para o repository findAll
	 * */
	public List<Category> findAll(){
		return repository.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
