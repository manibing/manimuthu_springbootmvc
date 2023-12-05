package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Ticket;

import com.gl.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketRepository dao;
	@Override
	public  List<Ticket> getAllTicket(){
		return (List<Ticket>)dao.findAll();
	}

	@Override
	public Ticket addTicket(Ticket ticket) {
		
		return dao.save(ticket);
	}


	@Override
	public Ticket getTicketById(long id) {
		// TODO Auto-generated method stub
		Optional<Ticket> ticket=dao.findById( id);
		if(ticket.isPresent()) {
			return ticket.get();
		}else {
			return null;
		}
	}

	@Override
	public String deleteTicketById(long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		return "deleted";
	}

	@Override
	public Ticket updateTicketById(Ticket newTicket, long id) {
		// TODO Auto-generated method stub
		Ticket ticket1=getTicketById(id);
		if(ticket1!=null) {
			ticket1=newTicket;
			dao.save(ticket1);
			return ticket1;
		}else {
		
		return null;
		}
	}

	@Override
	public List<Ticket> getAllTicketDetailsBySearch(String keyword) {
		if (keyword != null) {
			return dao.search(keyword);
		}
		return dao.findAll();
	}

	@Override
	public Ticket get(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}






}
