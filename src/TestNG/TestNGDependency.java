package TestNG;


import org.testng.annotations.*;

public class TestNGDependency {
	
	  @Test(groups= {"C"}, dependsOnMethods = {"B"})
	  public void A() {
	  }
	  @Test (dependsOnGroups = "B")
	  public void B() {
	  }
	  @Test (groups= {"B"})
	  public void C() {
	  }



}
