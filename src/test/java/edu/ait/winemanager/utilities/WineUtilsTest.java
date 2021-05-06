package edu.ait.winemanager.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ait.winemanager.controllers.WineController;
import edu.ait.winemanager.dto.Wine;

@SpringBootTest
public class WineUtilsTest {
	
	WineUtils wineUtils;
	List<Wine> wineList;
	
	@BeforeEach
	public void setUp() throws Exception {

		wineUtils = new WineUtils();
		wineList = new ArrayList();
		
		Wine testWine_0 = new Wine(123, 8.99, 1, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_1 = new Wine(124, 9.00, 2, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_2 = new Wine(125, 9.01, 3, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_3 = new Wine(126, 9.99, 4, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_4 = new Wine(127, 10.00, 5, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_5 = new Wine(128, 10.01, 6, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_6 = new Wine(129, 11.99, 7, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_7 = new Wine(130, 12.00, 8, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_8 = new Wine(131, 12.01, 9, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_9 = new Wine(132, 12.99, 10, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_10 = new Wine(133, 13.00, 11, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		Wine testWine_11 = new Wine(134, 13.01, 12, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description", "Test Region", "Test description");
		
		
		wineList.add(testWine_0);
		wineList.add(testWine_1);
		wineList.add(testWine_2);
		wineList.add(testWine_3);
		wineList.add(testWine_4);
		wineList.add(testWine_5);
		wineList.add(testWine_6);
		wineList.add(testWine_7);
		wineList.add(testWine_8);
		wineList.add(testWine_9);
		wineList.add(testWine_10);
		wineList.add(testWine_11);
		
	}
	
	
	@Test
	void calculatePostageTest() {
		
		// Boundary values for postage 
		assertEquals(wineUtils.calculatePostage(wineList.get(0)), 0);
		assertEquals(wineUtils.calculatePostage(wineList.get(1)), 2.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(2)), 2.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(3)), 2.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(4)), 3.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(5)), 3.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(6)), 3.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(7)), 4.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(8)), 4.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(9)), 4.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(10)), 6.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(11)), 6.99);
		
	}
	
	@Test
	void countAllWinesTest() {
		
		assertEquals(wineUtils.countAllWines(wineList), 78);
	
	}


}
