package com.ademir.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.dspesquisa.entities.Game;

public interface GemeRepository extends JpaRepository<Game, Long>{

}
