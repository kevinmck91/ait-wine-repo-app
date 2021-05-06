package edu.ait.winemanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ait.winemanager.dto.Wine;

public interface WineRepository extends JpaRepository<Wine, Integer>{

	// List<Wine> findByFoo();
	
}
