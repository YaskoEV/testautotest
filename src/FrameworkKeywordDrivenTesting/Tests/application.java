package FrameworkKeywordDrivenTesting.Tests;

import FrameworkKeywordDrivenTesting.Utils.ReadExceltoMassive;
import FrameworkKeywordDrivenTesting.Utils.methods;

import org.testng.annotations.*;

public class application {

	@Test
	public void Test() {
		String[][] data = ReadExceltoMassive.getData("src\\FrameworkKeywordDrivenTesting\\Data\\FacebookLogin.xlsx","cases",1, 7);
		for (int i=1;i<data.length;i++) {
			
			switch(data[i][3]) {
			case "openBrowser":
				methods.openBrowser();
				break;
				
			case "navigateTo":
				methods.navigateTo(data[i][6]);
				break;
	
			case "enterUsername":
				methods.enterUsername(data[i][4],data[i][5],data[i][6]);
				break;
				
			case "enterPassword":
				methods.enterPassword(data[i][4],data[i][5],data[i][6]);
				break;
			
			case "clickSubmit":
				methods.clickSubmit(data[i][4],data[i][5],data[i][6]);
				break;
				
			case "verifyMessage":
				methods.verifyMessage(data[i][4],data[i][5],data[i][6]);
				break;
				
				
			case "closeBrowser":
				methods.closeBrowser();
				break;

			}
		}

	}
}
