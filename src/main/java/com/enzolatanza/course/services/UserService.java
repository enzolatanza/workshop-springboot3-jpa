package com.enzolatanza.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzolatanza.course.entities.User;
import com.enzolatanza.course.repositories.UserRepository;

//Registrando um componente com @Component
@Service
public class UserService {
	//@Autowired faz com que o Spring faça a injeção de dependência de forma automática
	@Autowired
	private UserRepository repository;
	/*
	 * Fazemos uma operação na camada de serviços que é o findAll() que repassa a chamada para o repository findAll
	 * */
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
