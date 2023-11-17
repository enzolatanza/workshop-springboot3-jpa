package com.enzolatanza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enzolatanza.course.entities.User;

/*Apesar de criar uma interface não será necessário implementá-la pois
 * o SpringJPA já possui uma implementação padrão para ela*/
//JpaRepository<Entidade, Tipo do Id da entidade>
public interface UserRepository extends JpaRepository<User, Long> {

}
