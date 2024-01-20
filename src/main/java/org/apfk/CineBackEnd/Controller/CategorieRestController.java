package org.apfk.CineBackEnd.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apfk.CineBackEnd.dto.CategorieDto;
import org.apfk.CineBackEnd.entities.Categorie;
import org.apfk.CineBackEnd.repositories.CategorieRepository;
import org.apfk.CineBackEnd.services.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
@Slf4j
public class CategorieRestController {
	
	private final CategorieRepository categorieRepository;
	private final CategorieService categorieService;
	
	@GetMapping("")
	public ResponseEntity<?> categories(){
		log.info("Requete Rest pour rétourner la liste des catégories");
		Map<String, Object> map=new HashMap<>();
		map.put("categories", categorieService.findAllCategories());
		return ResponseEntity.ok(map);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategorieById(@PathVariable(name = "id") Long id) {
		log.info("Requete Rest pour rétourner une catégorie avec Id: {}", id);
		Map<String, Object> map=new HashMap<>();
		map.put("categorie", categorieService.getOne(id));
		return ResponseEntity.ok(map);
	}

	@PostMapping("")
	public ResponseEntity<?> saveCategorie(@RequestBody CategorieDto categorieDto) {
		log.info("Requete Rest pour enregister");
		Map<String, Object> map=new HashMap<>();
		map.put("categorie", categorieService.save(categorieDto));
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategorie(@RequestBody CategorieDto categorie, @PathVariable(name = "id") Long id) {
		log.info("Requete Rest pour mettre à jour une catégorie");
		Map<String, Object> map=new HashMap<>();
		map.put("categorie", categorieService.update(categorie,id));
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategorie(@PathVariable(name = "id") Long id) {
		log.info("Requete Rest pour supprimer une catégorie avec Id: {}", id);
		categorieService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
