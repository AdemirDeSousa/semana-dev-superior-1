package com.ademir.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.dspesquisa.entities.Record;

public interface RecordRepository extends JpaRepository<Record, Long>{

}
