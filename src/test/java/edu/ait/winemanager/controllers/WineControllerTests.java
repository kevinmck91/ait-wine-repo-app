package edu.ait.winemanager.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import edu.ait.winemanager.dto.Wine;
import edu.ait.winemanager.repositories.WineRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class WineControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WineRepository wineRepository;

	@Test
	public void getWinesTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/wines").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
	}

	@Test
	public void getWineByIdTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/wines/3").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").isString());
	}

	@Test
	public void getWineCountTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/wines/count/").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNumber());
		mvc.perform(MockMvcRequestBuilders.get("/wines/count/").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").value(67.0));
	}

	@Test
	public void getWineTotalPriceTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/price/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNumber());
		mvc.perform(MockMvcRequestBuilders.get("/price/6").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNumber());
		mvc.perform(MockMvcRequestBuilders.get("/price/9").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNumber());
	}

}
