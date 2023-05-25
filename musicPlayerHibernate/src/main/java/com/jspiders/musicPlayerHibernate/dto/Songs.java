package com.jspiders.musicPlayerHibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
//@Table(name = "music_player")
public class Songs {
	
	@Id
	private int id;
	private String name;
	private String singer_name;
	private String movie_album;
	private double duration;

}
