package com.downloader;

import java.io.File;

public class Main {

	public static void main(String[] args) {
	
		String link = "https://kkatsaras.gr/WPS/wp-content/uploads/2021/11/Katsaras_Kyriakos_S-1.pdf";
			
		String currentPath = System.getProperty("user.dir");
		File out = new File(currentPath+ "\\CV_KAtsaras.pdf");
	
		new Thread(new Downloader(link, out)).start();;
	}

}
