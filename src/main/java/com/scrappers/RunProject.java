package com.scrappers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/*
 * In order this Project to play 
 * correctly, you need to create 
 * a database with one table named 
 * 'movies'. The needed fields are
 * img, title, year, rate, user and
 * the id set it up to Auto Increase.  
 */
public class RunProject implements Viewable {
   static final String DB_URL = "YOUR DATABASE LINK HERE";
   static final String USER = "USERNAME HERE";
   static final String PASS = "PASSWORD HERE";
   
   Viewer view  = new Viewer();
   
   public static void main(String[] args) throws ClassNotFoundException  {

	   RunProject run = new RunProject();

	   //	   IMDBScrapper scrapper = new IMDBScrapper();	
//	  	 	  
//	       try
//	        {
//	     	  scrapper.createMovieList();
//	     	  Class.forName("com.mysql.jdbc.Driver");  
//	     	  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//	     	  PreparedStatement myStmt = null; 
//	           String sql = "insert into movies (img, title, year, rate, user) values (?,?,?,?,?)";
//	           myStmt = conn.prepareStatement(sql);
//	           for(Movie s : scrapper.movieList) {
//	         	  myStmt.setString(1, s.getImg()); 
//	         	  myStmt.setString(2, s.getTitle()); 
//	         	  myStmt.setString(3, s.getYear()); 
//	         	  myStmt.setString(4, s.getRate()); 
//	         	  myStmt.setString(5, "Kyriakos"); 
//	             myStmt.executeUpdate();
//	           } 
//	           conn.close();
//	        } catch (SQLException | IOException e) {
//	          e.printStackTrace();
//	       } finally {
//	    	   
//	    	   System.out.println("The insertion has been executed successfully ");
//	      }
//	    
      
	   run.viewOnlineTrailer("aladin");
   }

   public void viewOnlineTrailer(String movieName) {
		System.out.print("Select provider :\n"
				+ "1. Youtube\n"
				+ "2. IMDB\n"
				+ "3. Google\n>>>");
		Scanner in = new Scanner(System.in);
		String provider = in.next();
		
		switch(provider) {
		case "1":
			view.findInYouTube(movieName);
			break;
		case "2":
			view.findInIMDB(movieName);
			break;
		case "3":
			view.findInGoogle(movieName);
			break;	
		default :
			System.out.println("There is no such option");
			
		in.close();
		}
	}

@Override
public void viewOnlineTrailer() {}


}