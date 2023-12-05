package com.gl.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 long id;
 String ticketTitle;
 String ticketShortDescription;
 String content;
LocalDate ticketCreatedOn; 
//String actions;
	 
}
