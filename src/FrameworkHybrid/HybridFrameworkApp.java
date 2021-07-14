package FrameworkHybrid;

import org.testng.annotations.Test;

import FrameworkKeywordDrivenTesting.Utils.methods;

public class HybridFrameworkApp {

	@Test
	public void appTest() {

		String[][] data = ReadExceltoMassive.getData("src/HybridFramework/Login.xlsx", "data", 2);
		String[][] cases = ReadExceltoMassive.getData("src/HybridFramework/Login.xlsx", "cases", 7);

		// цикл по входным данным
		for (int j = 1; j < data.length; j++) {
			// цикл по шагам
			for (int i = 1; i < cases.length; i++) {

				switch (cases[i][3]) {
				case "openBrowser":
					methods.openBrowser();
					break;

				case "navigateTo":
					methods.navigateTo(cases[i][6]);
					break;

				case "enterUsername":
					methods.enterUsername(cases[i][4], cases[i][5], data[j][1]);
					break;

				case "enterPassword":
					methods.enterPassword(cases[i][4], cases[i][5], data[j][2]);
					break;

				case "clickSubmit":
					methods.clickSubmit(cases[i][4], cases[i][5], cases[i][6]);
					break;

				case "verifyMessage":
					methods.verifyMessage(cases[i][4], cases[i][5], cases[i][6]);
					break;

				case "closeBrowser":
					methods.closeBrowser();
					break;

				}
			}
		}
	}
}
