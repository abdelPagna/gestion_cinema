package org.apfk.CineBackEnd.Controller;

import java.util.List;

import org.apfk.CineBackEnd.entities.Film;
import org.apfk.CineBackEnd.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FilmRestController {
	@Autowired
	private FilmRepository filmRepository;
	
	@GetMapping("/films/{id}")
	public Film getFilmById(@PathVariable(name = "id") Long id) {
		return filmRepository.findById(id).get();
	}
	
	@GetMapping("/films")
	public List<Film> films(){
		return filmRepository.findAll();
	}
	
	@PostMapping("/films")
	public Film saveFilm(@RequestBody Film film) {
		return filmRepository.save(film);
	}
	
	@PutMapping("/films/{id}")
	public Film updateFilm(@PathVariable(name = "id") Long id, @RequestBody Film film) {
		film.setId(id);
		return filmRepository.save(film);
	}
	
	@DeleteMapping("/films/{id}")
	public void deleteFilm(@PathVariable(name = "id") Long id) {
		filmRepository.deleteById(id);
	}
}
