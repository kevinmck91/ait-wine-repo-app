package edu.ait.winemanager.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import edu.ait.winemanager.dao.WineDAO;
import edu.ait.winemanager.dto.Wine;

@SpringBootTest
public class WineControllerTest {

	
	@Autowired
	WineDAO wineDAO;
	
	@Test
	public void checkIfSufficientStockTest() {

		assertEquals("Insufficient stock of wine : 3", wineDAO.checkIfSufficientStock(3));
		assertEquals("Insufficient stock of wine : 7", wineDAO.checkIfSufficientStock(7));
		assertEquals("Sufficient stock of wine : 11", wineDAO.checkIfSufficientStock(11));
		
		assertNotEquals("Sufficient stock of wine : 5", wineDAO.checkIfSufficientStock(5));
		assertNotEquals("Sufficient stock of wine : 6", wineDAO.checkIfSufficientStock(6));
		assertNotEquals("Inufficient stock of wine : 11", wineDAO.checkIfSufficientStock(11));
		
	}
	
}
