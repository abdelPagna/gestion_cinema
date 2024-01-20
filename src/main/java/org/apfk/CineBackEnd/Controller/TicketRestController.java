package org.apfk.CineBackEnd.Controller;

import java.util.List;

import org.apfk.CineBackEnd.entities.Ticket;
import org.apfk.CineBackEnd.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicketRestController {
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping("/tickets/{id}")
	public Ticket getTicketById(@PathVariable(name = "id") Long id) {
		return ticketRepository.findById(id).get();
	}
	
	@GetMapping("/tickets")
	public List<Ticket> tickets(){
		return ticketRepository.findAll();
	}
	
	@PostMapping("/tickets")
	public Ticket saveTicket(@RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	@PutMapping("/tickets/{id}")
	public Ticket updateTicket(@PathVariable(name = "id") Long id, @RequestBody Ticket ticket) {
		ticket.setId(id);
		return ticketRepository.save(ticket);
	}
	
	@DeleteMapping("/tickets/{id}")
	public void deleteTicket(@PathVariable(name = "id") Long id) {
		ticketRepository.deleteById(id);
	}

}
