package com.scrappers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Viewer  {
	
	private String movieName;
	
	public Viewer() {}
	
	public Viewer(String movieName) {
		super();
		this.movieName = movieName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void findInYouTube(String movieName) {
		String url = "https://www.youtube.com/results?search_query=" + movieName;
		openBrowser(url);
	}

	public void findInIMDB(String movieName) {
		String url = "https://www.imdb.com/find?q=" + movieName + "&ref_=nv_sr_sm";
		openBrowser(url);
	}

	public void findInGoogle(String movieName) {
		String url = "https://www.google.gr/search?q=" + movieName;
		openBrowser(url);
	}
	
	public void findInYouTube() {
		String url = "https://www.youtube.com/results?search_query=" + movieName;
		openBrowser(url);
	}

	public void findInIMDB() {
		String url = "https://www.imdb.com/find?q=" + movieName + "&ref_=nv_sr_sm";
		openBrowser(url);
	}

	public void findInGoogle() {
		String url = "https://www.google.gr/search?q=" + movieName;   // https://www.google.gr/search?q=
		openBrowser(url);
	}

	private void openBrowser(String url) {
		String myOS = System.getProperty("os.name").toLowerCase();
		try {
			if (Desktop.isDesktopSupported()) { // Windows
				Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI(url));
			} else { // Non-windows
				Runtime runtime = Runtime.getRuntime();
				if (myOS.contains("mac")) { // Apples
					runtime.exec("open " + url);
				} else if (myOS.contains("nix") || myOS.contains("nux")) { // Linux
					runtime.exec("xdg-open " + url);
				} else
					System.out.println("Unable to launch a browser in your OS :( ");
			}
		} catch (IOException | URISyntaxException e) {
			System.out.println("**Stuff wrongly: " + e.getMessage());
		}
	}

}
