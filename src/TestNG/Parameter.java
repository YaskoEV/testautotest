package TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	@Parameters({ "param" })
	@Test
  public void f(String param) {
		System.out.println("Test one suite param is: " + param);
  }
	
	@Parameters({ "param", "optionalParam" })
	@Test
	  public void d( String param,  @Optional("default  value") String optionalParam) {
			System.out.println("Test one suite param is: " + param + "Test two  suite param is: " + optionalParam );
	  }
	
	@Parameters({ "param", "optionalParam" })
	@Test
	  public void a( String param, String optionalParam) {
			System.out.println("Test one suite param is: " + param + "Test two  suite param is: " + optionalParam );
	  }
	  
}
