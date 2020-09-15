package com.ademir.dspesquisa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
