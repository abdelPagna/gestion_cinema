package org.apfk.CineBackEnd.services.impl;

import java.util.List;
import java.util.Optional;

import org.apfk.CineBackEnd.dto.CategorieDto;
import org.apfk.CineBackEnd.entities.Categorie;
import org.apfk.CineBackEnd.exceptions.ErrorEnum;
import org.apfk.CineBackEnd.mapper.CategorieMapper;
import org.apfk.CineBackEnd.repositories.CategorieRepository;
import org.apfk.CineBackEnd.services.CategorieService;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService{
	private final CategorieRepository categorieRepository;
	private final CategorieMapper categorieMapper;
	
	public List<CategorieDto> findAllCategories() {		
		List<Categorie> listCategories= categorieRepository.findAll();
		return categorieMapper.toDto(listCategories);
	}

	@Override
	public CategorieDto getOne(Long id) {
		Optional<Categorie> categorie=categorieRepository.findById(id);
		if(categorie.isPresent()) {
			return categorieMapper.toDto(categorie.get());
		} else {
			return null;
		}
	}

	@Override
	public CategorieDto save(CategorieDto categorieDto) {
		Categorie categorie=categorieMapper.toEntity(categorieDto);
		//logique métier
		return categorieMapper.toDto(categorieRepository.save(categorie));
	}

	@Override
	public void delete(Long id) {
		Optional<Categorie> categorie=categorieRepository.findById(id);
		if(categorie.isPresent()) {
			categorieRepository.delete(categorie.get());
		} else {
			//appliquer l'exception
		}
	}

	@Override
	public CategorieDto update(CategorieDto categorieDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
