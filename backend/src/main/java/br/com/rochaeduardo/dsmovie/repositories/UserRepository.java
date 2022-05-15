package br.com.rochaeduardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rochaeduardo.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
