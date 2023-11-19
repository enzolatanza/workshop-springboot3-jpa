package com.enzolatanza.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.enzolatanza.course.entities.Order;
import com.enzolatanza.course.entities.User;
import com.enzolatanza.course.entities.enums.OrderStatus;
import com.enzolatanza.course.repositories.OrderRepository;
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
	@Autowired
	private OrderRepository orderRepository;
	//tudo que colocar no metodo run sera executado quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.CANCELED, u1);
		
		//passa como um parâmetros uma lista
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
}
