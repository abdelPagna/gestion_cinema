package org.apfk.CineBackEnd.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apfk.CineBackEnd.entities.Film;
import org.apfk.CineBackEnd.entities.Ticket;
import org.apfk.CineBackEnd.repositories.FilmRepository;
import org.apfk.CineBackEnd.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
public class CinemaRestWebController {
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable (name="id")Long id) throws Exception{
		Film film=filmRepository.findById(id).get();
		String photoName=film.getPhoto();
		File file=new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
	
	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
		List<Ticket> listTickets=new ArrayList<Ticket>();
		ticketForm.getTickets().forEach(idTicket ->{
			System.out.println(idTicket);
			Ticket ticket=ticketRepository.findById(idTicket).get();
			ticket.setNameClient(ticketForm.getNameClient());
			ticket.setReservee(true);
			ticket.setCodePayement(ticketForm.getCodePayement());
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		return listTickets;
	}
	
	@Data @NoArgsConstructor
	static class TicketForm{
		private String nameClient;
		private int codePayement;
		private List<Long> tickets=new ArrayList<Long>();
		
		public TicketForm(String nameClient, int codePayement, List<Long> tickets) {
	        this.nameClient = nameClient;
	        this.codePayement = codePayement;
	        this.tickets = tickets;
	    }
	}
	
	/*
	 * @Autowired private FilmRepository filmRepository;
	 * 
	 * @GetMapping("/listFilms") public List<Film> films(){ return
	 * filmRepository.findAll(); }
	 */
}
