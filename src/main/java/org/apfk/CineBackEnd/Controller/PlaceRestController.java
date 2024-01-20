package org.apfk.CineBackEnd.Controller;

import java.util.List;

import org.apfk.CineBackEnd.entities.Place;
import org.apfk.CineBackEnd.repositories.PlaceRepository;
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
public class PlaceRestController {
	@Autowired
	private PlaceRepository placeRepository;
	
	@GetMapping("/places/{id}")
	public Place getPlaceById(@PathVariable(name = "id") Long id) {
		return placeRepository.findById(id).get();
	}
	
	@GetMapping("/places")
	public List<Place> places(){
		return placeRepository.findAll();
	}
	
	@PostMapping("/places")
	public Place savePlace(@RequestBody Place place) {
		return placeRepository.save(place);
	}
	
	@PutMapping("/places/{id}")
	public Place updatePlace(@PathVariable(name = "id") Long id, @RequestBody Place place) {
		place.setId(id);
		return placeRepository.save(place);
	}
	
	@DeleteMapping("/places/{id}")
	public void deletePlace(@PathVariable(name = "id") Long id) {
		placeRepository.deleteById(id);
	}

}
