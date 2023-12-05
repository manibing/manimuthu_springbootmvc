package com.gl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.entity.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	@Query("SELECT p FROM Ticket  p WHERE CONCAT(p.id,p.ticketTitle, p.ticketShortDescription) LIKE %?1%")
	public List<Ticket> search(String keyword);
	//this is the search query operation

}
