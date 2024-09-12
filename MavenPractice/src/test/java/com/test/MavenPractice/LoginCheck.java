package com.test.MavenPractice;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginCheck {

	WebDriver driver;
	ChromeOptions chromeOptions = new ChromeOptions();

	@BeforeClass
	public void LoginPage() {

		chromeOptions.addArguments("--disable-search-engine-choice-screen");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://master--alliance_medical_test.plus.kamal.mynuasolution.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

	}

	@Test
	public void Loginsuccess() {
		driver.findElement(By.id("user_email")).sendKeys("alliance_medical+superadmin@webdoctor.ie");
		driver.findElement(By.id("user_password")).sendKeys("Password1!");
		driver.findElement(By.name("commit")).click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void LoginFailure() {
		driver.findElement(By.id("user_email")).sendKeys("alliance_medical+superadmin@webdoctor.ie");
		driver.findElement(By.id("user_password")).sendKeys("Password1");
		driver.findElement(By.name("commit")).click();
		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void CleanUp() {
		driver.quit();
	}
}
