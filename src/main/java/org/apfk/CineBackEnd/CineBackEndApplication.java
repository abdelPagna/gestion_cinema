package org.apfk.CineBackEnd;

import org.apfk.CineBackEnd.entities.Film;
import org.apfk.CineBackEnd.services.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CineBackEndApplication implements CommandLineRunner{

	@Autowired
	private ICinemaInitService cinemaInitService;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CineBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cinemaInitService.initCategories();
	}

}
