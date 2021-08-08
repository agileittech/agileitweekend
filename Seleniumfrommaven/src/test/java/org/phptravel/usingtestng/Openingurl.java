package org.phptravel.usingtestng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Openingurl {
	 WebDriver f;

@Test(priority = 1)
public void openurl() {
f.get("https://www.phptravels.net/home");
System.out.println("URL Open Successful");
String Actualresult = f.getTitle();
String Expectedresult = "PHPTRAVELS | Travel Technology Partner";
Assert.assertEquals(Actualresult, Expectedresult);
}
@Parameters("browser")
@BeforeTest
public void preconditions(String browser) {
	if(browser.equals("firefox")) {
	System.setProperty("webdriver.gecko.driver","C:\\WeekEndBatch\\Seleniumfrommaven\\src\\test\\resources\\org\\phptravel\\utilities\\geckodriver.exe");
    f = new FirefoxDriver();	
	}else if (browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\WeekEndBatch\\Seleniumfrommaven\\src\\test\\resources\\org\\phptravel\\utilities\\chromedriver.exe");	
	 f = new ChromeDriver();
	}
       
}
@Test(priority = 2)
public void clicksignup() {
	List<WebElement> list = f.findElements(By.id("dropdownCurrency"));
	list.get(1).click();
	System.out.println("Click on My Account Successful");
	f.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[2]")).click();
    String actual = f.getTitle();
	//Assert.assertEquals(actual, "Register");
	System.out.println("Click on Signup page successful");
}
}
