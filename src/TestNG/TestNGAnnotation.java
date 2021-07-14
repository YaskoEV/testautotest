package TestNG;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAnnotation {
	 @Test
	 public void T1() {
		System.out.println("====Test 1");
		  }
	 @Test 
	 	public void T2() {
		 System.out.println("====Test 2");
		  }

	  @Test(groups = "C")
	  public void T3() {
		  System.out.println("====Test 3");
	  }
	  
	  @BeforeGroups
	  public void beforeGroup() {
		  System.out.println("====beforeGroup");
	  }

	  @AfterGroups
	  public void afterGroup() {
		  System.out.println("====afterGroup");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("====beforeMethod");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("====afterMethod");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("====beforeClass");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("====afterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("====beforeTest");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("====afterTest");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("====beforeSuite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("====afterSuite");
	  }

}
