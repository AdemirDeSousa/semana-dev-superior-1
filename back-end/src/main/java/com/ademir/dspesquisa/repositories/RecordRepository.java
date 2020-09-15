package com.ademir.dspesquisa.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ademir.dspesquisa.dto.RecordDTO;
import com.ademir.dspesquisa.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{
	
	@Query("SELECT obj FROM Record obj WHERE "
			+ "(coalesce(:min_date, null) IS NULL OR obj.moment >= :min_date) AND "
			+ "(coalesce(:max_date, null) IS NULL OR obj.moment	<= :max_date)")
	Page<Record> findByMoments(Instant min_date, Instant max_date, Pageable pageable);

}
