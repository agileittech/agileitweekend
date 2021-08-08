package org.phptravel.usingtestng;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signuppage {
	FirefoxDriver f;
@Test(priority = 1)
public void openurl() {
	f.get("https://www.phptravels.net/register");
	System.out.println("URL Open Successful");
	String Actualresult = f.getTitle();
	String Expectedresult = "Register";
	Assert.assertEquals(Actualresult, Expectedresult);
	}
@BeforeTest
public void precondition() {
	String location = System.getProperty("user.dir");
	System.out.println(location);
	System.setProperty("webdriver.gecko.driver",location+"\\src\\test\\resources\\org\\phptravel\\utilities\\geckodriver.exe");
    f = new FirefoxDriver();
}
@Test(priority = 2)
public void fill_signup_page() throws IOException, SQLException {
WebElement firstname = f.findElement(By.name("firstname"));
WebElement Lastname = f.findElement(By.name("lastname"));	
WebElement Mobilenumber = f.findElement(By.name("phone"));	
WebElement Email = f.findElement(By.name("email"));	
WebElement Password= f.findElement(By.name("password"));	
WebElement ConfirmPassword = f.findElement(By.name("confirmpassword"));	
WebElement signupbutton = f.findElement(By.cssSelector(".signupbtn"));
ReadingExcel r = new ReadingExcel();
MysqlDemo sd = new MysqlDemo();
sd.connecttodatabase();
String fname = r.readdatafromrow(1, 1);
String lname = r.readdatafromrow(2, 1);
String mnumber = r.readdatafromrow(3, 1);
String email = r.readdatafromrow(4, 1);
String pswrd = sd.sendstatement();
firstname.sendKeys(fname);
Lastname.sendKeys(lname);
Mobilenumber.sendKeys(mnumber);
Email.sendKeys(email);
Password.sendKeys(pswrd);
ConfirmPassword.sendKeys(pswrd);
JavascriptExecutor js = (JavascriptExecutor)f;
js.executeScript("window.scrollBy(0,100)", "");
signupbutton.click();
String actual = f.getTitle();
Assert.assertEquals(actual, "My Account");
}
}
