package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ParallelTest {
	
  @Test
  public void One() {
	  System.out.println("method 1. Thread id = " + Thread.currentThread().getId());
  }
  
  @Test
  public void Two() {
	  System.out.println("method 2. Thread id = " + Thread.currentThread().getId());
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method. Thread id = " + Thread.currentThread().getId());
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method. Thread id = " + Thread.currentThread().getId());
  }

}
