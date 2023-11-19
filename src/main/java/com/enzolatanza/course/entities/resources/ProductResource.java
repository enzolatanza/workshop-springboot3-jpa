package com.enzolatanza.course.entities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzolatanza.course.entities.Product;
import com.enzolatanza.course.services.ProductService;

//classe para implementar os recursos web da classe Product
//Trata-se de um controlado REST que responde ao caminho Products

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	//indica ao spring para fazer a injeção de dependência automática com ProductService
	@Autowired
	private ProductService service;
	//endpoint para acessar os usuarios
	//Annotation para indicar que o metodo responde a uma requisição get do http
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		//retorna uma resposta sinalizando ok com o corpo body com o usuario instanciado
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
