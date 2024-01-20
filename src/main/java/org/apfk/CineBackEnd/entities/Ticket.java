package org.apfk.CineBackEnd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameClient;
	private double prix;
	@Column(unique = false, nullable = true)
	private int codePayement;
	private boolean reservee;
	@ManyToOne
	private ProjectionFilm projectionFilm;
	@ManyToOne
	private Place place;
}
