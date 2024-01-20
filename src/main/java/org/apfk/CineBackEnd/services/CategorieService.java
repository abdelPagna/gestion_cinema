package org.apfk.CineBackEnd.services;

import java.util.List;

import org.apfk.CineBackEnd.dto.CategorieDto;
import org.apfk.CineBackEnd.entities.Categorie;


public interface CategorieService {
	 List<CategorieDto> findAllCategories();
	 CategorieDto getOne(Long id);
	 CategorieDto save(CategorieDto categorieDto);
	 void delete(Long id);
	 CategorieDto update(CategorieDto categorieDto, Long id);
}
