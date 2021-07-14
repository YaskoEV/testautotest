package TestNG;


import org.testng.annotations.*;

public class TestNGPriority {
	
	  @Test(priority = 4)
	  public void P1_set5() {
	  }
	  @Test (priority = 1)
	  public void P2_set1() {
	  }
	  @Test (priority = 4)
	  public void P3_set4() {
	  }
	  @Test ()
	  public void P4() {
	  }
	  @Test (priority = 1)
	  public void P5_set1() {
	  }


}
