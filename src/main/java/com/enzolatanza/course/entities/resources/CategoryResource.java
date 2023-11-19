package com.enzolatanza.course.entities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzolatanza.course.entities.Category;
import com.enzolatanza.course.services.CategoryService;

//classe para implementar os recursos web da classe Category
//Trata-se de um controlado REST que responde ao caminho Categorys

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	//indica ao spring para fazer a injeção de dependência automática com CategoryService
	@Autowired
	private CategoryService service;
	//endpoint para acessar os usuarios
	//Annotation para indicar que o metodo responde a uma requisição get do http
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		//retorna uma resposta sinalizando ok com o corpo body com o usuario instanciado
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
