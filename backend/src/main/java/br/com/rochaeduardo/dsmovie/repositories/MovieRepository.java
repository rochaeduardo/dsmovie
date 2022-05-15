package br.com.rochaeduardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rochaeduardo.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
