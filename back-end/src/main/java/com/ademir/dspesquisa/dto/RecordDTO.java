package com.ademir.dspesquisa.dto;

import java.io.Serializable;
import java.time.Instant;

import com.ademir.dspesquisa.entities.Record;
import com.ademir.dspesquisa.entities.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RecordDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant moment;
	private String name;
	private Integer age;
	private String game_title;
	private Platform game_platform;
	private String genre_name;
	
	public RecordDTO(Record record) {
		id = record.getId();
		moment = record.getMoment();
		name = record.getName();
		age = record.getAge();
		game_title = record.getGame().getTitle();
		game_platform = record.getGame().getPlatform();
		genre_name = record.getGame().getGenre().getName();
	}
}
