package edu.ait.winemanager;

import edu.ait.winemanager.dao.WineDAO;

public class WineDAOTest {

	public static void main(String[] args) {

		WineDAO wineDAO = new WineDAO();
		System.out.println("all Wines " + wineDAO.findAll());
		System.out.println("");
		System.out.println("all Wines " + wineDAO.findbyId(5));

	}

}
