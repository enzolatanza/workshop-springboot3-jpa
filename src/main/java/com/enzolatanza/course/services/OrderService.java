package com.enzolatanza.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzolatanza.course.entities.Order;
import com.enzolatanza.course.repositories.OrderRepository;

//Registrando um componente com @Component
@Service
public class OrderService {
	//@Autowired faz com que o Spring faça a injeção de dependência de forma automática
	@Autowired
	private OrderRepository repository;
	/*
	 * Fazemos uma operação na camada de serviços que é o findAll() que repassa a chamada para o repository findAll
	 * */
	public List<Order> findAll(){
		return repository.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
