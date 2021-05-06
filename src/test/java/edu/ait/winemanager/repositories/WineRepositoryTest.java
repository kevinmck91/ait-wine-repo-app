package edu.ait.winemanager.repositories;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class WineRepositoryTest {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private WineRepository wineRepository;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void injectedComponentsAreNotNull() {
	/*
		assertNotNull(entityManager);
		assertNotNull(wineRepository);
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
	*/
	}

}
