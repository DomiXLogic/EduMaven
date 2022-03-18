package com.scrappers;

public class Movie {

	private String img;
	private String title;
	private String year;
	private String rate;
	
	public Movie() {}

	public Movie(String img, String title, String year, String rate) {
		super();
		this.img = img;
		this.title = title;
		this.year = year;
		this.rate = rate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
	
}
