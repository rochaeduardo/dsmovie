package br.com.rochaeduardo.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rochaeduardo.dsmovie.dto.MovieDTO;
import br.com.rochaeduardo.dsmovie.dto.ScoreDTO;
import br.com.rochaeduardo.dsmovie.entities.Movie;
import br.com.rochaeduardo.dsmovie.entities.Score;
import br.com.rochaeduardo.dsmovie.entities.User;
import br.com.rochaeduardo.dsmovie.repositories.MovieRepository;
import br.com.rochaeduardo.dsmovie.repositories.ScoreRepository;
import br.com.rochaeduardo.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());

		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		scoreRepository.save(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}

		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movie = movieRepository.save(movie);

		return new MovieDTO(movie);
	}

}
