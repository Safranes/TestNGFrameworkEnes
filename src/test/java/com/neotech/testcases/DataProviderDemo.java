package com.neotech.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.ExcelUtility;

public class DataProviderDemo {

	@Test(dataProvider = "excelData")
	public void printInformation(String firstName, String lastName, String age) {
		System.out.println("Full name & Age -> " + firstName + " " + lastName + ", " + age);
		System.out.println();
	}

	@DataProvider(name = "excelData")
	public Object[][] dataFromExcel() {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/DataProviderDemo.xlsx";
		String sheet = "Data";

		Object[][] data = ExcelUtility.excelIntoArray(filePath, sheet);

		return data;
	}

	@DataProvider
	public Object[][] createData() {
		Object[][] data = { 
				{ "John", "Smith", 25 }, 
				{ "Mary", "Brown", 23 } 
		};

		return data;
	}
}