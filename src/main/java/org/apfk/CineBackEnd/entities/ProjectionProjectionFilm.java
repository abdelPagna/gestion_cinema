package org.apfk.CineBackEnd.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types = {ProjectionFilm.class})
public interface ProjectionProjectionFilm {
	public Long getId();
	public double getPrix();
	public Date getDateProjection();
	public Salle getSalle();
	public Film getFilm();
	public List<Ticket> getTickets();
}
