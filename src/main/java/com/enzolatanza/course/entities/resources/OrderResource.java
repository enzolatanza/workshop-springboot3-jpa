package com.enzolatanza.course.entities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzolatanza.course.entities.Order;
import com.enzolatanza.course.services.OrderService;

//classe para implementar os recursos web da classe Order
//Trata-se de um controlado REST que responde ao caminho Orders

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	//indica ao spring para fazer a injeção de dependência automática com OrderService
	@Autowired
	private OrderService service;
	//endpoint para acessar os usuarios
	//Annotation para indicar que o metodo responde a uma requisição get do http
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		//retorna uma resposta sinalizando ok com o corpo body com o usuario instanciado
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
