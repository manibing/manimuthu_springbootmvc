package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Ticket;

import com.gl.repository.TicketRepository;

@Service
public interface TicketService {
	
public Ticket addTicket(Ticket ticket);


public List<Ticket> getAllTicket();

public Ticket getTicketById(long id);

public String deleteTicketById(long id);

public Ticket updateTicketById(Ticket ticket, long id);

public List<Ticket> getAllTicketDetailsBySearch(String keyword);

public Ticket get(long id);



}
