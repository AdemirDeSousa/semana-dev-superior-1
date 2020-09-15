package com.ademir.dspesquisa.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class RecordInsertDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private Long game_id;
}
