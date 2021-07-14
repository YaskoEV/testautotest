package TestNG;


import org.testng.annotations.*;

public class TestNGGrouping1 {
	
	  @Test(groups= {"D"})
	  public void F1() {
	  }
	  @Test (groups= {"C"})
	  public void F2() {
	  }
	  @Test (groups= {"C","D"})
	  public void F3() {
	  }
	  @Test (groups= {"C"})
	  public void F4() {
	  }
	  @Test (groups= {"C"})
	  public void F5() { 
	  }
	  
	  @BeforeGroups(groups = "B")
	  public void beforeGroup() {
		  System.out.println("====beforeGroupB");
	  }

	  @AfterGroups
	  public void afterGroup() {
		  System.out.println("====afterGroup");
	  }


}
