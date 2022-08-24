package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ParametersFeature2 {

	WebDriver driver;

	@Test
	@Parameters({ "browser", "url", "emailid", "password" })
	public void setUp(String browser, String url, String emailid, String password) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
			driver = new ChromeDriver();// will launch the brower
		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).sendKeys(emailid);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys(password);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]")).click();

	}

}
