package com.ademir.dspesquisa.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ademir.dspesquisa.dto.GameDTO;
import com.ademir.dspesquisa.services.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
public class GameResource {
	
	private final GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameDTO>> findAll(){
		List<GameDTO> list = gameService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
