package org.apfk.CineBackEnd.Controller;

import java.util.List;

import org.apfk.CineBackEnd.entities.ProjectionFilm;
import org.apfk.CineBackEnd.repositories.ProjectionFilmRepository;
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
public class ProjectionFilmRestController {
	@Autowired
	private ProjectionFilmRepository projectionFilmRepository;
	
	@GetMapping("/projectionFilms/{id}")
	public ProjectionFilm getProjectionFilmById(@PathVariable(name = "id") Long id) {
		return projectionFilmRepository.findById(id).get();
	}
	
	@GetMapping("/projectionFilms")
	public List<ProjectionFilm> projectionFilms(){
		return projectionFilmRepository.findAll();
	}
	
	@PostMapping("/projectionFilms")
	public ProjectionFilm saveProjectionFilm(@RequestBody ProjectionFilm projectionFilm) {
		return projectionFilmRepository.save(projectionFilm);
	}
	
	@PutMapping("/projectionFilms/{id}")
	public ProjectionFilm updateProjectionFilm(@PathVariable(name = "id") Long id, @RequestBody ProjectionFilm projectionFilm) {
		projectionFilm.setId(id);
		return projectionFilmRepository.save(projectionFilm);
	}
	
	@DeleteMapping("/projectionFilms/{id}")
	public void deleteProjectionFilm(@PathVariable(name = "id") Long id) {
		projectionFilmRepository.deleteById(id);
	}

}
