package com.enzolatanza.course.entities.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzolatanza.course.entities.User;

//classe para implementar os recursos web da classe user
//Trata-se de um controlado REST que responde ao caminho users

@RestController
@RequestMapping(value="/users")
public class UserResource {
	//endpoint para acessar os usuarios
	//Annotation para indicar que o metodo responde a uma requisição get do http
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
		//retorna uma resposta sinalizando ok com o corpo body com o usuario instanciado
		return ResponseEntity.ok().body(u);
	}
}
