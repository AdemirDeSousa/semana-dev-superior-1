package com.ademir.dspesquisa.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ademir.dspesquisa.dto.GameDTO;
import com.ademir.dspesquisa.dto.RecordDTO;
import com.ademir.dspesquisa.dto.RecordInsertDTO;
import com.ademir.dspesquisa.services.RecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/records")
@RequiredArgsConstructor
public class RecordResource {
	
	private final RecordService recordService;
	
	@PostMapping
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){
		RecordDTO newDTO = recordService.insert(dto);
		
		return ResponseEntity.ok().body(newDTO);
	}	
	
	@GetMapping
	public ResponseEntity<Page<RecordDTO>> findAll(
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max, 
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction
			){
		Instant min_date = ("".equals(min)) ? null : Instant.parse(min);
		Instant max_date = ("".equals(max)) ? null : Instant.parse(max);
		
		if(linesPerPage == 0) {
			linesPerPage = Integer.MAX_VALUE;
		}
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<RecordDTO> list = recordService.findByMoments(min_date, max_date, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
}
