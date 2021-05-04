package edu.ait.winemanager.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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

		Wine testWine_0 = new Wine(123, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description",
				"Test Region", "Test description", 10.50, 4);
		Wine testWine_1 = new Wine(123, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description",
				"Test Region", "Test description", 10.50, 4);
		Wine testWine_2 = new Wine(123, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description",
				"Test Region", "Test description", 10.50, 4);
		Wine testWine_3 = new Wine(123, "Test Name", 1990, "Test Grapes", "Test Country", "Test Description",
				"Test Region", "Test description", 10.50, 4);

		wineList.add(testWine_0);
		wineList.add(testWine_1);
		wineList.add(testWine_2);
		wineList.add(testWine_3);

	}

	@Test
	void calculatePostageTest() {

		// Boundary values for postage
		assertEquals(wineUtils.calculatePostage(wineList.get(0)), 3.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(1)), 3.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(2)), 3.99);
		assertEquals(wineUtils.calculatePostage(wineList.get(3)), 3.99);

	}

	@Test
	void countAllWinesTest() {

		assertEquals(wineUtils.countAllWines(wineList), 4);

	}

}
