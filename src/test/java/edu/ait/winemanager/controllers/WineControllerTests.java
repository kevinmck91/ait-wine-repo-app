package edu.ait.winemanager.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WineControllerTests {

	@Test
	public void addIntsTest() throws Exception {
		
		WineController wc = new WineController();

		assertEquals(wc.addInts(3,4), 7);
		assertEquals(wc.addInts(6,8), 14);
	}

}
