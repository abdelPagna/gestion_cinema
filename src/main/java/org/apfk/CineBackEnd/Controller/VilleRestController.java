package org.apfk.CineBackEnd.Controller;

import java.util.List;

import org.apfk.CineBackEnd.entities.Ville;
import org.apfk.CineBackEnd.repositories.VilleRepository;
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
public class VilleRestController {
	@Autowired
	private VilleRepository villeRepository;
	
	@GetMapping("/villes/{id}")
	public Ville getVilleById(@PathVariable(name = "id") Long id) {
		return villeRepository.findById(id).get();
	}
	
	@GetMapping("/villes")
	public List<Ville> villes(){
		return villeRepository.findAll();
	}
	
	@PostMapping("/villes")
	public Ville saveVille(@RequestBody Ville ville) {
		return villeRepository.save(ville);
	}
	
	@PutMapping("/villes/{id}")
	public Ville updateVille(@PathVariable(name = "id") Long id, @RequestBody Ville ville) {
		ville.setId(id);
		return villeRepository.save(ville);
	}
	
	@DeleteMapping("/villes/{id}")
	public void deleteVille(@PathVariable(name = "id") Long id) {
		villeRepository.deleteById(id);
	}

}
