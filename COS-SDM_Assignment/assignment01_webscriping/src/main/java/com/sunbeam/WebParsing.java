package com.sunbeam;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebParsing {
	static void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {		
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("/snap/firefox/current/usr/lib/firefox/firefox");
		
		String url = "https://nilesh-g.github.io/learn-web/HTML/demo14.html";
		WebDriver driver = new FirefoxDriver(options);
		driver.get(url);
		delay(2000);
		
		String title = driver.getTitle();
		System.out.println("Title is: "+ title);
		
		WebElement h1 = driver.findElement(By.tagName("h1"));
		System.out.println("H1 is: "+ h1.getText());
		
		List<WebElement> tableTitle = driver.findElements(By.xpath("/html/body/table/thead/tr/th"));
		for (WebElement webElement : tableTitle) {
			System.out.println("Th: "+webElement.getText());
		}
		
		List<WebElement> tableRow = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		for (WebElement webElement : tableRow) {
			System.out.println("Table Data: "+webElement.getText());
		}
	}
}
