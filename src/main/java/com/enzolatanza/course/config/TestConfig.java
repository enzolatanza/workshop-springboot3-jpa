package com.enzolatanza.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.enzolatanza.course.entities.Category;
import com.enzolatanza.course.entities.Order;
import com.enzolatanza.course.entities.OrderItem;
import com.enzolatanza.course.entities.Product;
import com.enzolatanza.course.entities.User;
import com.enzolatanza.course.entities.enums.OrderStatus;
import com.enzolatanza.course.repositories.CategoryRepository;
import com.enzolatanza.course.repositories.OrderItemRepository;
import com.enzolatanza.course.repositories.OrderRepository;
import com.enzolatanza.course.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	//tudo que colocar no metodo run sera executado quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.CANCELED, u1);
		

		//passa como um parâmetros uma lista

		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		
		//associação entre produtos e categorias
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		//salvando as alterações
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	
	}
	
	
}
