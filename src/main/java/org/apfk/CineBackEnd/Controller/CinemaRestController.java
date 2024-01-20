package org.apfk.CineBackEnd.Controller;

import java.util.List;

import org.apfk.CineBackEnd.entities.Cinema;
import org.apfk.CineBackEnd.repositories.CinemaRepository;
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
public class CinemaRestController {
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@GetMapping("/cinemas")
	public List<Cinema> cinemas(){
		return cinemaRepository.findAll();
	}
	
	@GetMapping("/cinemas/{id}")
	public Cinema getCinemaById(@PathVariable(name = "id") Long id) {
		return cinemaRepository.findById(id).get();
	}
	
	@PostMapping("/cinemas")
	public Cinema saveCinema(@RequestBody Cinema cinema) {
		return cinemaRepository.save(cinema);
	}
	
	@PutMapping("/cinemas/{id}")
	public Cinema updateCinema(@PathVariable(name = "id") Long id, @RequestBody Cinema cinema) {
		cinema.setId(id);
		return cinemaRepository.save(cinema);
	}
	
	@DeleteMapping("/cinemas/{id}")
	public void deleteCinema(@PathVariable(name = "id") Long id) {
		cinemaRepository.deleteById(id);
	}

}
