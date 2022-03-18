package com.scrappers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IMDBScrapper implements Workable {

	private String img;
	private String title;
	private String year;
	private String rate;
	private ArrayList<String> movieItem = new ArrayList<String>();
	public ArrayList<Movie> movieList = new ArrayList<Movie>();
	Document doc;
	Elements body;

	public IMDBScrapper() {
		try {
			doc = Jsoup.connect("https://www.imdb.com/chart/top").timeout(6000).get();
			body = doc.select("tbody.lister-list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getImg() {
		for (Element e : body.select("tr"))
			movieItem.add(e.select("td.posterColumn img").attr("src"));

		return img;
	}

	private String getTitle() {
		for (Element e : body.select("tr"))
			movieItem.add(e.select("td.posterColumn img").attr("alt"));

		return title;
	}

	private String getYear() {
		for (Element e : body.select("tr"))
			movieItem.add(e.select("td.titleColumn span.secondaryInfo").text().replaceAll("[^\\d]", ""));

		return year;
	}

	private String getRate() {
		for (Element e : body.select("tr"))
			movieItem.add(e.select("td.ratingColumn.imdbRating").text().trim());

		return rate;
	}

	public final ArrayList<String> showItem(String item) {
		switch (item) {
		case "img":
			movieItem.add(getImg());
			break;
		case "title":
			movieItem.add(getTitle());
			break;
		case "year":
			movieItem.add(getYear());
			break;
		case "rate":
			movieItem.add(getRate());
			break;
		default:
			System.out.println("No such Item");
		}
		return movieItem;
	}

	public void createMovieList() throws IOException {
		System.out.println("Creating list please wait...");
		for (Element e : body.select("tr")) {
			String img = e.select("td.posterColumn img").attr("src");
			String title = e.select("td.posterColumn img").attr("alt");
			String year = e.select("td.titleColumn span.secondaryInfo").text().replaceAll("[^\\d]", "");
			String rate = e.select("td.ratingColumn.imdbRating").text().trim();

			movieList.add(new Movie(img, title, year, rate));
		}
		System.out.println();
		System.out.println("List is ready");
	}

	public void runTest() throws IOException {
		System.out.println("****************** IMDB TOP Charts ******************");
		for (Element e : body.select("tr")) {
			System.out.println();
			System.out.println();
			String img = e.select("td.posterColumn img").attr("src");
			System.out.println("Image Link : " + img);

			String title = e.select("td.posterColumn img").attr("alt");
			System.out.println("Name : " + title);

			String year = e.select("td.titleColumn span.secondaryInfo").text().replaceAll("[^\\d]", "");
			System.out.println("Year : " + year);

			String rate = e.select("td.ratingColumn.imdbRating").text().trim();
			System.out.println("Rate : " + rate);
		}
		System.out.println();
		System.out.println("****************** END Of Scrapping ********************");
	}

	

}
