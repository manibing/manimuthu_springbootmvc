package com.gl.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.entity.Ticket;
import com.gl.service.TicketServiceImpl;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketServiceImpl service;

	/*
	 * @Autowired TicketRepository dao;
	 */
	@RequestMapping("/")
	public String homePage() {
		return"ticketlist";
	}
	@RequestMapping("/newTicket")
	public String ticketForm(Model m) {
		// LocalDate date= LocalDate.now();
		m.addAttribute("message","Create Ticket");
	        m.addAttribute("ticket",new Ticket());
	        m.addAttribute("button","submit");
	       
		return "ticketform";
	}
	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket,Model m) {
		
		  LocalDate date = LocalDate.now();
	        m.addAttribute("localdate",date);
	        ticket.setTicketCreatedOn(date);
	        service.addTicket(ticket);
		return "redirect:/tickets/getall";
	} 

	@RequestMapping("/edit")
	public String updateTickets(@RequestParam("id") int tid,Model m) {
		Ticket ticket=service.getTicketById(tid);
		
		m.addAttribute("ticket",ticket);
		m.addAttribute("message","Edit Ticket");
		m.addAttribute("button","Submit");
		
		return "ticketform";
	}
	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("id")Integer tid) {
		
		service.deleteTicketById(tid);
		
		return"redirect:/tickets/getall";
		
	}
	@GetMapping("/getall")
	public String showAllTickets(Model m) { 

		//m.addAttribute("ticket",new Ticket()); 
		List<Ticket> tickets=service.getAllTicket();

		m.addAttribute("tickets",tickets); 

		return "ticketlist"; 

		} 
	@GetMapping("/getbyid")
	public String getTicketsById(@RequestParam("id") int id,Model m) {
		Ticket ticket=service.getTicketById(id);
		m.addAttribute("ticket",ticket);
		m.addAttribute("readonly",true);
		m.addAttribute("message","View Ticket");
		m.addAttribute("button","Back to lists");

		return"viewingform";
		
	}
	@RequestMapping("/search")
	public String search(Model model, @Param("query") String query) {
		System.out.println("search keyword: " + query);
		model.addAttribute("tickets", service.getAllTicketDetailsBySearch(query));
		return "ticketlist";
	}
	
}
