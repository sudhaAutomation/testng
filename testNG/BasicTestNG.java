package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BasicTestNG {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before Suite annotaion");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Annotation");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class annotation");
	}

	@BeforeMethod // preconditions you will mainatin in this method
	public void beforeMethod() {
		System.out.println("Before Mthod Execution");
	}

	@Test // this is only the test case
	public void Test() {
		System.out.println("My Test Case");
		
	}
	@Test
	public void Test2() {
		System.out.println("MY second Test Case");
	}
	@AfterMethod // post conditions of the test case you will maintain in after method
	public void afterMethod() {
		System.out.println("After Method execution");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class Execution");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test execution");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite Annotation");
	}

}
