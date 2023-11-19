package com.enzolatanza.course.entities.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enzolatanza.course.entities.User;
import com.enzolatanza.course.services.UserService;

//classe para implementar os recursos web da classe user
//Trata-se de um controlado REST que responde ao caminho users

@RestController
@RequestMapping(value="/users")
public class UserResource {
	//indica ao spring para fazer a injeção de dependência automática com UserService
	@Autowired
	private UserService service;
	//endpoint para acessar os usuarios
	//Annotation para indicar que o metodo responde a uma requisição get do http
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		//retorna uma resposta sinalizando ok com o corpo body com o usuario instanciado
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//verificando se foi inserido o objeto no banco
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
