package OraHRM_Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//
public class Login_Assertions {
	WebDriver d;
@BeforeTest
public void setup3() {
	String baseUrl = "https://opensource-demo.orangehrmlive.com/";
	System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
	d = new FirefoxDriver();
	d.get(baseUrl);
	d.manage().window().maximize();
}
	

	@Test(dataProvider="DP")  // code for parameters taking from data providers 
	public void setData(String username, String password)throws InterruptedException
	{
		
		WebElement sf=d.findElement(By.id("txtUsername"));
//		sf.clear();
		sf.sendKeys(username);
		System.out.println("Your Username is "+username+" and Parameter is passed from Data Provider");
		WebElement sf1=d.findElement(By.id("txtPassword"));
//		sf1.clear();
		sf1.sendKeys(password);
		System.out.println("Your Username is "+password+" and Parameter is passed from Data Provider");
		d.findElement(By.id("btnLogin")).click();
		
		
		
		//Assertions
		if(d.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
			d.findElement(By.xpath("//a[@id='welcome']")).click();
			Thread.sleep(2000);

			d.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();
            Thread.sleep(2000);
			System.out.println("Correct Credentials are given");
		}
		else {
			d.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			System.out.println("Wrong credentials given !!! Can't login..");
			
		}
	}
	
	
	@DataProvider(name="DP")  //parameter passing 
	public Object[][] dataDemo(){
		return new Object[][] {
			{
				"adarsh","adarsh@123"
			},{
				"Shubham","shubham123"
			},{
				"Sonal","Sonal123"
				},
			{
				"Admin","admin123"
					
				}
		    };
		    
	
	
	
}}