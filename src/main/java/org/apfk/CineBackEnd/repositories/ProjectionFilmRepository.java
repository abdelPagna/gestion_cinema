package org.apfk.CineBackEnd.repositories;

import org.apfk.CineBackEnd.entities.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProjectionFilmRepository extends JpaRepository<ProjectionFilm, Long>{

}
