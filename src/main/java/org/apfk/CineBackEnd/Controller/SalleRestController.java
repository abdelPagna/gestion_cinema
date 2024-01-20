package org.apfk.CineBackEnd.Controller;

import java.util.List;

import org.apfk.CineBackEnd.entities.Salle;
import org.apfk.CineBackEnd.repositories.SalleRepository;
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
public class SalleRestController {
	@Autowired
	private SalleRepository salleRepository;
	
	@GetMapping("/salles/{id}")
	public Salle getSalleById(@PathVariable(name = "id") Long id) {
		return salleRepository.findById(id).get();
	}
	
	@GetMapping("/salles")
	public List<Salle> salles(){
		return salleRepository.findAll();
	}
	
	@PostMapping("/salles")
	public Salle saveSalle(@RequestBody Salle salle) {
		return salleRepository.save(salle);
	}
	
	@PutMapping("/salles/{id}")
	public Salle updateSalle(@PathVariable(name = "id") Long id, @RequestBody Salle salle) {
		salle.setId(id);
		return salleRepository.save(salle);
	}
	
	@DeleteMapping("/salles/{id}")
	public void deleteSalle(@PathVariable(name = "id") Long id) {
		salleRepository.deleteById(id);
	}

}
