package edu.ait.winemanager.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.ait.winemanager.dao.WineDAO;
import edu.ait.winemanager.dto.Wine;

@RestController
public class WineController {

	@Autowired
	WineDAO wineDAO;

	@GetMapping("wines")
	public List<Wine> getAllWines() {

		return wineDAO.findAll();

	}

	@GetMapping("wines/{id}")
	public Optional<Wine> getWineById(@PathVariable int id) {

		return wineDAO.findbyId(id);

	}
	
	@DeleteMapping("wines/{id}")
	public void deleteWineById(@PathVariable int id) {

		wineDAO.deleteWine(id);

	}
	
	@PostMapping("wines/")
	public ResponseEntity createWine(@RequestBody Wine wine) {

		wineDAO.createWine(wine);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(wine.getId()).toUri();
		
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("wines/")
	public ResponseEntity updateWine(@RequestBody Wine wine) {

		boolean updated =  wineDAO.updateWine(wine);
		
		if(updated == true) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else{
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(wine.getId()).toUri();
			return ResponseEntity.created(location).build();
		}

	}
	
	@GetMapping("wines/check/{id}")
	public String checkIfSufficientStock(@PathVariable int id) {
		
		return wineDAO.checkIfSufficientStock(id);
		
	}
	
	
	@GetMapping("wines/count/")
	public int countAllWines() {
		
		return wineDAO.countAllWines();
		
	}

	
}
