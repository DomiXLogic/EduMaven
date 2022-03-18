package com.crawlers;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawler {
	
	public static void main(String[] args) {
		String url = "Https://www.devsclub.gr";
		crawl(3, url, new ArrayList<String>());
		
	}
	
	private static void crawl(int level, String url, ArrayList<String> visited) {
		if(level <=5) {
			Document doc = request(url, visited);
			
			if(doc != null) {
				for(Element link : doc.select("a[href]")) {
					String nextLink = link.absUrl("href");
					if(visited.contains(nextLink) == false) {
						crawl(level++, nextLink, visited);
					}
				}
			}
		}
	}
	
	private static Document request(String url, ArrayList<String> v) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			
			if(con.response().statusCode() == 404) {
				System.out.println("I got 404 Error on link : " + url);
			}else if(con.response().statusCode() == 200) {
				System.out.println("Link : " + url);
				System.out.println(doc.title());
				v.add(url);
			    
				return doc;
			}
			return null;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

}
