package org.testng.code;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demooftestng {
@Test(priority = 1)
public void mytestcase() {
Assert.assertEquals("ABCD", "ABCD");//hard assertion
System.out.println("This is my first test case");

}
@Test(priority = 2,dependsOnMethods = "mytestcase")
public void mysecondtestcase() {
	SoftAssert s = new SoftAssert();
	s.assertEquals("12345", "56789");
	System.out.println("This is my second test case");
	s.assertAll(); //this is mandatory for test case to decide PASS/FAIL
}
@BeforeTest
public void precondition() {
	System.out.println("This is from beforetest");
}
@AfterTest
public void postcondition() {
	System.out.println("This is from aftertest");
}
@BeforeClass
public void beforeclass() {
	System.out.println("This is from beforeclass");
}
@AfterClass
public void afterclass() {
	System.out.println("This is from afterclass");
}
@BeforeSuite
public void beforesuite() {
	System.out.println("This is from beforesuite");
}
@AfterSuite
public void aftersuite() {
	System.out.println("This is from aftersuite");
}
@BeforeMethod
public void beforemethod() {
	System.out.println("This is from beforemethod");
}
@AfterMethod
public void aftermethod() {
	System.out.println("This is from aftermethod");
}
}
