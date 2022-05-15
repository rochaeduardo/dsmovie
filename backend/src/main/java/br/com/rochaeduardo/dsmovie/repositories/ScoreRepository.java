package br.com.rochaeduardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rochaeduardo.dsmovie.entities.Score;
import br.com.rochaeduardo.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
