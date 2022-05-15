package br.com.rochaeduardo.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rochaeduardo.dsmovie.dto.MovieDTO;
import br.com.rochaeduardo.dsmovie.dto.ScoreDTO;
import br.com.rochaeduardo.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	ScoreService service;

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
		MovieDTO movieDTO = service.saveScore(scoreDTO);
		return movieDTO;
	}

}
