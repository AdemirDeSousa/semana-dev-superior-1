package com.ademir.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ademir.dspesquisa.entities.enums.Platform;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_game")
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Platform platform;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@OneToMany(mappedBy = "game")
	private List<Record> records = new ArrayList<>();

	public Game(Long id, String title, Platform platform, Genre genre) {
		super();
		this.id = id;
		this.title = title;
		this.platform = platform;
		this.genre = genre;
	}
	
	
}
