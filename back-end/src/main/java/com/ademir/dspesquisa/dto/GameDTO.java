package com.ademir.dspesquisa.dto;

import java.io.Serializable;

import com.ademir.dspesquisa.entities.Game;
import com.ademir.dspesquisa.entities.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class GameDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private Platform platform;
	
	public GameDTO(Game game) {
		id = game.getId();
		title = game.getTitle();
		platform = game.getPlatform();
	}
}
