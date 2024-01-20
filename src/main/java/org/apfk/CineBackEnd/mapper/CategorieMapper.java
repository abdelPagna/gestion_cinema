package org.apfk.CineBackEnd.mapper;

import org.apfk.CineBackEnd.dto.CategorieDto;
import org.apfk.CineBackEnd.entities.Categorie;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface CategorieMapper extends EntityMapper<CategorieDto, Categorie>{

	
}
