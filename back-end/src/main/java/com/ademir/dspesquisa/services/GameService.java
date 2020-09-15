package com.ademir.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ademir.dspesquisa.dto.GameDTO;
import com.ademir.dspesquisa.entities.Game;
import com.ademir.dspesquisa.repositories.GameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {
	
	private final GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){
		List<Game> list = gameRepository.findAll();
		
		return list.stream().map( x -> new GameDTO(x)).collect(Collectors.toList());
	}
}
