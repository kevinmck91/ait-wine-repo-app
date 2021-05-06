package edu.ait.winemanager.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity 
public class Wine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//TODO: figure out what this does
	private Integer id;
	private Double 	price;
	private int 	stock;
	private String 	name;
	private int		year;
	private String 	grapes;
	private String 	country;
	private String 	region;
	@Lob
	private String 	description;
	private String 	picture;
	
	

	public Wine() {
	}

	public Wine(int id, double price, int stock, String name, int year, String grapes, String country, String region, String description, String picture) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.grapes = grapes;
		this.country = country;
		this.region = region;
		this.description = description;
		this.picture = picture;
		this.price = price;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGrapes() {
		return grapes;
	}

	public void setGrapes(String grapes) {
		this.grapes = grapes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", name=" + name + ", year=" + year + ", grapes=" + grapes + ", country=" + country
				+ ", region=" + region + ", description=" + description + ", picture=" + picture + "]";
	}

}
