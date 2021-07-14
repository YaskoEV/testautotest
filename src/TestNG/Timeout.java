package TestNG;

import org.testng.annotations.Test;

public class Timeout {
  @Test   (timeOut = 200 )
  public void f() throws InterruptedException {
	  Thread.sleep(300);
	  System.out.println("Timeout 300");
  }
  
  @Test (timeOut = 200 )
  public void d() throws InterruptedException {
	  Thread.sleep(100);
	  System.out.println("Timeout 100");
  }
}
