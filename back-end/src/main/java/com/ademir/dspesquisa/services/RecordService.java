package com.ademir.dspesquisa.services;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ademir.dspesquisa.dto.RecordDTO;
import com.ademir.dspesquisa.dto.RecordInsertDTO;
import com.ademir.dspesquisa.entities.Game;
import com.ademir.dspesquisa.entities.Record;
import com.ademir.dspesquisa.repositories.GameRepository;
import com.ademir.dspesquisa.repositories.RecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecordService {
	
	private final RecordRepository recordRepository;
	private final GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record record = new Record();
		record.setName(dto.getName());
		record.setAge(dto.getAge());
		record.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(dto.getGame_id());
		record.setGame(game);
		
		record = recordRepository.save(record);
		return new RecordDTO(record);
	}
}
