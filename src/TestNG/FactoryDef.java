package TestNG;

import org.testng.annotations.Factory;

public class FactoryDef {
	
	@Factory
	public Object[] factoryMethod() {
		return new Object[] { new FactoryTest(), new FactoryTest() };
	}

}
