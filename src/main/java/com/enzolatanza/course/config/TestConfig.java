package com.enzolatanza.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.enzolatanza.course.entities.User;
import com.enzolatanza.course.repositories.UserRepository;

/*
 * 
 * Classe de configuração específica para o perfil de teste
 * 
 * */
//@Configurationindicando que é uma classe de configuração
//@Profile("test") indicando que vai rodar no perfil de teste tem que ter o mesmo nome do "application.properties"
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	//classe para fazer o database-seeding para popular o banco de dados
	
	//framework possui um mecanismo de injeção de dependência automático
	//inserindo a annotation para o spring fazer a associação da dependência com TestConfig
	@Autowired
	private UserRepository userRepository;
	//tudo que colocar no metodo run sera executado quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		//passa como um parâmetros uma lista
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
	
}
