package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestNG {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
		 driver = new ChromeDriver();// will launch the brower
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://digitechinc.in/demos/1swishzz_staging/admin");
		System.out.println("Before method Annotstion");
	}
	@Test(groups="URL")
	public void lanchurl() {
		boolean val=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]")).isDisplayed();
		System.out.println("url launched successfully in the chrome browser");
		System.out.println(val);//true
	}
	@Test(priority=1,groups="LOGIN",dependsOnMethods="lanchurl")
	public void Loginmodule() throws InterruptedException {
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[]/input[1]")).sendKeys("admin@admin.com");
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]")).click();
		Thread.sleep(2000);
		System.out.println("logged in successful");
		
			}
	@Test(priority=2,groups="LOGIN",dependsOnMethods="Loginmodule")
	public void Loginmodulewithinvalid() throws InterruptedException {
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).sendKeys("admin@admin1.com");
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]")).click();
		Thread.sleep(2000);
		System.out.println("logged in not successful");
		
			}
	@Test(priority=3,groups="LOGIN",dependsOnMethods="Loginmodule")
	public void Loginmodulewithinvalidpass() throws InterruptedException {
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[]/input[1]")).sendKeys("admin@admin.com");
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys("1234567");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]")).click();
		Thread.sleep(2000);
		System.out.println("logged in not successful");
		
			}
	@AfterMethod
	public void tearDown() {
		System.out.println("After method Annotstion");
		driver.close();
	}
}
