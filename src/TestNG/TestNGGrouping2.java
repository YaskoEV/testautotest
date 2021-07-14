package TestNG;


import org.testng.annotations.*;

//@Test (groups= {"C"})
public class TestNGGrouping2 {

	  @Test(groups= {"B"}, priority = 5, dependsOnMethods = {"G3"}, enabled = true)
	  public void G1() {
	  }
	  
	  public void G2() {
	  }
	  
	  @Test (groups= {"D","A"})
	  public void G3() {
	  }	
	  
	  @Test (groups= {"A", "C"})
	  public void G4() {
	  }
	  
	  @Test (groups= {"D"})
	  public void G5() {
	  }


}
