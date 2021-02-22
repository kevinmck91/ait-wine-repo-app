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
import edu.ait.winemanager.exceptions.WineNotFoundException;
import edu.ait.winemanager.repositories.WineRepository;

@RestController
public class WineController {

	@Autowired
	WineRepository wineRepository;

	@GetMapping("wines")
	public List<Wine> getAllWines() {
		
		return wineRepository.findAll();
		
	}

	@GetMapping("wines/{id}")
	public Wine getWineById(@PathVariable int id) {

		Optional<Wine> foundWine = wineRepository.findById(id);
		
		if(foundWine.isPresent())
			return foundWine.get();
		else
			throw new WineNotFoundException("Unable to find wine: " + id);

	}
	
	@DeleteMapping("wines/{id}")
	public void deleteWineById(@PathVariable int id) {
		
		try {
			wineRepository.deleteById(id);
		} catch (Exception e) {
			throw new WineNotFoundException("Wine " + id + " does not exist");
		}
		
	}
	
	@PostMapping("wines/")
	public ResponseEntity createWine(@RequestBody Wine newWine) {

		Wine savedWine = wineRepository.save(newWine);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newWine.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("wines/")
	public ResponseEntity updateWine(@RequestBody Wine newWine) {

		if(newWine.getId() != null) 
		{
			wineRepository.save(newWine);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else 
		{
			Wine savedWine = wineRepository.save(newWine);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newWine.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
		
	}

}
