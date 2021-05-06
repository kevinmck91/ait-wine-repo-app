package edu.ait.winemanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.ait.winemanager.dto.Wine;
import edu.ait.winemanager.repositories.WineRepository;
import edu.ait.winemanager.utilities.WineUtils;

@RestController
public class WineController {

	@Autowired
	WineRepository wineRepository;
	
	@Autowired
	WineUtils wineUtils;

	
	@GetMapping("wines")
	public List<Wine> getAllWines() {

		return wineRepository.findAll();

	}

	@GetMapping("wines/{id}")
	public Wine getWineById(@PathVariable int id) {

		Optional<Wine> foundWine = wineRepository.findById(id);

		return foundWine.get();
		
	}
	

	@GetMapping("wines/count/")
	public double getWineCount() {

		List<Wine> wineList = getAllWines();

		double result = wineUtils.countAllWines(wineList);

		return result;

	}
	
	@GetMapping("price/{id}")
	public double getWineTotalPrice(@PathVariable int id) {

		Optional<Wine> foundWine = wineRepository.findById(id);

		double postage = wineUtils.calculatePostage(foundWine.get());
		
		return foundWine.get().getPrice() + postage;

	}

}
