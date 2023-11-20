package com.enzolatanza.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.enzolatanza.course.entities.User;
import com.enzolatanza.course.repositories.UserRepository;
import com.enzolatanza.course.services.exceptions.DatabaseException;
import com.enzolatanza.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
		/*
		 * SEMPRE QUE QUISER SABER QUAL EXCEÇÃO ESTA DANDO  USAR
		 * A ROTINA ABAIXO QUE CAPTURA A EXCEÇÃO E LANÇA
		 * NO CONSOLE
		 * catch(RuntimeException e) {
			throw new e.printStackTrace();
		}
		*/
		
		
	}
	public User update(Long id, User obj) {
		//pega um objeto monitorado 
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
