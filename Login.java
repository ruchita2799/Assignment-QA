package OraHRM_Assign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class Login {
	
	WebDriver d;
	
	@BeforeTest // driver setup
	public void setup() {

		String baseUrl = "https://opensource-demo.orangehrmlive.com/";
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		d = new FirefoxDriver();
		d.get(baseUrl);
		d.manage().window().maximize();
	}
	
	@Test// code for parameters taking from xml file
	@Parameters( {"username","password"})
	public void start(String username, String password) throws InterruptedException {
		d.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		WebElement usernameField = d.findElement(By.id("txtUsername"));
		WebElement passwordField = d.findElement(By.id("txtPassword"));
		WebElement submit = d.findElement(By.name("Submit"));
		
		usernameField.sendKeys(username);
		System.out.println("Your Username is "+username +" and Parameter is passed from Xml file");
		passwordField.sendKeys(password);
		System.out.println("Your Password is "+password+" and Parameter is passed from Xml file");
		submit.click();
		
		System.out.println("The Title of title Page is "+d.getTitle());
		System.out.println("The current url is"+d.getCurrentUrl());
//		d.findElement(By.id("txtUsername")).sendKeys("Admin");
//		d.findElement(By.id("txtPassword")).sendKeys("admin123");
//		d.findElement(By.id("btnLogin")).click();
		
		System.out.println("The current url after login is "+d.getCurrentUrl());
		d.findElement(By.id("menu_admin_viewAdminModule")).click();
		d.findElement(By.partialLinkText("Admin")).click();
		System.out.println("The current url for admin page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
//		d.navigate().back();
		
		d.findElement(By.partialLinkText("PIM")).click();
		System.out.println("The current url for PIM page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.id("menu_leave_viewLeaveModule")).click();
		System.out.println("The current url for Leave page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.xpath("//a[@href='/index.php/time/viewTimeModule']")).click();
		System.out.println("The current url for Time page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.xpath("//a[@href='/index.php/recruitment/viewRecruitmentModule']")).click();
		System.out.println("The current url for Recruitment page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		

		d.findElement(By.xpath("//a[@href='/index.php/pim/viewMyDetails']")).click();
		System.out.println("The current url for View my details page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.linkText("Performance")).click();
		System.out.println("The current url for Performance page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.linkText("Dashboard")).click();
		System.out.println("The current url for Dashboard page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.linkText("Directory")).click();
		System.out.println("The current url for admin Directory is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.xpath("//a[@href='/index.php/maintenance/purgeEmployee']")).click();
		System.out.println("The current url for Maintainance page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		d.findElement(By.xpath("//a[@href='/index.php/buzz/viewBuzz']")).click();
		System.out.println("The current url for Buzz page is "+d.getCurrentUrl());
//		Thread.sleep(2000);
		
		
		d.findElement(By.xpath("//a[@id='welcome']")).click();
		Thread.sleep(2000);

		d.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();

		Thread.sleep(2000);
		
		
		//Assertion code
		String expected=d.getCurrentUrl();
		String actualURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(expected, actualURL);
		
		if(d.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
		System.out.println("The Credentials are Valid !!!!!");
		d.findElement(By.xpath("//a[@id='welcome']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();
        Thread.sleep(2000);
		}
		else {
		System.out.println("Invaid Credentials!!!");
//		d.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		}  
		
		// code for finding entire links in webpage
		List <WebElement>link= d.findElements(By.tagName("a"));
		System.out.println("The Number of Links in this Application is"+link.size());
		
		Thread.sleep(2000);
		
		
		
	}
	@AfterTest
	public void closing() {
		d.close();
	}
	

//		
		
	}
	
	
	
	
	

