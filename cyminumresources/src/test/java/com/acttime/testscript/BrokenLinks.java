package com.acttime.testscript;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
public static void main(String[] args) throws Throwable {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	
	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	ArrayList<String> brokenLinks=new ArrayList<String>();
	
	for(int i=0;i<allLinks.size();i++)
	{
		int statuscode=0;
		String links = allLinks.get(i).getAttribute("href");
		try {
		URL url=new URL(links);
		
		  URLConnection con = url.openConnection();
		  
		  HttpURLConnection httpurlconnection=(HttpURLConnection) con;
		 statuscode= httpurlconnection.getResponseCode();
		 
		 if(statuscode>=400)
		 {
			 brokenLinks.add(links+" "+statuscode);
		 }
		}
		catch(Exception e)
		 {
			 brokenLinks.add(links+" "+statuscode);
			 continue;
		 }
	}
	
	for(String i:brokenLinks)
	{
		System.out.println(i);
	}
	
}

}
