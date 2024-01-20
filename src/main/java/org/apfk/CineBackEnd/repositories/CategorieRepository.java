package org.apfk.CineBackEnd.repositories;

import org.apfk.CineBackEnd.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
